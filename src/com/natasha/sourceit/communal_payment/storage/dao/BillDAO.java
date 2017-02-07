package com.natasha.sourceit.communal_payment.storage.dao;


import com.natasha.sourceit.communal_payment.model.impl.BillDbModel;

import com.natasha.sourceit.communal_payment.model.impl.FlatDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Stas on 29.01.2017.
 */
public class BillDAO extends SingleIdAbstractDAO<BillDbModel> {
    private static final String TABLE_NAME = "bill";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FLAT = "id_flat";
    private static final String COLUMN_SERVICE = "id_service";
    private static final String COLUMN_DATE_CREATION = "created_at";
    private static final String COLUMN_SCAL_PRICE = "scaled_price_at_creation";
    private static final String COLUMN_ABON_PRICE = "abonent_price_at_creation";
    private static final String COLUMN_TOTAL_CHARGE = "total_charge";

    private static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
                    "  `%2$s` INT NOT NULL AUTO_INCREMENT, " +
                    "  `%3$s` INT NOT NULL, " +
                    "  `%4$s` INT NOT NULL, " +
                    "  `%5$s` DATE NOT NULL, " +
                    "  `%6$s` FLOAT NOT NULL, " +
                    "  `%7$s` FLOAT NOT NULL, " +
                    "  `%8$s` FLOAT NOT NULL, " +
                    "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME ,
            COLUMN_ID ,
            COLUMN_FLAT,
            COLUMN_SERVICE,
            COLUMN_DATE_CREATION,
            COLUMN_SCAL_PRICE,
            COLUMN_ABON_PRICE,
            COLUMN_TOTAL_CHARGE);

    public BillDAO(Connection dbConn) {
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
    protected BillDbModel getModelFromResultSet(ResultSet rs) throws SQLException {
        long flatId = rs.getLong(rs.findColumn(COLUMN_FLAT));

        FlatDbModel flatDbModel = new FlatDAO(getDbConn()).selectModelById(flatId);

        return BillDbModel.builder(rs.getLong(rs.findColumn(COLUMN_ID)))
                .setFlat(flatDbModel)
                .setServoceId(rs.getLong(rs.findColumn(COLUMN_SERVICE)))
                .setDateCreation(rs.getDate(rs.findColumn(COLUMN_DATE_CREATION)))
                .setPrices(rs.getFloat(rs.findColumn(COLUMN_SCAL_PRICE)), rs.getFloat(rs.findColumn(COLUMN_ABON_PRICE)))
                .setTotalCharge(rs.getFloat(rs.findColumn(COLUMN_TOTAL_CHARGE))).build();
    }
}
