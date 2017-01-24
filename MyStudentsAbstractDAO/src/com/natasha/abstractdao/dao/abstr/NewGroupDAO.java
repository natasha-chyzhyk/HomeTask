package com.natasha.abstractdao.dao.abstr;

import com.natasha.abstractdao.dao.abstr.AbstractModelDAO;
import com.natasha.abstractdao.dao.abstr.GroupsStudiesDAO;

import com.natasha.abstractdao.model.GroupDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Stas on 15.01.2017.
 */
public class NewGroupDAO extends AbstractModelDAO<GroupDbModel> {

    private static final String TABLE_NAME = "my_students.group";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_YEAR = "year";

    public NewGroupDAO(Connection dbConn) {
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
    protected GroupDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        GroupDbModel model = new GroupDbModel(rs.getLong(rs.findColumn(COLUMN_ID)));
        model.setTitle(rs.getString(rs.findColumn(COLUMN_TITLE)));
        model.setStartYear(rs.getInt(rs.findColumn(COLUMN_YEAR)));

        NewStudentDAO studDao = new NewStudentDAO(getDbConnection());
        model.setStudents(studDao.getStudentsForGroup(model));

        GroupsStudiesDAO gsDao = new GroupsStudiesDAO(getDbConnection());
        List<Long> studyIds = gsDao.getStudyIdsForGrop(model.getId());

        NewStudyDAO studyDao = new NewStudyDAO(getDbConnection());
        model.setStudies(studyDao.getModelsByIds(studyIds));
        return model;
    }


    public List<GroupDbModel> getGroupsByYear(int startYear) throws SQLException {
        String where = COLUMN_ID+" = "+startYear;
        return getModelsForWhere(where);
    }

}
