package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.IAccountId;
import com.natasha.sourceit.communal_payment.model.impl.AccountDbModel;
import com.natasha.sourceit.communal_payment.model.impl.FlatDbModel;
import com.natasha.sourceit.communal_payment.model.impl.PaymentDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class PaymentDAO extends SingleIdAbstractDAO<PaymentDbModel> {
    private static final String TABLE_NAME = "paymnet";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FLAT= "id_flat";
    private static final String COLUMN_SUPPLYER = "id_supplyer";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_SUMMA = "summa";

    private static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
                    "  `%2$s` INT NOT NULL AUTO_INCREMENT, " +
                    "  `%3$s` INT NOT NULL, " +
                    "  `%4$s` INT NOT NULL, " +
                    "  `%5$s` DATE NOT NULL, " +
                    "  `%6$s` FLOAT NOT NULL, " +
                    "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME ,
            COLUMN_ID ,
            COLUMN_FLAT,
            COLUMN_SUPPLYER,
            COLUMN_DATE,
            COLUMN_SUMMA);

    public PaymentDAO(Connection dbConn) {
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
    protected PaymentDbModel getModelFromResultSet(ResultSet rs) throws SQLException {

        long flId = rs.getLong(rs.findColumn(COLUMN_FLAT));
        long suoId = rs.getLong(rs.findColumn(COLUMN_SUPPLYER));

        return PaymentDbModel.builder(rs.getLong(rs.findColumn(COLUMN_ID)))
                .setAccount(new PaymentAccountId(flId, suoId))
                .setDate(rs.getDate(rs.findColumn(COLUMN_DATE)))
                .setSumma(rs.getFloat(rs.findColumn(COLUMN_SUMMA))).build();
    }

    public List<PaymentDbModel> getPaymentsForAccount(long flatID, long supId) throws SQLException {
        String where = String.format("(%s=%d AND %s=%d)", COLUMN_FLAT, flatID, COLUMN_SUPPLYER, supId);
        return super.selectForWhere(where);
    }

    private static class PaymentAccountId implements IAccountId{
        private long flatId;
        private long supId;

        public PaymentAccountId(long flatId, long supId) {
            this.flatId = flatId;
            this.supId = supId;
        }

        @Override
        public long flatId() {
            return flatId;
        }

        @Override
        public long supplyerId() {
            return supId;
        }
    }
}
