package com.natasha.sourceit.task_jdbc.dao.abstr;

import com.natasha.sourceit.task_jdbc.model.AccountDbModel;
import com.natasha.sourceit.task_jdbc.model.SchoolDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class SchoolDAO extends AbstractModelDAO<SchoolDbModel>{

    private static final String TABLE_NAME = "vasya.school";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_FLOORS = "floors";


    public SchoolDAO(Connection dbConn) {
        super(dbConn);
    }

    @Override
    protected String getColumnIdName() {
        return COLUMN_ID;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected SchoolDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        SchoolDbModel school = new SchoolDbModel(rs.getInt(rs.findColumn(COLUMN_ID)));
        school.setAddress(rs.getString(rs.findColumn(COLUMN_ADDRESS)));
        school.setNumber(rs.getString(rs.findColumn(COLUMN_NUMBER)));
        school.setFloors(rs.getInt(rs.findColumn(COLUMN_FLOORS)));

        RoomDAO room = new RoomDAO(getDbConnection());
        school.setRooms(room.getRoomsRorSchool(school));

        return school;
    }
}
