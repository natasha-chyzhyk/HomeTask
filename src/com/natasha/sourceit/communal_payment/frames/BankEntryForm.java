/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natasha.sourceit.communal_payment.frames;

import com.natasha.sourceit.communal_payment.model.impl.BankDbModel;
import com.natasha.sourceit.communal_payment.storage.access.DbConnectionHolder;
import com.natasha.sourceit.communal_payment.storage.dao.BankDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Stas
 */
public class BankEntryForm extends javax.swing.JFrame {

    private BankDbModel bankModel;
    
    private BankEntryFormContent formContent;
    
    /**
     * Creates new form BankEntryForm
     */
    public BankEntryForm(long bankId) {
        
        try {
            bankModel = new BankDAO(DbConnectionHolder.getConnection()).selectModelById(bankId);
            
            formContent = new BankEntryFormContent(this);
            formContent.setBank(bankModel);
            formContent.setAllAddressListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            formContent.setFlatsOfOwnerListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            
        } catch(SQLException e) {
            System.exit(0);
        }
        
        
        
        
    }

  


}
