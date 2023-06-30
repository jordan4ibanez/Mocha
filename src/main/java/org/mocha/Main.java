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

public class Main {
    public static void main(String[] args) {

        FlatLightLaf.setup();

        JFrame frame = new JFrame();

        frame.setTitle("Mocha 0.0.0 (Prototyping)");

        JButton button = new JButton("Cool");

        button.setBounds(130,100,100,40);

        button.addActionListener(e -> {
            System.out.println("Yeah, that's pretty cool");
        });

        frame.add(button);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.width;
        double height = screenSize.height;

        frame.setSize((int) Math.floor(width / 2.0), (int) Math.floor(height / 2.0));

        frame.setLayout(null);
        frame.setVisible(true);
    }
}