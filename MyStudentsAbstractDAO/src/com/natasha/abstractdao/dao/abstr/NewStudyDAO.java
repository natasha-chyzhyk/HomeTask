package com.natasha.abstractdao.dao.abstr;


import com.natasha.abstractdao.dao.abstr.AbstractModelDAO;
import com.natasha.abstractdao.model.GroupDbModel;
import com.natasha.abstractdao.model.StudyDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Stas on 18.01.2017.
 */
class NewStudyDAO extends AbstractModelDAO<StudyDbModel> {

    private static final String TABLE_NAME = "my_students.study";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";

    public NewStudyDAO(Connection dbConn) {
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
    protected StudyDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        StudyDbModel model = new StudyDbModel(rs.getLong(rs.findColumn(COLUMN_ID)));
        model.setTitle(rs.getString(rs.findColumn(COLUMN_TITLE)));
        return model;
    }

}
