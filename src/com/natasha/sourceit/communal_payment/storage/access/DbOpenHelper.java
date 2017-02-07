package com.natasha.sourceit.communal_payment.storage.access;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class DbOpenHelper {

    public interface OnDbCreationListener {
        void onDbCreated(Connection conn) throws SQLException;
    }


    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private String host;
        private int port;
        private String dbName;
        private String user;
        private String password;
        private OnDbCreationListener listener;
        private Builder(){}

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setDbName(String dbName) {
            this.dbName = dbName;
            return this;
        }

        public Builder setCredentials(String user, String password) {
            this.user = user;
            this.password = password;
            return this;
        }

        public Builder setDbCreationListener(OnDbCreationListener l) {
            listener = l;
            return this;
        }

        public DbOpenHelper build() throws ClassNotFoundException, SQLException {
            String url = String.format("jdbc:mysql://%s:%d/", host, port);
            return new DbOpenHelper(url, dbName, user, password, listener);
        }
    }


    private DbOpenHelper(String dbServerUrl, String dbName, String user, String password, OnDbCreationListener l) throws ClassNotFoundException, SQLException {
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.jdbc.Driver");
        if (!checkDbExists(dbServerUrl, dbName)) {
            connection = createDatabase(dbServerUrl, dbName);
            if (l != null) l.onDbCreated(connection);
        } else {
            connection = DriverManager.getConnection(dbServerUrl+dbName, user, password);
        }
    }

    private String user, password;
    private Connection connection;


    public Connection getConnection() {
        return connection;
    }




    private boolean checkDbExists(String dbServerUrl, String dbName) throws SQLException {
        ResultSet rs = DriverManager.getConnection(dbServerUrl, user, password).getMetaData().getCatalogs();
        while(rs.next()) {
            if (dbName.equals(rs.getString(1))){
                return true;
            }
        }
        return false;
    }

    private Connection createDatabase(String dbServerUrl, String dbName) throws SQLException {
        DriverManager.getConnection(dbServerUrl, user, password).createStatement().execute("CREATE DATABASE "+dbName);
        return DriverManager.getConnection(dbServerUrl+dbName, user, password);
    }
}
