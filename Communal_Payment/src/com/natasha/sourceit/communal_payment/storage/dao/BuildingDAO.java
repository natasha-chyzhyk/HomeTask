package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.impl.BuildingDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class BuildingDAO extends SingleIdAbstractDAO<BuildingDbModel> {
    private static final String TABLE_NAME = "buildingaddress";

    private static final String COLUMN_ID = "id";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STREET = "street";
    public static final String COLUMN_BUILDING_NUM = "building_number";

    public static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
            "  `%2$s` INT NOT NULL, " +
            "  `%3$s` VARCHAR(45) NOT NULL, " +
            "  `%4$s` VARCHAR(128) NOT NULL, " +
            "  `%5$s` INT NOT NULL, " +
            "  PRIMARY KEY (`%2$s`)); ",
            TABLE_NAME,
            COLUMN_ID,
            COLUMN_CITY,
            COLUMN_STREET,
            COLUMN_BUILDING_NUM);


    public BuildingDAO(Connection dbConn) {
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
    protected BuildingDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        BuildingDbModel building = new BuildingDbModel((rs.getLong(rs.findColumn(COLUMN_ID))),
                rs.getString(rs.findColumn(COLUMN_CITY)),
                rs.getString(rs.findColumn(COLUMN_STREET)),
                rs.getInt(rs.findColumn(COLUMN_BUILDING_NUM)));

        return building;
    }


    public List<BuildingDbModel> selectHouse(String city, String street, String houseNum) throws SQLException {
        String where = String.format("(%s = '%s' AND %s = '%s' AND %s = '%s')", COLUMN_CITY, city, COLUMN_STREET, street, COLUMN_BUILDING_NUM, houseNum);
        return selectForWhere(where);
    }

    public List<BuildingDbModel> selectForCityAndStreet(String city, String street) throws SQLException {
        String where = String.format("(%s = '%s' AND %s = '%s')", COLUMN_CITY, city, COLUMN_STREET, street);
        return selectForWhere(where);
    }

    public List<BuildingDbModel> selectForCity(String city) throws SQLException {
        String where = String.format("(%s = '%s')", COLUMN_CITY, city);
        return selectForWhere(where);
    }
}
