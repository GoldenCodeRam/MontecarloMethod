package com.montecarlo.main;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.montecarlo.controller.GameController;
import com.montecarlo.view.form.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        startController();
        startUI();
    }

    private static void startController() {
        GameController.getInstance();
    }

    private static void startUI() {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception exception) {
            System.err.println("Failed to initialize FlatLaf");
        }

        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().$$$getRootComponent$$$());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
