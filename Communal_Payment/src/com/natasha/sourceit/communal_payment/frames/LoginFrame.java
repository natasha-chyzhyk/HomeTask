/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natasha.sourceit.communal_payment.frames;

import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;
import com.natasha.sourceit.communal_payment.model.User;
import com.natasha.sourceit.communal_payment.model.impl.CredentialsDbModel;
import com.natasha.sourceit.communal_payment.storage.access.DbConnectionHolder;
import com.natasha.sourceit.communal_payment.storage.dao.BankDAO;
import com.natasha.sourceit.communal_payment.storage.dao.CredentialsDAO;
import com.natasha.sourceit.communal_payment.storage.dao.SupplyerDAO;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.concurrent.ExecutionException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Stas
 */
public class LoginFrame extends JFrame {

    
    public enum UserRoleForLogin {
        BANK, SUPPLYER, UNKNOWN
    }
    
    private LoginFrameCreator frameCreator;
    
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        frameCreator = new LoginFrameCreator(this);
        
        frameCreator.setOnLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLoginClicked();
            }
        });
        
        
    }

    private boolean isLoggingIn;
    private UserRoleForLogin currentRole;
 
    private void onLoginClicked() {
        currentRole = frameCreator.getUserRoleForLogin();
       // JOptionPane.showMessageDialog(this, "Not implemented yet.");
       performLogin();
    }


    private void performLogin() {
        new SwingWorker<User, Void>() {
            
            
            @Override
            protected User doInBackground() throws Exception {
                Connection conn = DbConnectionHolder.getConnection();
                
                CredentialsDbModel creeds = new CredentialsDAO(conn).selectForLogin(frameCreator.getLogin());
                if (creeds == null) return null;
                
                User usr = null;
                switch(currentRole) {
                    case BANK:
                        usr = new BankDAO(conn).selectForCredentials(creeds);
                        break;
                    case SUPPLYER:
                        usr = new SupplyerDAO(conn).selectForCredentials(creeds);
                        break;
                }
                return usr;
            }

            @Override
            protected void done() {
                try {
                    onUserAccountSelected(get());
                } catch(InterruptedException ignore){
                } catch(ExecutionException e) {
                    onLoginError(e);
                }
                hideLoginDialog();
                isLoggingIn = false;
            }
            
        }.execute();
        isLoggingIn = true;
        showLoginDialog();
    }
    
    
    
    private void onUserAccountSelected(User user) {
        if (user == null) {
            showAccountNotFound();
        } else if (!user.checkPassword(frameCreator.getPassword())) {
            showWrongPassword();
        } else {
            long id = ((SingleIdDbModel) user).getId();
            switch(currentRole) {
                    case BANK:
                        showBankEntryForm(id);
                        break;
                    case SUPPLYER:
                        JOptionPane.showMessageDialog(this, "Supplyuer logged in: ID="+id);
                        break;
                }
        }
    }
    
    
    
    
    
    
    private void onLoginError(ExecutionException e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(LoginFrame.this, "Login error - "+e.getMessage());
            }
        });
        frameCreator.clearLoginAndPassword();
    }
    
    private void showAccountNotFound() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(LoginFrame.this, "Requested account not found.");
            }
        });
        frameCreator.clearLoginAndPassword();
    }
    
    private void showWrongPassword() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(LoginFrame.this, "Wrong password.");
            }
        });
        frameCreator.clearPassword();
    }
    
    private void showBankEntryForm(final long bankId) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                
                ScreenHolder.addScreen(new BankEntryForm(bankId));
                ScreenHolder.showTopScreen();
                LoginFrame.this.setVisible(false);
                LoginFrame.this.dispose();
                
                
                
            }
        });
    }
    
    
    
    
    
    
    JDialog loginDialog;
    private void showLoginDialog() {
        if (loginDialog != null) hideLoginDialog();
        loginDialog = new JDialog(this, "Logging in", true);
        loginDialog.setVisible(true);
    }
    
    private void hideLoginDialog() {
        loginDialog.setVisible(false);
        loginDialog.dispose();
        loginDialog = null;
    }

   
}
