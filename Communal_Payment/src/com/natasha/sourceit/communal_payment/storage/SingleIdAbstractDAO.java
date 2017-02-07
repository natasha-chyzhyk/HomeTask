package com.natasha.sourceit.communal_payment.storage;

import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public abstract class SingleIdAbstractDAO<T extends SingleIdDbModel> implements TableManager {
    protected static final String SQL_SELECT_TEMPLATE = "SELECT * FROM %s WHERE %s;";
    protected static final String SQL_SELECT_ALL_TEMPLATE = "SELECT * FROM %s;";


    protected abstract String getColumnIdName();
    protected abstract String getCreatorSql();
    protected abstract T getModelFromResultSet(ResultSet rs) throws SQLException;

    private Connection dbConn;

    public SingleIdAbstractDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }

    @Override
    public void addCreationSqlToBatch(Statement stmt) throws SQLException {
        stmt.addBatch(getCreatorSql());
    }

    protected Connection getDbConn() {
        return dbConn;
    }

    /*********************************  SELECTIONS  **********************************/
    public T selectModelById(long id) throws SQLException {
        String where = buildWhereForEquals(getColumnIdName(), id);
        String sql = String.format(SQL_SELECT_TEMPLATE, tableName(), where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return (rs.first()) ? getModelFromResultSet(rs) : null;
    }

    public List<T> selectModelsByIds(List<Long> ids) throws SQLException {
        String where = buildWhereForIN(getColumnIdName(), ids);
        String sql = String.format(SQL_SELECT_TEMPLATE, tableName(), where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
    }

    public List<T> selectAllModels() throws SQLException {
        String sql = String.format(SQL_SELECT_ALL_TEMPLATE, tableName());
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
    }


    /**
     * This is main abstract selector, which can be used by children
     * @param where
     * @return
     * @throws SQLException
     */
    protected final List<T> selectForWhere(String where) throws SQLException {
        String sql = String.format(SQL_SELECT_TEMPLATE, tableName(), where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
    }


    protected final ResultSet selectRsForWhere(String where) throws SQLException {
        String sql = String.format(SQL_SELECT_TEMPLATE, tableName(), where);
        return dbConn.createStatement().executeQuery(sql);
    }



    /**************************  HElpers  *****************8*************/
    protected String buildWhereForEquals(String colName, long value) {
        return String.format("(%s = %d)", colName, value);
    }

    protected String buildWhereForIN(String colName, List<Long> ids) {
        if (ids.size() > 0) {
            StringBuilder sb = new StringBuilder("("+colName+" IN (");
            for (int i=0; i<ids.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(ids.get(i));
            }
            sb.append("))");
            return sb.toString();
        } else {
            return String.format("(%s IN (0))", colName);
        }
    }

    private List<T> buildAllModelsFromResultSet(ResultSet rs) throws SQLException {
        List<T> models = new ArrayList<>();
        if (rs.first()) {
            do {
                models.add(getModelFromResultSet(rs));
            } while (rs.next());
        }
        return models;
    }



}
