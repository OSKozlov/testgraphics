package testgraphics;

import javax.swing.SwingUtilities;

public class TestGraphics {

	   // The entry main method
	   public static void main(String[] args) {
	      // Run the GUI codes on the Event-Dispatching thread for thread safety
	      SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            new CGTemplate(); // Let the constructor do the job
	         }
	      });
	   }
}
