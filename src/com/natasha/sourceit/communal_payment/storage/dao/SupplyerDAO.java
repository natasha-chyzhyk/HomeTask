package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.impl.BuildingDbModel;
import com.natasha.sourceit.communal_payment.model.impl.CredentialsDbModel;
import com.natasha.sourceit.communal_payment.model.impl.SupplyerDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class SupplyerDAO extends SingleIdAbstractDAO<SupplyerDbModel> {
    private static final String TABLE_NAME = "supplyer";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_ADDRESS = "id_building";
    private static final String COLUMN_CREDENTIALS = "id_credentials";

    private static final String CREATOR = String.format("CREATE TABLE `%1$s` (\n" +
            "  `%2$s` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `%3$s` VARCHAR(45) NOT NULL,\n" +
            "  `%4$s` INT NOT NULL,\n" +
            "  `%5$s` INT NOT NULL,\n" +
            "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME,
            COLUMN_ID,
            COLUMN_TITLE,
            COLUMN_ADDRESS,
            COLUMN_CREDENTIALS);

    public SupplyerDAO(Connection dbConn) {
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
    
    
    private CredentialsDbModel cachedCreeds;
    
    public SupplyerDbModel selectForCredentials(CredentialsDbModel creeds) throws SQLException {
        cachedCreeds = creeds;
        List<SupplyerDbModel> models = selectForWhere(COLUMN_CREDENTIALS+" = "+creeds.getId());
        return (models.size() > 0) ? models.get(0) : null;
    }
    

    @Override
    protected SupplyerDbModel getModelFromResultSet(ResultSet rs) throws SQLException {

        long credId = rs.getLong(rs.findColumn(COLUMN_CREDENTIALS));
        long builId = rs.getLong(rs.findColumn(COLUMN_ADDRESS));
        
        CredentialsDbModel creeds = cachedCreeds;
        if (creeds == null || creeds.getId() != credId) {
            creeds = new CredentialsDAO(getDbConn()).selectModelById(credId);
        }
        BuildingDbModel buildingDbModel = new BuildingDAO(getDbConn()).selectModelById(builId);

        return SupplyerDbModel.builder(rs.getLong(rs.findColumn(COLUMN_ID)))
                .setTitle(rs.getString(rs.findColumn(COLUMN_TITLE)))
                .setStreetAddress(buildingDbModel)
                .setCredentials(creeds).build();
    }
}
