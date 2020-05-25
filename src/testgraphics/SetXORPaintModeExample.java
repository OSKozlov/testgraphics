package testgraphics;

/*
Set Drawing Mode To XOR Example 
This java example shows how to set drawing mode to XOR instead of overwrite
mode using setXORMode method of Graphics class.
*/

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SetXORPaintModeExample extends JPanel {

    public void paint(Graphics g) {

        /*
         * usually, the new drwaing objects overwrites the previously drawn objects. Setting drwaing mode to XOR mode
         * makes sure that the existing contents will always be displayed and will be XORed with the new objects.
         * 
         * To set mode to XOR mode, use void setXORMode(Color c) method of Graphics class.
         */
        // setForeground(Color.RED);
        g.setXORMode(Color.GRAY);
        g.fillRect(10, 10, 50, 50);
        //g.fillRect(20, 30, 50, 50);

        /*
         * To set overwrite mode, use void setPaintMode() method of Graphics class.
         */
        g.setPaintMode();
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rubber Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SetXORPaintModeExample());
        frame.setSize(300, 400);
        frame.pack();
        frame.setVisible(true);
    }
}