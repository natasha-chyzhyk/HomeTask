package com.natasha.sourceit.communal_payment.storage.dao;

import com.natasha.sourceit.communal_payment.model.CalculationFormulaType;
import com.natasha.sourceit.communal_payment.model.ServiceType;
import com.natasha.sourceit.communal_payment.model.impl.EndServiceDbModel;
import com.natasha.sourceit.communal_payment.model.impl.SupplyerDbModel;
import com.natasha.sourceit.communal_payment.storage.SingleIdAbstractDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 29.01.2017.
 */
public class ServiceDAO extends SingleIdAbstractDAO<EndServiceDbModel> {

    private static final String TABLE_NAME = "service";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SUPLYER = "id_supplier";
    private static final String COLUMN_SERVICE_TYPE = "type";
    private static final String COLUMN_SERVICE_OPTION = "sub_type";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_SCALED_PRICE = "scaled_price";
    private static final String COLUMN_ABONENT_PRICE = "abonent_price";
    private static final String COLUMN_CALCULATION_TYPE = "calculation_type";


    private static final String CREATOR = String.format("CREATE TABLE `%1$s` (" +
                    "  `%2$s` INT NOT NULL AUTO_INCREMENT, " +
                    "  `%3$s` INT NOT NULL, " +
                    "  `%4$s` VARCHAR(45) NOT NULL, " +
                    "  `%5$s` VARCHAR(45) NOT NULL, " +
                    "  `%6$s` VARCHAR(256) NULL, " +
                    "  `%7$s` FLOAT NOT NULL, " +
                    "  `%8$s` FLOAT NOT NULL, " +
                    "  `%9$s` VARCHAR(45) NOT NULL, " +
                    "  PRIMARY KEY (`%2$s`));",
            TABLE_NAME,
            COLUMN_ID,
            COLUMN_SUPLYER,
            COLUMN_SERVICE_TYPE,
            COLUMN_SERVICE_OPTION,
            COLUMN_DESCRIPTION,
            COLUMN_SCALED_PRICE,
            COLUMN_ABONENT_PRICE,
            COLUMN_CALCULATION_TYPE);

    public ServiceDAO(Connection dbConn) {
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
    protected EndServiceDbModel getModelFromResultSet(ResultSet rs) throws SQLException {

        long supId = rs.getLong(rs.findColumn(COLUMN_SUPLYER));

        SupplyerDbModel supplyerDbModel = new SupplyerDAO(getDbConn()).selectModelById(supId);
        return EndServiceDbModel.builder(rs.getLong(rs.findColumn(COLUMN_ID)))
                .setSupplyer(supplyerDbModel)
                .setServiceType(ServiceType.valueOf(rs.getString(rs.findColumn(COLUMN_SERVICE_TYPE))))
                .setServiceOption(rs.getString(rs.findColumn(COLUMN_SERVICE_OPTION)))
                .setDescription(rs.getString(rs.findColumn(COLUMN_DESCRIPTION)))
                .setScaledPrice(rs.getFloat(rs.findColumn(COLUMN_SCALED_PRICE)))
                .setAbonentPrice(rs.getFloat(rs.findColumn(COLUMN_ABONENT_PRICE)))
                .setCalculationType(CalculationFormulaType.valueOf(rs.getString(rs.findColumn(COLUMN_SERVICE_TYPE)))).build();
    }
}
