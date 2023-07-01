/*
 Mocha - An IDE for Java written in Java.
 Copyright (C) 2023 jordan4ibanez

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.mocha;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    private static boolean running = true;
    private static JFrame frame;
    private static Container windowPane;
    private static JButton exitButton;
    private static JTextArea codeArea;

    private static final int SINGLE_PADDING = 2;
    private static final int DOUBLE_PADDING = SINGLE_PADDING * 2;
    private static final int QUADRUPLE_PADDING = DOUBLE_PADDING * 2;

    public static void main(String[] args) {

        FlatLightLaf.setup();

        frame = new JFrame();
        windowPane = frame.getContentPane();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setTitle("Mocha 0.0.0 (Prototyping)");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) Math.floor(screenSize.width / 2.0);
        int height = (int) Math.floor(screenSize.height / 2.0);

        frame.setSize(width, height);

        // This is a hack-job to make the window pane have a usable size
        frame.setLayout(null);
        frame.setVisible(true);

        // Create the exit button
        exitButton = new JButton("Exit");
        exitButton.setBounds(SINGLE_PADDING, SINGLE_PADDING,100 - DOUBLE_PADDING,20 - DOUBLE_PADDING);
        exitButton.addActionListener(event -> {
            closeProcedure();
        });
        frame.add(exitButton);

        // Create the coding area
        codeArea = new JTextArea();
        System.out.println(windowPane.getWidth());
        // Note: This can get very complicated, turn this into a function
        codeArea.setBounds(100 + SINGLE_PADDING,20 + SINGLE_PADDING,windowPane.getWidth() - (100 + QUADRUPLE_PADDING), windowPane.getHeight() - (20 + QUADRUPLE_PADDING));
        frame.add(codeArea);


        // Close listener
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                closeProcedure();
            }
        });

        // Resize listener
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                codeArea.setBounds(100 + SINGLE_PADDING,20 + SINGLE_PADDING,windowPane.getWidth() - (100 + QUADRUPLE_PADDING), windowPane.getHeight() - (20 + QUADRUPLE_PADDING));
//                System.out.println(newSize);
            }
        });

        // The pane is dirty, needs a repaint
        frame.repaint();


        // SURPRISE! IT'S A GAME LOOP! WOO!
        while (running) {
            System.out.println("auto-save check");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                closeProcedure();
                throw new RuntimeException("Error! Main thread failed to sleep! ABORT ABORT!");
            }
        }
    }

    public static void closeProcedure() {
        running = false;
        System.out.println("See ya!");
        // Save here
        System.exit(0);
    }
}