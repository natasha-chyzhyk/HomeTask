package com.natasha.abstractdao.dao.abstr;

import com.natasha.abstractdao.model.BaseDbModel;
import com.natasha.abstractdao.model.GroupDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 15.01.2017.
 */
public abstract class AbstractModelDAO<T extends BaseDbModel> {

    protected static final String SQL_SELECT_TEMPLATE = "SELECT * FROM %s WHERE %s;";
    protected static final String SQL_SELECT_ALL_TEMPLATE = "SELECT * FROM %s;";

    protected abstract String getColumnIdName();
    protected abstract String getTableName();
    protected abstract T getModelFromResultSet(ResultSet rs) throws SQLException;

    private Connection dbConn;

    public AbstractModelDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }

    protected Connection getDbConnection() {
        return dbConn;
    }


    public T getModelById(long id) throws SQLException {
        String where = getWhereForEquals(getColumnIdName(), id);
        String sql = String.format(SQL_SELECT_TEMPLATE, getTableName(), where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return (rs.first()) ? getModelFromResultSet(rs) : null;
    }

    public List<T> getModelsByIds(List<Long> ids) throws SQLException {
        String where = getWhereForIN(getColumnIdName(), ids);
        String sql = String.format(SQL_SELECT_TEMPLATE, getTableName(), where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
    }

    public List<T> getAllModels() throws SQLException {
        String sql = String.format(SQL_SELECT_ALL_TEMPLATE, getTableName());
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
    }


    /***************************************************************************************************************/

    protected List<T> getModelsForWhere(String where) throws SQLException {
        String sql = String.format(SQL_SELECT_TEMPLATE, getTableName(), where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
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


    protected String getWhereForEquals(String colName, long value) {
        return String.format("(%s = %d)", colName, value);
    }

    private String getWhereForIN(String colName, List<Long> ids) {
        StringBuilder sb = new StringBuilder("("+colName+" IN (");
        for (int i=0; i<ids.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(ids.get(i));
        }
        sb.append("))");
        return sb.toString();
    }
}
