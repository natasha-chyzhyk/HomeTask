package com.natasha.students.dao;

import com.natasha.students.model.GroupDbModel;
import com.natasha.students.model.StudyDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 15.01.2017.
 */
public class StudyDAO {
    private static final String TABLE_NAME = "my_students.study";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";


    private static final String SQL_SELECT_TEMPLATE = "SELECT * FROM %s WHERE %s;";

    private Connection dbConn;

    public StudyDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }

    public StudyDbModel getModelById(long id) throws SQLException {

        String where = getWhereForEquals(COLUMN_ID, id);
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return (rs.first()) ? getModelFromResultSet(rs) : null;
    }

    public List<StudyDbModel> getModelsByIds(List<Long> ids) throws SQLException {

        String where = getWhereForIN(COLUMN_ID, ids);
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
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


    private List<StudyDbModel> buildAllModelsFromResultSet(ResultSet rs) throws SQLException {
        List<StudyDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                models.add(getModelFromResultSet(rs));
            } while (rs.next());
        }
        return models;
    }

    private StudyDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        StudyDbModel model = new StudyDbModel(rs.getLong(rs.findColumn(COLUMN_ID)));
        model.setTitle(rs.getString(rs.findColumn(COLUMN_TITLE)));
        return model;
    }
}
