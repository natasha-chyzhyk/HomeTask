package com.natasha.sourceit.task_jdbc.dao.abstr;

import com.natasha.sourceit.task_jdbc.model.ClassDbModel;
import com.natasha.sourceit.task_jdbc.model.RoomDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class ClassDAO extends AbstractModelDAO<ClassDbModel>{
    private static final String TABLE_NAME = "vasya.class";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_ROOM_ID = "room_id";

    public ClassDAO(Connection dbConn) {
        super(dbConn);
    }

    public List<ClassDbModel> getClassesForRoom(RoomDbModel room) throws SQLException {
        String where = getWhereForEquals(COLUMN_ROOM_ID, room.getId());
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = getDbConnection().createStatement().executeQuery(sql);

        List<ClassDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                ClassDbModel classDbModel = getModelFromResultSet(rs);
                classDbModel.setRoom_id(room.getId());
                models.add(classDbModel);
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
    protected ClassDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        ClassDbModel classDbModel = new ClassDbModel(rs.getInt(rs.findColumn(COLUMN_ID)));
        classDbModel.setNumber(rs.getString(rs.findColumn(COLUMN_NUMBER)));

        AccountDAO accountDAO = new AccountDAO(getDbConnection());
        classDbModel.setAccount(accountDAO.getAccountsForClass(classDbModel));

        return classDbModel;
    }
}
