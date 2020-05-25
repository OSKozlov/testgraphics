package com.rubberband.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

import java.applet.*;

public class RubberLinesPanel2 extends JPanel implements MouseListener, MouseMotionListener {

   boolean heardMouse = false;  // Set to true the first time the user clicks on
                                //   the applet.  Until that time, some instructions
                                //   are drawn by the paint() method.
                                
   /* Some variables used during dragging. */
   
   boolean dragging;    // This is set to true when a drag begins, and to false
                        //    when it ends.  The value is checked by mouseReleased()
                        //    and mouseDragged.

   boolean drawingLine; // The user can draw lines or rects.  This variable is true if
                        //    the user is drawing a line, and false if the user is drawing
                        //    a rectangle.

   int startx, starty;  // The location of the mouse when the dragging started.

   int prevx, prevy;    // The previous location of the mouse during dragging.

   Graphics dragGr;     // A graphics context for use while dragging.

    public RubberLinesPanel2() {
        init();
    }

   public void init() {
         // When the applet is created, set the background color to white and
         // set up the apple to listen for mouse events on itself.
      setBackground(Color.white);
      addMouseListener(this);
      addMouseMotionListener(this);
   }
   

   public void paint(Graphics g) {
         // The paint method draws a black border around the applet.
         // If heardMouse is false, it displays some instructions.  This
         // is done only until the first time the use clicks the mouse.
      if (heardMouse == false) {
         g.drawString("Click and drag to draw lines.", 10, 15);
         g.drawString("Right-click and drag to draw rects.", 10, 30);
         g.drawString("Shift-click to clear.", 10, 45);
      }
      g.setColor(Color.black);
      g.drawRect(0,0,getSize().width - 1, getSize().height - 1);
   }
   

   void drawFigure() {
           // This is called during dragging to draw the line or rect
           // between the starting position of the mouse and the current
           // position.  The figure is drawn in the graphics context, dragGr.
           // The two points are given by (startx, starty) and (prevx, prevy).
           // The variable drawingLine is used to decide what type of
           // figure to draw.
      if (drawingLine) {
             // Draw a red line.
         dragGr.setColor(Color.red);
         dragGr.drawLine(startx, starty, prevx, prevy);
      }
      else {
             // Draw a blue rect.
         int x, y;  // Top left corner of the rectangle.
         int w, h;  // Width and height of the rectangle.
             // x,y,w,h must be computed from the coordinates
             // of the two corner points.
         if (prevx > startx) {
            x = startx;
            w = prevx - startx;
         }
         else {
            x = prevx;
            w = startx - prevx;
         }
         if (prevy > starty) {
            y = starty;
            h = prevy - starty;
         }
         else {
            y = prevy;
            h = starty - prevy;
         }
         dragGr.setColor(Color.blue);
         dragGr.fillRect(x, y, w, h);
      }
   }  // end drawFigure()
   

   public void mousePressed(MouseEvent evt) {
          // Respond when the user presses a mouse button.

      if (heardMouse == false) {
            // Erase the instructions, if this is the first mause click.
         heardMouse = true;
         repaint();
      }

      if (evt.isShiftDown()) {
             // If the shift key is down, just erase the applet.
         repaint();
         return;
      }

      if (dragging)  // If already dragging, don't do anything.
         return;     //  (This can happen if the user presses two mouse buttons.

      dragGr = getGraphics();  // Get a graphics context and draw in XOR mode.
      dragGr.setXORMode(getBackground());

      startx = prevx = evt.getX();  // Save coords of mouse position.
      starty = prevy = evt.getY();
      
      drawingLine = (evt.isMetaDown() == false); // Check if it's a right-click.
      
      dragging = true;  // Start dragging.

      drawFigure();  // Draw the figure.  Note that both drawLine and drawRect 
                     //   draw a single pixel when the two endpoints are equal.
                     //   This pixel must be there so that it can be erased when
                     //   the mouse is moved.  Otherwise, you end up with an
                     //   extra pixel!  XOR mode can be tricky.

   }  // end mousePressed.
   
   
   public void mouseReleased(MouseEvent evt) {
          // End the dragging operation, if one is in progress.  Erase
          // the last XOR mode figure, and draw the final figure 
          // permanently in paint mode.
      if (dragging) {
         drawFigure();  // Erase the previous figure by redrawing in XOR mode.
         dragGr.setPaintMode();
         drawFigure();  // Draw the figure permanently.
         dragGr.dispose();
         dragging = false;
      }
   }
   
   public void mouseDragged(MouseEvent evt) {
           // If a dragging operation is in progress, erase the previous
           // figure and draw a new one based on the new mouse position.
      if (dragging) {
         drawFigure();  // Erase the previous figure by drawing in XOR mode.
         prevx = evt.getX();
         prevy = evt.getY();
         drawFigure();  // Draw the figure in its new position.
      }
   }
   
   public void mouseClicked(MouseEvent evt) { }  // Empty methods, required by
   public void mouseEntered(MouseEvent evt) { }  //   the MouseEvent and
   public void mouseExited(MouseEvent evt) { }   //   MouseListener intefaces.
   public void mouseMoved(MouseEvent evt) { }


}  // end class RubberBand