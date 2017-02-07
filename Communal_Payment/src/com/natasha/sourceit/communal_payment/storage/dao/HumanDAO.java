package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.impl.HumanDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class HumanDAO extends SingleIdAbstractDAO<HumanDbModel> {
    private static final String TABLE_NAME = "human";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_MIDDLE_NAME = "middle_name";
    private static final String COLUMN_LIVING_FLAT= "id_flat";

    private static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
            "  `%2$s` INT NOT NULL AUTO_INCREMENT, " +
            "  `%3$s` VARCHAR(45) NOT NULL, " +
            "  `%4$s` VARCHAR(45) NOT NULL, " +
            "  `%5$s` VARCHAR(45) NULL, " +
            "  `%6$s` INT NULL, " +
            "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME ,
            COLUMN_ID ,
            COLUMN_FIRST_NAME,
            COLUMN_LAST_NAME,
            COLUMN_MIDDLE_NAME,
            COLUMN_LIVING_FLAT);

    public HumanDAO(Connection dbConn) {
        super(dbConn);
    }

    @Override
    protected String getColumnIdName() {
        return COLUMN_ID;
    }

    @Override
    protected String getCreatorSql() {
        return CREATOR;
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

    @Override
    protected HumanDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        return HumanDbModel.builder(rs.getLong(rs.findColumn(COLUMN_ID)))
                .setFirstName(rs.getString(rs.findColumn(COLUMN_FIRST_NAME)))
                .setLastName(rs.getString(rs.findColumn(COLUMN_LAST_NAME)))
                .setMiddleName(rs.getString(rs.findColumn(COLUMN_MIDDLE_NAME)))
                .setLivingFlatId(rs.getLong(rs.findColumn(COLUMN_LIVING_FLAT))).build();
    }

    public List<HumanDbModel> getHumanForFlatId(int flatId) throws SQLException {
        String where = buildWhereForEquals(COLUMN_LIVING_FLAT, flatId);
        String sql = String.format(SQL_SELECT_TEMPLATE, TABLE_NAME, where);
        ResultSet rs = getDbConn().createStatement().executeQuery(sql);

        List<HumanDbModel> models = new ArrayList<>();
        if (rs.first()) {
            do {
                HumanDbModel humanDbModel = getModelFromResultSet(rs);
                models.add(humanDbModel);
            } while (rs.next());
        }
        return models;
    }
}
