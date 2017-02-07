package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.impl.AccountDbModel;
import com.natasha.sourceit.communal_payment.model.impl.FlatDbModel;
import com.natasha.sourceit.communal_payment.model.impl.PaymentDbModel;
import com.natasha.sourceit.communal_payment.model.impl.SupplyerDbModel;
import com.natasha.sourceit.communal_payment.storage.DoubleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class AccountDAO extends DoubleIdAbstractDAO<AccountDbModel> {
    private static final String TABLE_NAME = "account";

    public static final String COLUMN_FLAT = "id_flat";
    public static final String COLUMN_SUPPLYER = "id_supplyer";

    private static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
                    "  `%2$s` INT NOT NULL, " +
                    "  `%3$s` INT NOT NULL, " +
                    "  PRIMARY KEY (`%2$s`, `%3$s`));",
            TABLE_NAME ,
            COLUMN_FLAT,
            COLUMN_SUPPLYER );

    public AccountDAO(Connection dbConn) {
        super(dbConn);
    }

    @Override
    protected String getColumnId1Name() {
        return COLUMN_FLAT;
    }

    @Override
    protected String getColumnId2Name() {
        return COLUMN_SUPPLYER;
    }

    @Override
    protected String getCreatorSql() {
        return CREATOR;
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

    public AccountDbModel getSingleAccount(FlatDbModel flatDbModel, SupplyerDbModel supplyerDbModel) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE %s = %d AND %s = %d", TABLE_NAME, COLUMN_FLAT, flatDbModel.getId(), COLUMN_SUPPLYER, supplyerDbModel.getId());
        ResultSet rs = getDbConn().createStatement().executeQuery(sql);

        long flatId = rs.getLong(rs.findColumn(COLUMN_FLAT));
        long supId = rs.getLong(rs.findColumn(COLUMN_SUPPLYER));

        FlatDbModel flatDbM = new FlatDAO(getDbConn()).selectModelById(flatId);
        SupplyerDbModel supplyer = new SupplyerDAO(getDbConn()).selectModelById(supId);
        PaymentDAO payment = new PaymentDAO(getDbConn());

        return AccountDbModel.create(supplyer, flatDbM, payment.getPaymentsForAccount(flatId, supId));
    }

    public List<Long> getSupplyerForFlat(FlatDbModel flatDbModel) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE %s = %d", TABLE_NAME, COLUMN_FLAT, flatDbModel.getId());
        ResultSet rs = getDbConn().createStatement().executeQuery(sql);

        return getIdsFromResultSet(rs, COLUMN_SUPPLYER);
    }

    public List<Long> getFlatForSupplyer(SupplyerDbModel supplyerDbModel) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE %s = %d", TABLE_NAME, COLUMN_SUPPLYER, supplyerDbModel.getId());
        ResultSet rs = getDbConn().createStatement().executeQuery(sql);

        return getIdsFromResultSet(rs, COLUMN_FLAT);
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
