package com.natasha.students.dao;

import com.natasha.students.model.GroupDbModel;
import com.natasha.students.model.StudentDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 15.01.2017.
 */
public class StudentDAO {
    private static final String TABLE_NAME = "my_students.students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BDAY = "birthday";
    private static final String COLUMN_GROUP_ID = "group_id";

    private static final String SQL_SELECT_TEMPLATE = "SELECT * FROM %s WHERE %s;";

    private Connection dbConn;

    public StudentDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }

    public StudentDbModel getModelById(long id) throws SQLException {
        String where = getWhereForEquals(COLUMN_ID, id);
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return (rs.first()) ? getModelFromResultSet(rs, null) : null;
    }

    public List<StudentDbModel> getModelsByIds(List<Long> ids) throws SQLException {
        String where = getWhereForIN(COLUMN_ID, ids);
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs, null);
    }


    public List<StudentDbModel> getStudentsForGroup(GroupDbModel group) throws SQLException {
        String where = getWhereForEquals(COLUMN_GROUP_ID, group.getId());
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs, group);
    }

    private String getWhereForEquals(String colName, long value) {
        return String.format("(%s = %d)", colName, value);
    }

    private String getWhereForIN(String colName, List<Long> ids) {
        StringBuilder sb = new StringBuilder("("+colName+" IN (");
        for (int i=0; i<ids.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(ids.get(i));
        }
        sb.append("))");
        return sb.toString();
    }

    private List<StudentDbModel> buildAllModelsFromResultSet(ResultSet rs, GroupDbModel group) throws SQLException {
        List<StudentDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                models.add(getModelFromResultSet(rs, group));
            } while (rs.next());
        }
        return models;
    }

    private StudentDbModel getModelFromResultSet(ResultSet rs, GroupDbModel group) throws SQLException {
        StudentDbModel model = new StudentDbModel(rs.getLong(rs.findColumn(COLUMN_ID)));
        model.setName(rs.getString(rs.findColumn(COLUMN_NAME)));
        model.setBirthday(rs.getDate(rs.findColumn(COLUMN_BDAY)));
        model.setGroup(group);
        return model;
    }
}
