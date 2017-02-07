package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.impl.BuildingDbModel;
import com.natasha.sourceit.communal_payment.model.impl.FlatDbModel;
import com.natasha.sourceit.communal_payment.model.impl.FlatOwnerDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stas on 29.01.2017.
 */
public class FlatDAO extends SingleIdAbstractDAO<FlatDbModel> {
    private static final String TABLE_NAME = "flat";

    public static final String COLUMN_ID = "id";
    private static final String COLUMN_SQUARE = "square";
    public static final String COLUMN_FLAT_NUMBER = "flat_number";
    public static final String COLUMN_OWNER = "id_owner";
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


    public List<Map<String, Object>> selectListModelsForBuildings(List<BuildingDbModel> buildings) throws SQLException {
        List<Long> ids = new ArrayList<>(buildings.size());
        Map<Long, BuildingDbModel> bMap = new HashMap<>();
        for (BuildingDbModel b : buildings) {
            ids.add(b.getId());
            bMap.put(b.getId(), b);
        }


        List<Map<String, Object>> result = new ArrayList<>();
        String where = buildWhereForIN(COLUMN_ADDRESS, ids);
        ResultSet rs = selectRsForWhere(where);
        if (rs.first()) {
            do {
                Map<String, Object> item = new HashMap<>();

                item.put(COLUMN_ID, rs.getLong(COLUMN_ID));
                item.put(COLUMN_FLAT_NUMBER, rs.getInt(COLUMN_FLAT_NUMBER));
                BuildingDbModel building = bMap.get(rs.getLong(COLUMN_ADDRESS));
                item.put(BuildingDAO.COLUMN_CITY, building.getCity());
                item.put(BuildingDAO.COLUMN_STREET, building.getStreet());
                item.put(BuildingDAO.COLUMN_BUILDING_NUM, building.getHouse());
                item.put(COLUMN_OWNER, rs.getLong(COLUMN_OWNER));

                result.add(item);
            } while (rs.next());
        }
        return result;
    }
}
