package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.impl.AccountDbModel;
import com.natasha.sourceit.communal_payment.model.impl.CredentialsDbModel;
import com.natasha.sourceit.communal_payment.model.impl.FlatOwnerDbModel;
import com.natasha.sourceit.communal_payment.model.impl.HumanDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Stas on 29.01.2017.
 */
public class FlatOwnerDAO extends SingleIdAbstractDAO<FlatOwnerDbModel> {
    private static final String TABLE_NAME = "flatowner";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_MIDDLE_NAME = "middle_name";
    private static final String COLUMN_LIVING_FLAT= "id_flat";
    private static final String COLUMN_OWN_FLAT = "id_own_flat";
    private static final String COLUMN_CREDENTIALS = "id_credentials";

    private static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
                    "  `%2$s` INT NOT NULL AUTO_INCREMENT, " +
                    "  `%3$s` VARCHAR(45) NOT NULL, " +
                    "  `%4$s` VARCHAR(45) NOT NULL, " +
                    "  `%5$s` VARCHAR(45) NULL, " +
                    "  `%6$s` INT NULL, " +
                    "  `%7$s` INT NULL, " +
                    "  `%8$s` INT NULL, " +
                    "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME ,
            COLUMN_ID ,
            COLUMN_FIRST_NAME,
            COLUMN_LAST_NAME,
            COLUMN_MIDDLE_NAME,
            COLUMN_LIVING_FLAT,
            COLUMN_OWN_FLAT,
            COLUMN_CREDENTIALS);

    public FlatOwnerDAO(Connection dbConn) {
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
    protected FlatOwnerDbModel getModelFromResultSet(ResultSet rs) throws SQLException {

        long credId = rs.getLong(rs.findColumn(COLUMN_CREDENTIALS));

        CredentialsDbModel credentialsDbModel = new CredentialsDAO(getDbConn()).selectModelById(credId);

        return (FlatOwnerDbModel)FlatOwnerDbModel.builder(rs.getLong(rs.findColumn(COLUMN_ID)))
                .setOwnFlatId(rs.getLong(rs.findColumn(COLUMN_OWN_FLAT)))
                .setCredentials(credentialsDbModel)
                .setFirstName(rs.getString(rs.findColumn(COLUMN_FIRST_NAME)))
                .setLastName(rs.getString(rs.findColumn(COLUMN_LAST_NAME)))
                .setMiddleName(rs.getString(rs.findColumn(COLUMN_MIDDLE_NAME)))
                .setLivingFlatId(rs.getLong(rs.findColumn(COLUMN_LIVING_FLAT)))
                .build();

    }
}
