/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natasha.sourceit.communal_payment.frames;

import com.natasha.sourceit.communal_payment.model.impl.BankDbModel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Stas
 */
public class BankEntryFormContent {
    private JFrame frame;

    // Variables declaration - do not modify                     
    private JLabel jBankAddress;
    private JLabel jBankId;
    private JLabel jBankTitle;
    private JButton jBtnAllAddress;
    private JButton jBtnFlatsOfOwner;
    // End of variables declaration     
    
    
    
    
    
    
    public void setAllAddressListener(ActionListener l) {
        jBtnAllAddress.addActionListener(l);
    }
    
    public void setFlatsOfOwnerListener(ActionListener l) {
        jBtnFlatsOfOwner.addActionListener(l);
    }
    
    public void clearBank() {
        jBankTitle.setText("");
        jBankAddress.setText("");
        jBankId.setText("");
    }
    
    public void setBank(BankDbModel bank) {
        jBankId.setText(""+bank.getId());
        jBankTitle.setText(bank.getTitle());
        jBankAddress.setText(String.format("%s, %s %d", bank.getCity(), bank.getStreet(), bank.getHouse()));
    }
    
    
    public BankEntryFormContent(JFrame frame) {
        this.frame = frame;
    }
    
    private void initComponents() {

        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel jLabel1 = new javax.swing.JLabel();
        jBankTitle = new javax.swing.JLabel();
        jBankId = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        jBankAddress = new javax.swing.JLabel();
        jBtnAllAddress = new javax.swing.JButton();
        jBtnFlatsOfOwner = new javax.swing.JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Bank Main Options");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bank properties"));

        jLabel1.setText("Title:");

        jBankTitle.setText("jLabel2");

        jBankId.setText("jLabel2");

        jLabel2.setText("ID:");

        jLabel3.setText("Address:");

        jBankAddress.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBankTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBankId))
                    .addComponent(jBankAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jBankTitle)
                    .addComponent(jBankId)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jBankAddress))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnAllAddress.setText("Flats by Address");

        jBtnFlatsOfOwner.setText("Flats by Owner");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnAllAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnFlatsOfOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAllAddress)
                    .addComponent(jBtnFlatsOfOwner))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frame.pack();
    }
}
