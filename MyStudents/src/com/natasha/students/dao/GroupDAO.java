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
public class GroupDAO {

    private static final String TABLE_NAME = "my_students.group";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_YEAR = "year";

    private static final String SQL_SELECT_TEMPLATE = "SELECT * FROM %s WHERE %s;";
    private static final String SQL_SELECT_ALL_TEMPLATE = "SELECT * FROM %s;";

    private Connection dbConn;

    public GroupDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }

    public GroupDbModel getModelById(long id) throws SQLException {
        String where = getWhereForEquals(COLUMN_ID, id);
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return (rs.first()) ? getModelFromResultSet(rs) : null;
    }

    public List<GroupDbModel> getModelsByIds(List<Long> ids) throws SQLException {
        String where = getWhereForIN(COLUMN_ID, ids);
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
    }

    public List<GroupDbModel> getGroupsByYear(int startYear) throws SQLException {
        String where = getWhereForEquals(COLUMN_YEAR, startYear);
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
    }

    public List<GroupDbModel> getAllModels() throws SQLException {
        String sql = String.format(SQL_SELECT_ALL_TEMPLATE, TABLE_NAME);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return buildAllModelsFromResultSet(rs);
    }

    private List<GroupDbModel> buildAllModelsFromResultSet(ResultSet rs) throws SQLException {
        List<GroupDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                models.add(getModelFromResultSet(rs));
            } while (rs.next());
        }
        return models;
    }

    private GroupDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        GroupDbModel model = new GroupDbModel(rs.getLong(rs.findColumn(COLUMN_ID)));
        model.setTitle(rs.getString(rs.findColumn(COLUMN_TITLE)));
        model.setStartYear(rs.getInt(rs.findColumn(COLUMN_YEAR)));

        StudentDAO studDao = new StudentDAO(dbConn);
        model.setStudents(studDao.getStudentsForGroup(model));

        GroupsStudiesDAO gsDao = new GroupsStudiesDAO(dbConn);
        List<Long> studyIds = gsDao.getStudyIdsForGrop(model.getId());

        StudyDAO studyDao = new StudyDAO(dbConn);
        model.setStudies(studyDao.getModelsByIds(studyIds));
        return model;
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

}
