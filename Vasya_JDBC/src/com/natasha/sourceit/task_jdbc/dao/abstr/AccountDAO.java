package com.natasha.sourceit.task_jdbc.dao.abstr;

import com.natasha.sourceit.task_jdbc.model.AccountDbModel;
import com.natasha.sourceit.task_jdbc.model.ClassDbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class AccountDAO extends AbstractModelDAO<AccountDbModel>{
    private static final String TABLE_NAME = "vasya.account";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLASS_ID = "class_id";

    public AccountDAO(Connection dbConn) {
        super(dbConn);
    }


    public List<AccountDbModel> getAccountsForClass(ClassDbModel classDbModel) throws SQLException {
        String where = getWhereForEquals(COLUMN_CLASS_ID, classDbModel.getId());
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = getDbConnection().createStatement().executeQuery(sql);

        List<AccountDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                AccountDbModel model = getModelFromResultSet(rs);
                model.setClass_id(classDbModel.getId());
                models.add(model);
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
    protected AccountDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        AccountDbModel account = new AccountDbModel(rs.getInt(rs.findColumn(COLUMN_ID)));
        account.setName(rs.getString(rs.findColumn(COLUMN_NAME)));
        account.setAge(rs.getInt(rs.findColumn(COLUMN_AGE)));

        AccountsSubjectsDAO accountsSubjectsDAO = new AccountsSubjectsDAO(getDbConnection());
        List<Integer> subjectIds = accountsSubjectsDAO.getSubjectIdsForAccount(account.getId());

        SubjectDAO subjectDao = new SubjectDAO(getDbConnection());
        account.setSubject(subjectDao.getModelsByIds(subjectIds));

        return account;
    }
}
