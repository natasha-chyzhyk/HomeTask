package com.natasha.sourceit.communal_payment.storage;

import com.natasha.sourceit.communal_payment.model.DoubleIdDbModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Stas on 29.01.2017.
 */
public abstract class DoubleIdAbstractDAO<T extends DoubleIdDbModel> implements TableManager {

    protected abstract String getColumnId1Name();
    protected abstract String getColumnId2Name();
    protected abstract String getCreatorSql();

    private Connection dbConn;

    public DoubleIdAbstractDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }

    @Override
    public void addCreationSqlToBatch(Statement stmt) throws SQLException {
        stmt.addBatch(getCreatorSql());
    }

    public Connection getDbConn() {
        return dbConn;
    }
}
