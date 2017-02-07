package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.StreetAddress;
import com.natasha.sourceit.communal_payment.model.impl.BankDbModel;
import com.natasha.sourceit.communal_payment.model.impl.BuildingDbModel;
import com.natasha.sourceit.communal_payment.model.impl.CredentialsDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class BankDAO extends SingleIdAbstractDAO<BankDbModel> {
    private static final String TABLE_NAME = "bank";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_BUILDING = "id_building";
    private static final String COLUMN_CREDENTIALS = "id_credentials";

    public static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
                    "  `%2$s` INT NOT NULL AUTO_INCREMENT, " +
                    "  `%3$s` VARCHAR(45) NOT NULL, " +
                    "  `%4$s` INT NOT NULL, " +
                    "  `%5$s` INT NOT NULL, " +
                    "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME,
            COLUMN_ID,
            COLUMN_TITLE,
            COLUMN_BUILDING,
            COLUMN_CREDENTIALS);


    public BankDAO(Connection dbConn) {
        super(dbConn);
    }

    @Override
    protected BankDbModel getModelFromResultSet(ResultSet rs) throws SQLException {

        long credId = rs.getLong(rs.findColumn(COLUMN_CREDENTIALS));
        long bilId = rs.getLong(rs.findColumn(COLUMN_BUILDING));

        CredentialsDbModel creeds = cachedCreeds;
        if (creeds == null || creeds.getId() != credId) {
            creeds = new CredentialsDAO(getDbConn()).selectModelById(credId);
        }
        BuildingDbModel buildingDbModel = new BuildingDAO(getDbConn()).selectModelById(bilId);

        return BankDbModel.builder(rs.getLong(rs.findColumn(COLUMN_ID)))
                .setTitle(rs.getString(rs.findColumn(COLUMN_TITLE)))
                .setAddress(buildingDbModel)
                .setCredentials(creeds).build();
    }

    private CredentialsDbModel cachedCreeds;
    
    public BankDbModel selectForCredentials(CredentialsDbModel creeds) throws SQLException {
        cachedCreeds = creeds;
        List<BankDbModel> models = selectForWhere(COLUMN_CREDENTIALS+" = "+creeds.getId());
        return (models.size() > 0) ? models.get(0) : null;
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
    protected String getColumnIdName() {
        return COLUMN_ID;
    }
}
