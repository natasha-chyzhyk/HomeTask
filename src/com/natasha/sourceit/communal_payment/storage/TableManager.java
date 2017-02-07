package com.natasha.sourceit.communal_payment.storage;

import java.sql.SQLException;
import java.sql.Statement;


public interface TableManager {

    void addCreationSqlToBatch(Statement stmt) throws SQLException;
    String tableName();

}
