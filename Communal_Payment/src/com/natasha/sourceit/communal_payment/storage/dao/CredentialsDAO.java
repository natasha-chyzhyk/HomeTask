package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.impl.CredentialsDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class CredentialsDAO extends SingleIdAbstractDAO<CredentialsDbModel> {

    private static final String TABLE_NAME = "credentials";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_PASSWORD = "password";


    public static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
            "  `%2$s` INT NOT NULL AUTO_INCREMENT, " +
            "  `%3$s` VARCHAR(45) NOT NULL, " +
            "  `%4$s` VARCHAR(45) NOT NULL, " +
            "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME,
            COLUMN_ID,
            COLUMN_LOGIN,
            COLUMN_PASSWORD);

    public CredentialsDAO(Connection dbConn) {
        super(dbConn);
    }

    @Override
    protected String getColumnIdName() {
        return COLUMN_ID;
    }

    @Override
    protected String getCreatorSql() {
        return CREATOR;
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

    @Override
    protected CredentialsDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        CredentialsDbModel credentialsDbModel = new CredentialsDbModel((rs.getLong(rs.findColumn(COLUMN_ID))),
                rs.getString(rs.findColumn(COLUMN_LOGIN)), rs.getString(rs.findColumn(COLUMN_PASSWORD)));
        return credentialsDbModel;
    }
    
    public CredentialsDbModel selectForLogin(String login) throws SQLException {
        List<CredentialsDbModel> models = selectForWhere(String.format("%s = '%s'", CredentialsDAO.COLUMN_LOGIN, login));
        return (models.size() > 0) ? models.get(0) : null;
    }
}
