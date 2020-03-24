package testgraphics;

import java.awt.*; // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*; // Using Swing's components and containers

/** Custom Drawing Code Template */
// A Swing application extends javax.swing.JFrame
public class CGTemplate extends JFrame {
	// Define constants
	public static final int CANVAS_WIDTH = 640;
	public static final int CANVAS_HEIGHT = 480;

	// Declare an instance of the drawing canvas,
	// which is an inner class called DrawCanvas extending javax.swing.JPanel.
	private DrawCanvas canvas;

	// Constructor to set up the GUI components and event handlers
	public CGTemplate() {
		canvas = new DrawCanvas(); // Construct the drawing canvas
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		// Set the Drawing JPanel as the JFrame's content-pane
		Container cp = getContentPane();
		cp.add(canvas);
		// or "setContentPane(canvas);"

		setDefaultCloseOperation(EXIT_ON_CLOSE); // Handle the CLOSE button
		pack(); // Either pack() the components; or setSize()
		setTitle("......"); // "super" JFrame sets the title
		setVisible(true); // "super" JFrame show
	}

	/**
	 * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
	 */
	private class DrawCanvas extends JPanel {

		public DrawCanvas() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					System.err.println("### MOUSE PRESSED !!!");
					Graphics g = getGraphics();
					paintArea(g, Color.GREEN, Color.BLUE);
				}
			});
		}

		// Override paintComponent to perform your own painting
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // paint parent's background
			paintArea(g, Color.YELLOW, Color.RED);
		}
		
		@Override
		public Graphics getGraphics() {
			// TODO Auto-generated method stub
			return super.getGraphics();
		}
		
		private void paintArea(Graphics g, Color color1, Color color2) {
			setBackground(Color.BLACK); // set background color for this JPanel
			
			// Your custom painting codes. For example,
			// Drawing primitive shapes
			g.setColor(color1); // set the drawing color
			g.drawLine(30, 40, 100, 200);
			g.drawOval(150, 180, 10, 10);
			g.drawRect(200, 210, 20, 30);
			g.setColor(color2); // change the drawing color
			g.fillOval(300, 310, 30, 50);
			g.fillRect(400, 350, 60, 50);
			// Printing texts
			g.setColor(Color.WHITE);
			g.setFont(new Font("Monospaced", Font.PLAIN, 12));
			g.drawString("Testing custom drawing ...", 10, 20);
		}

	}

}