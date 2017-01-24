package com.natasha.sourceit.task_jdbc.dao.abstr;

import com.natasha.sourceit.task_jdbc.model.RoomDbModel;
import com.natasha.sourceit.task_jdbc.model.SchoolDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class RoomDAO extends AbstractModelDAO<RoomDbModel>{
    private static final String TABLE_NAME = "vasya.room";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_FLOOR = "floor";
    private static final String COLUMN_AMOUNT = "amount";
    private static final String COLUMN_SCHOOL_ID = "school_id";

    public RoomDAO(Connection dbConn) {
        super(dbConn);
    }

    public List<RoomDbModel> getRoomsRorSchool(SchoolDbModel school) throws SQLException {
        String where = getWhereForEquals(COLUMN_SCHOOL_ID, school.getId());
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = getDbConnection().createStatement().executeQuery(sql);

        List<RoomDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                RoomDbModel model = getModelFromResultSet(rs);
                model.setSchool_id(school.getId());
                models.add(model);
            } while (rs.next());
        }
        return models;
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
    protected RoomDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        RoomDbModel room = new RoomDbModel(rs.getInt(rs.findColumn(COLUMN_ID)));
        room.setNumber(rs.getString(rs.findColumn(COLUMN_NUMBER)));
        room.setFloor(rs.getInt(rs.findColumn(COLUMN_FLOOR)));
        room.setAmount(rs.getInt(rs.findColumn(COLUMN_AMOUNT)));

        ClassDAO classDao = new ClassDAO(getDbConnection());
        room.setClassDbModels(classDao.getClassesForRoom(room));

        SubjectDAO subDAO = new SubjectDAO(getDbConnection());
        room.setSubject(subDAO.getSubjectForRoom(room));

        return room;
    }
}
