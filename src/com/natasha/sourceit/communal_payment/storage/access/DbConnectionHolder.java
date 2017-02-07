package com.natasha.sourceit.communal_payment.storage.access;

import com.natasha.sourceit.communal_payment.storage.dao.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Stas on 29.01.2017.
 */
public class DbConnectionHolder {
    public static final String DB_HOST = "localhost";
    public static final int DB_PORT = 3306;
    public static final String DB_NAME = "communals";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "123";




    private static DbOpenHelper dbHelper;

    /**
     * The only point where the whole application can get DB connection instance
     * @return
     */
    public static Connection getConnection() throws SQLException {
        if (dbHelper == null) {
            try {
                createHelper();
            } catch (ClassNotFoundException e) {
                throw new SQLException("No MySQL JDBC Driver", e);
            }
        }
        return dbHelper.getConnection();
    }

    private static synchronized void createHelper() throws SQLException, ClassNotFoundException {
        if (dbHelper == null) {
            dbHelper = DbOpenHelper.builder()
                    .setHost(DB_HOST)
                    .setPort(DB_PORT)
                    .setDbName(DB_NAME)
                    .setCredentials(DB_USER, DB_PASSWORD)
                    .setDbCreationListener(dbCreationListener)
                    .build();
        }
    }

    private static DbOpenHelper.OnDbCreationListener dbCreationListener = new DbOpenHelper.OnDbCreationListener() {
        @Override
        public void onDbCreated(Connection conn) throws SQLException {
            Statement stmt = conn.createStatement();
            new FlatServiceRelationDAO(conn).addCreationSqlToBatch(stmt);
            new ServiceDAO(conn).addCreationSqlToBatch(stmt);
            new BillDAO(conn).addCreationSqlToBatch(stmt);
            new SupplyerDAO(conn).addCreationSqlToBatch(stmt);
            new FlatDAO(conn).addCreationSqlToBatch(stmt);
            new AccountDAO(conn).addCreationSqlToBatch(stmt);
            new PaymentDAO(conn).addCreationSqlToBatch(stmt);
            new HumanDAO(conn).addCreationSqlToBatch(stmt);
            new FlatOwnerDAO(conn).addCreationSqlToBatch(stmt);
            new CredentialsDAO(conn).addCreationSqlToBatch(stmt);
            new BuildingDAO(conn).addCreationSqlToBatch(stmt);
            new BankDAO(conn).addCreationSqlToBatch(stmt);
            stmt.executeBatch();
        }
    };
}
