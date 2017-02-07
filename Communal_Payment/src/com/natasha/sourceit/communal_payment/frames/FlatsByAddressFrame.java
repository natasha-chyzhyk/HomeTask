/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natasha.sourceit.communal_payment.frames;

import com.natasha.sourceit.communal_payment.model.impl.BuildingDbModel;
import com.natasha.sourceit.communal_payment.model.impl.FlatOwnerDbModel;
import com.natasha.sourceit.communal_payment.storage.access.DbConnectionHolder;
import com.natasha.sourceit.communal_payment.storage.dao.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Stas
 */
public class FlatsByAddressFrame extends javax.swing.JFrame {

    private FlatsByAddressContent vContent;
    
    /**
     * Creates new form FlatsByAddressFrame
     */
    public FlatsByAddressFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ScreenHolder.dropCurrentScreen();
            }
        });

        vContent = new FlatsByAddressContent(this);
        vContent.setFlats(new FlatsTableModel(null, null));
        vContent.setApplyFilterListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilter();
            }
        });
    }

    private void applyFilter() {
        if (vContent.getFilterCity().length() > 0) {
            startFilter(vContent.getFilterCity(), vContent.getFilterStreet(), vContent.getFilterHouseNum());
        } else {
            vContent.setFlats(new FlatsTableModel(null, null));
        }
    }

    private void startFilter(final String city, final String street, final String houseNum) {
        new SwingWorker<FlatsTableModel, Void>() {


            @Override
            protected FlatsTableModel doInBackground() throws Exception {
                BuildingDAO buildingDao = new BuildingDAO(DbConnectionHolder.getConnection());


                List<BuildingDbModel> builds;
                if ((city != null) && (city.length() > 0) && (street != null) && (street.length() > 0) && (houseNum != null) && (houseNum.length() > 0)) {
                    builds = buildingDao.selectHouse(city, street, houseNum);
                } else if ((city != null) && (city.length() > 0) && (street != null) && (street.length() > 0)) {
                    builds = buildingDao.selectForCityAndStreet(city, street);
                } else if ((city != null) && (city.length() > 0)) {
                    builds = buildingDao.selectForCity(city);
                } else {
                    return null;
                }


                List<Map<String, Object>> flatData = new FlatDAO(DbConnectionHolder.getConnection()).selectListModelsForBuildings(builds);
                Set<Long> ownerIds = new HashSet<>(flatData.size());
                for (Map<String, Object> o : flatData) {
                    ownerIds.add((Long) o.get(FlatDAO.COLUMN_OWNER));
                }

                List<FlatOwnerDbModel> owners = new FlatOwnerDAO(DbConnectionHolder.getConnection()).selectModelsByIds(new ArrayList<>(ownerIds));

                Map<Long, FlatOwnerDbModel> ownerMap = new HashMap<Long, FlatOwnerDbModel>();
                for (FlatOwnerDbModel o : owners) {
                    ownerMap.put(o.getId(), o);
                }
                return new FlatsTableModel(flatData, ownerMap);
            }

            @Override
            protected void done() {
                try {
                    onFlatsSelectedWithNull(get());
                } catch(InterruptedException ignore){

                } catch(ExecutionException e) {
                    onSelectError(e);
                }
                hideFilterDialog();
                isFiltering = false;
            }

        }.execute();
        isFiltering = true;
        showFilterDialog();
    }

    private void onFlatsSelectedWithNull(FlatsTableModel flats) {
        vContent.setFlats((flats != null) ? flats : new FlatsTableModel(null, null));
    }

    private void onSelectError(ExecutionException e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(FlatsByAddressFrame.this, "Select error - " + e.getMessage());
            }
        });
    }


    private boolean isFiltering;
    JDialog filteringDialog;
    private void showFilterDialog() {
        if (filteringDialog != null) hideFilterDialog();
        filteringDialog = new JDialog(this, "Applying filter", true);
        filteringDialog.setVisible(true);
    }

    private void hideFilterDialog() {
        filteringDialog.setVisible(false);
        filteringDialog.dispose();
        filteringDialog = null;
    }








    public static class FlatsTableModel extends AbstractTableModel {

        private static final String[] COLUMN_NAMES = {"ID", "City", "Street", "House #", "Flat #", "Owner"};

        private List<Map<String, Object>> flatsData;
        private Map<Long, FlatOwnerDbModel> owners;

        public FlatsTableModel(List<Map<String, Object>> flatsData, Map<Long, FlatOwnerDbModel> owners) {
            this.flatsData = flatsData;
            this.owners = owners;
        }

        public long getFlatIdForIndex(int index) {
            if (index>=0 && index < flatsData.size()) {
                return ((Long)flatsData.get(index).get(FlatDAO.COLUMN_ID)).longValue();
            } else {
                return -1;
            }
        }

        @Override
        public int getRowCount() {
            return (flatsData != null) ? flatsData.size() : 0;
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (flatsData != null) {
                Map<String, Object> row = flatsData.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return row.get(FlatDAO.COLUMN_ID);
                    case 1:
                        return row.get(BuildingDAO.COLUMN_CITY);
                    case 2:
                        return row.get(BuildingDAO.COLUMN_STREET);
                    case 3:
                        return row.get(BuildingDAO.COLUMN_BUILDING_NUM);
                    case 4:
                        return row.get(FlatDAO.COLUMN_FLAT_NUMBER);
                    case 5:
                        if (owners != null) {
                            FlatOwnerDbModel ownerModel = owners.get((Long) row.get(FlatDAO.COLUMN_OWNER));
                            return (ownerModel != null) ? ownerModel.getLastName() + " " + ownerModel.getFirstName() : "{unknown}";
                        }
                }
            }
            return null;
        }
    }




    public static class AccountTableModel extends AbstractTableModel {
        private static final String[] COLUMN_NAMES = {"ID Flat", "ID Supplyer", "Balance"};

        private List<Map<String, Object>> accountsData;

        public AccountTableModel(List<Map<String, Object>> accountsData) {
            this.accountsData = accountsData;
        }

        @Override
        public int getRowCount() {
            return (accountsData != null) ? accountsData.size() : 0;
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (accountsData != null) {
                Map<String, Object> row = accountsData.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return row.get(AccountDAO.COLUMN_FLAT);
                    case 1:
                        return row.get(AccountDAO.COLUMN_SUPPLYER);
                    case 2:
                        return row.get("balance");
                }

            }
            return null;
        }
    }


    
}
