package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.storage.ManyToManyAbstractDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class FlatServiceRelationDAO extends ManyToManyAbstractDAO {

    private static final String TABLE_NAME = "flat_service";

    private static final String COLUMN_FLAT = "id_flat";
    private static final String COLUMN_SERVICE = "id_service";

    private static final String CREATION = String.format("CREATE TABLE IF NOT EXISTS `%1$s` (`%2$s` INT(11) NOT NULL, `%3$s` INT(11) NOT NULL, PRIMARY KEY(`%2$s`, `%3$s`)) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;",
            TABLE_NAME, COLUMN_FLAT, COLUMN_SERVICE);

    public FlatServiceRelationDAO(Connection dbConn) {
        super(dbConn);
    }

    @Override
    public void addCreationSqlToBatch(Statement stmt) throws SQLException {
        stmt.addBatch(CREATION);
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }


    public List<Long> selectFlatIdsForService(long serviceId) throws SQLException {
        return selectOneIdForAnother(COLUMN_FLAT, COLUMN_SERVICE, serviceId);
    }

    public List<Long> selectServiceIdsForFlat(long flatId) throws SQLException {
        return selectOneIdForAnother(COLUMN_SERVICE, COLUMN_FLAT, flatId);
    }
}
