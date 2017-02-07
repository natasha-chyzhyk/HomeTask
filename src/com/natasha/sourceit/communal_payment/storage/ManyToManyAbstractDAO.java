package com.natasha.sourceit.communal_payment.storage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public abstract class ManyToManyAbstractDAO implements TableManager {

    private Connection dbConn;

    public ManyToManyAbstractDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }

    protected List<Long> selectOneIdForAnother(String columnNameToSelect, String conditionColumnName, long conditionValue) throws SQLException {
        String sql = String.format("SELECT %s FROM %s WHERE %s = %d", columnNameToSelect, tableName(), conditionColumnName, conditionValue);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);
        List<Long> ids = new ArrayList<>();
        if (rs.first()) {
            do {
                ids.add(rs.getLong(columnNameToSelect));
            } while (rs.next());
        }
        return ids;
    }
}
