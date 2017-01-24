package com.natasha.sourceit.task_jdbc.dao.abstr;

import com.natasha.sourceit.task_jdbc.model.ClassDbModel;
import com.natasha.sourceit.task_jdbc.model.RoomDbModel;
import com.natasha.sourceit.task_jdbc.model.SubjectDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class SubjectDAO extends AbstractModelDAO<SubjectDbModel>{
    private static final String TABLE_NAME = "vasya.subject";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ROOM_ID = "room_id";

    public SubjectDAO(Connection dbConn) {
        super(dbConn);
    }

    public List<SubjectDbModel> getSubjectForRoom(RoomDbModel room) throws SQLException {
        String where = getWhereForEquals(COLUMN_ROOM_ID, room.getId());
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = getDbConnection().createStatement().executeQuery(sql);

        List<SubjectDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                SubjectDbModel subjectDbModel = getModelFromResultSet(rs);
                subjectDbModel.setRoom_id(room.getId());
                models.add(subjectDbModel);
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
    protected SubjectDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        SubjectDbModel subject = new SubjectDbModel(rs.getInt(rs.findColumn(COLUMN_ID)));
        subject.setName(rs.getString(rs.findColumn(COLUMN_NAME)));

        return subject;
    }
}
