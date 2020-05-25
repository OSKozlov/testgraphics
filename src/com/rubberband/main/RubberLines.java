package com.rubberband.main;

import javax.swing.JFrame;

import com.rubberband.ui.RubberLinesPanel;
import com.rubberband.ui.RubberLinesPanel2;

public class RubberLines {

    // -----------------------------------------------------------------
    // Creates and displays the application frame.
    // -----------------------------------------------------------------
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rubber Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RubberLinesPanel());
        //frame.getContentPane().add(new RubberLinesPanel2());
        frame.pack();
        frame.setVisible(true);
    }

}
