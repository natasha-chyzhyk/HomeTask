package com.natasha.abstractdao.dao.abstr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 15.01.2017.
 */
public class GroupsStudiesDAO {
    private static final String TABLE_NAME = "group_study";

    private static final String COLUMN_GROUP_ID = "group_id";
    private static final String COLUMN_STUDY_ID = "study_id";

    private Connection dbConn;

    public GroupsStudiesDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }

    public List<Long> getStudyIdsForGrop(long groupId) throws SQLException {
        String sql = String.format("SELECT %s FROM %s WHERE %s = %d", COLUMN_STUDY_ID, TABLE_NAME, COLUMN_GROUP_ID, groupId);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return getIdsFromResultSet(rs, COLUMN_STUDY_ID);
    }

    public List<Long> getGroupIdsForStudy(long studyId) throws SQLException {
        String sql = String.format("SELECT %s FROM %s WHERE %s = %d", COLUMN_GROUP_ID, TABLE_NAME, COLUMN_STUDY_ID, studyId);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return getIdsFromResultSet(rs, COLUMN_GROUP_ID);
    }

    private List<Long> getIdsFromResultSet(ResultSet rs, String columnNAme) throws SQLException {
        List<Long> ids = new ArrayList<>();
        if (rs.first()) {
            do {
                long id = rs.getLong(rs.findColumn(columnNAme));
                ids.add(id);
            } while (rs.next());
        }
        return ids;
    }
}
