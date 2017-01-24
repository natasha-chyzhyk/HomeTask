package com.natasha.abstractdao.dao.abstr;

import com.natasha.abstractdao.dao.abstr.AbstractModelDAO;
import com.natasha.abstractdao.model.GroupDbModel;
import com.natasha.abstractdao.model.StudentDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 18.01.2017.
 */
public class NewStudentDAO extends AbstractModelDAO<StudentDbModel> {
    private static final String TABLE_NAME = "my_students.students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BDAY = "birthday";
    private static final String COLUMN_GROUP_ID = "group_id";

    public NewStudentDAO(Connection dbConn) {
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
    protected StudentDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        StudentDbModel model = new StudentDbModel(rs.getLong(rs.findColumn(COLUMN_ID)));
        model.setName(rs.getString(rs.findColumn(COLUMN_NAME)));
        model.setBirthday(rs.getDate(rs.findColumn(COLUMN_BDAY)));
        return model;
    }

    public List<StudentDbModel> getStudentsForGroup(GroupDbModel group) throws SQLException {
        String where = getWhereForEquals(COLUMN_GROUP_ID, group.getId());
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = getDbConnection().createStatement().executeQuery(sql);
        List<StudentDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                StudentDbModel model = getModelFromResultSet(rs);
                model.setGroup(group);
                models.add(model);
            } while (rs.next());
        }
        return models;
    }
}
