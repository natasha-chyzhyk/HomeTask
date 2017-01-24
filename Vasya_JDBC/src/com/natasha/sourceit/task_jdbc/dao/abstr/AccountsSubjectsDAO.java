package com.natasha.sourceit.task_jdbc.dao.abstr;

import com.natasha.sourceit.task_jdbc.model.SubjectDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class AccountsSubjectsDAO {
    private static final String TABLE_NAME = "vasya.account_to_subject";

    private static final String COLUMN_ACCOUNT_ID = "account_id";
    private static final String COLUMN_SUDJECT_ID = "subject_id";

    private Connection dbConn;

    public AccountsSubjectsDAO(Connection dbConn) {
        this.dbConn = dbConn;
    }


    public List<Integer> getAccountIdsForSubject(int subjectId) throws SQLException {
        String sql = String.format("SELECT %s FROM %s WHERE %s = %d", COLUMN_ACCOUNT_ID, TABLE_NAME, COLUMN_SUDJECT_ID, subjectId);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return getIdsFromResultSet(rs, COLUMN_ACCOUNT_ID);
    }

    public List<Integer> getSubjectIdsForAccount(int accountId) throws SQLException {
        String sql = String.format("SELECT %s FROM %s WHERE %s = %d", COLUMN_SUDJECT_ID, TABLE_NAME, COLUMN_ACCOUNT_ID, accountId);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

        return getIdsFromResultSet(rs, COLUMN_SUDJECT_ID);
    }

    private List<Integer> getIdsFromResultSet(ResultSet rs, String columnNAme) throws SQLException {
        List<Integer> ids = new ArrayList<>();
        if (rs.first()) {
            do {
                int id = rs.getInt(rs.findColumn(columnNAme));
                ids.add(id);
            } while (rs.next());
        }
        return ids;
    }
}
