/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natasha.sourceit.communal_payment.frames;

import java.util.Stack;
import javax.swing.JFrame;

/**
 *
 * @author Stas
 */
public class ScreenHolder {
    
    private static ScreenHolder instance;
    
    private static ScreenHolder getInstance() {
        if (instance == null) {
            synchronized(ScreenHolder.class) {
                if (instance == null) {
                    instance = new ScreenHolder();
                }
            }
        }
        return instance;
    }

    
    private Stack<JFrame> screens;
    
    private ScreenHolder() {
        screens = new Stack<>();
    }
    
    public static <SCR extends JFrame> JFrame findScreenByClass(Class<SCR> scrClass) {
        for (JFrame fr : getInstance().screens) {
            if (fr.getClass() == scrClass) {
                return fr;
            }
        }
        return null;
    }
    
    public static <SCR extends JFrame> void addScreen(SCR screen) {
        if (findScreenByClass(screen.getClass()) == null) {
            getInstance().screens.push(screen);
        } else {
            throw new IllegalStateException("Already have this screen - "+screen.getClass().getName());
        }
    }
    
    public static <SCR extends JFrame> void bringToFront(SCR screen) {
        int index = getScreenIndex(screen);
        JFrame fr = getInstance().screens.remove(index);
        getInstance().screens.push(fr);
        showTopScreen();
    }
    
    public static void dropCurrentScreen() {
        int size = getInstance().screens.size();
        if (size > 0) {
            JFrame rem = getInstance().screens.pop();
            rem.setVisible(false);
            rem.dispose();
            if (size > 1) {
                getInstance().screens.peek().setVisible(true);
            }
        }
    }
    
    
    
    private static int getScreenIndex(JFrame frame) {
        for (int i=0; i<getInstance().screens.size(); i++) {
            if (frame == getInstance().screens.get(i)) {
                return i;
            }
        }
        throw new IllegalStateException("Screen not found");
    }
    
    public static void showTopScreen() {
        if (getInstance().screens.size() > 0) {
            for (JFrame fr : getInstance().screens) {
                fr.setVisible(false);
            }
            getInstance().screens.peek().setVisible(true);
        }
    }
    
    
}
