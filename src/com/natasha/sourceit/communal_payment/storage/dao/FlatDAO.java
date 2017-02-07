package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.impl.BuildingDbModel;
import com.natasha.sourceit.communal_payment.model.impl.FlatDbModel;
import com.natasha.sourceit.communal_payment.model.impl.FlatOwnerDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class FlatDAO extends SingleIdAbstractDAO<FlatDbModel> {
    private static final String TABLE_NAME = "flat";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SQUARE = "square";
    private static final String COLUMN_FLAT_NUMBER = "flat_number";
    private static final String COLUMN_OWNER = "id_owner";
    private static final String COLUMN_ADDRESS= "id_building";
    public static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
                    "  `%2$s` INT NOT NULL AUTO_INCREMENT, " +
                    "  `%3$s` INT NOT NULL, " +
                    "  `%4$s` FLOAT NOT NULL, " +
                    "  `%5$s` INT NOT NULL, " +
                    "  `%6$s` INT NOT NULL, " +
                    "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME,
            COLUMN_ID,
            COLUMN_FLAT_NUMBER,
            COLUMN_SQUARE,
            COLUMN_OWNER,
            COLUMN_ADDRESS);

    public FlatDAO(Connection dbConn) {
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
    protected FlatDbModel getModelFromResultSet(ResultSet rs) throws SQLException {

        long flatId = rs.getLong(rs.findColumn(COLUMN_ID));
        long ownerId = rs.getLong(rs.findColumn(COLUMN_OWNER));
        long buildingId = rs.getLong(rs.findColumn(COLUMN_ADDRESS));

        FlatOwnerDbModel owner = new FlatOwnerDAO(getDbConn()).selectModelById(ownerId);
        BuildingDbModel building = new BuildingDAO(getDbConn()).selectModelById(buildingId);

        HumanDAO humanDAO = new HumanDAO(getDbConn());

        ServiceDAO serviceDAO = new ServiceDAO(getDbConn());

        List<Long> servIds = new FlatServiceRelationDAO(getDbConn()).selectServiceIdsForFlat(flatId);

        return FlatDbModel.builder(flatId)
                .setSquare(rs.getFloat(rs.findColumn(COLUMN_SQUARE)))
                .setFlatNumber(rs.getByte(rs.findColumn(COLUMN_FLAT_NUMBER)))
                .setOwner(owner)
                .setStreetAddress(building)
                .setOccupants(humanDAO.getHumanForFlatId(rs.getInt(rs.findColumn(COLUMN_ID))))
                .setServices(serviceDAO.selectModelsByIds(servIds))
                .build();

    }
}
