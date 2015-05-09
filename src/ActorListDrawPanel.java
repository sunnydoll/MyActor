/*
* Zhichao Cao
* zc77@drexel.edu
* CS530:DUI, Assignment 1
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class ActorListDrawPanel extends JPanel {
	
	public static ActorObject ao;
	
	public ActorListDrawPanel() {	
		Border innerBorder = BorderFactory.createTitledBorder("Actor Preview");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
	
	public void drawing() {
//		Refresh the DrawPanel
		repaint();		
	}
	
	public void paintComponent(Graphics g) {  
//		Draw actor
        super.paintComponent(g);  

        Graphics2D g2 = (Graphics2D)g;   
        
        if(ao != null)
        {
//        	Draw Shirt
	        int shirtLeftX = 120;
			int shirtTopY = 120;
			int rHeight = ao.getHeight();
			int rWidth = ao.getWidth();
  
			switch(ao.getTColor()) {
				case "Red": g2.setColor(Color.red);
				break;
				case "Orange": g2.setColor(Color.orange);
				break;
				case "Yellow": g2.setColor(Color.yellow);
				break;
				case "Green": g2.setColor(Color.green);
				break;
				case "Cyan": g2.setColor(Color.cyan);
				break;
				case "Blue": g2.setColor(Color.blue);
				break;
			}			
			g2.fillRect(shirtLeftX, shirtTopY, rWidth, rHeight);
			
//			Draw Pants
			int pantsLeftX = rWidth/4 + shirtLeftX;
			int pantsTopY = rHeight + shirtTopY;
			int pWidth = rWidth/2;
			int pHeight = rHeight/2;
			
			switch(ao.getPColor()) {
				case "Red": g2.setColor(Color.red);
				break;
				case "Orange": g2.setColor(Color.orange);
				break;
				case "Yellow": g2.setColor(Color.yellow);
				break;
				case "Green": g2.setColor(Color.green);
				break;
				case "Cyan": g2.setColor(Color.cyan);
				break;
				case "Blue": g2.setColor(Color.blue);
				break;
			}
			g2.fillRect(pantsLeftX, pantsTopY, pWidth, pHeight);
			
//			Draw a line that divides two legs
			g2.setColor(Color.black);
	        g2.draw(new Line2D.Double(shirtLeftX + rWidth/2, shirtTopY + rHeight, shirtLeftX + rWidth/2, shirtTopY + rHeight + rHeight/2));  
			
//			Draw Head
	        double faceX = shirtLeftX + rWidth/2;  
	        double faceY = shirtTopY - 50;  
	        double faceRadius = 50;  
	
	        Ellipse2D face = new Ellipse2D.Double();  
	        face.setFrameFromCenter(faceX, faceY, faceX + faceRadius, faceY + faceRadius); 
	        g2.draw(face);  
	        
//	        Draw Eyes
	        double leftEyeX = faceX - 20;
	        double leftEyeY = faceY - 20;
	        double leftEyeR = 10;
	        
	        Ellipse2D leftEye = new Ellipse2D.Double();  
	        leftEye.setFrameFromCenter(leftEyeX, leftEyeY, leftEyeX + leftEyeR, leftEyeY + leftEyeR); 
	        g2.draw(leftEye); 
	        
	        double rightEyeX = faceX + 20;
	        double rightEyeY = faceY - 20;
	        double rightEyeR = 10;
	        
	        Ellipse2D rightEye = new Ellipse2D.Double();  
	        rightEye.setFrameFromCenter(rightEyeX, rightEyeY, rightEyeX + rightEyeR, rightEyeY + rightEyeR); 
	        g2.draw(rightEye); 
	        
	        double leftHoleX = leftEyeX;
	        double leftHoleY = leftEyeY;
	        double leftHoleR = 5;
	        
	        Ellipse2D leftHole = new Ellipse2D.Double();  
	        leftHole.setFrameFromCenter(leftHoleX, leftHoleY, leftHoleX + leftHoleR, leftHoleY + leftHoleR); 
	        g2.fill(leftHole);
	        
	        double rightHoleX = rightEyeX;
	        double rightHoleY = rightEyeY;
	        double rightHoleR = 5;
	        
	        Ellipse2D rightHole = new Ellipse2D.Double();  
	        rightHole.setFrameFromCenter(rightHoleX, rightHoleY, rightHoleX + rightHoleR, rightHoleY + rightHoleR); 
	        g2.fill(rightHole);
	        
//	        Draw Mouth
	        GeneralPath p2 = new GeneralPath();
	        switch(ao.getExpression()) {
	        	case "Happy":
	        		p2.moveTo(leftEyeX, leftEyeY + 40);
	        		p2.curveTo(leftEyeX, leftEyeY + 40, leftEyeX + 20, leftEyeY + 60, rightEyeX, rightEyeY + 40);
	        		g2.draw(p2);
	        		break;
	        	case "Sad":
	        		p2.moveTo(leftEyeX, leftEyeY + 40);
	        		p2.curveTo(leftEyeX, leftEyeY + 40, leftEyeX + 20, leftEyeY + 20, rightEyeX, rightEyeY + 40);
	        		g2.draw(p2);
	        		break;
	        	case "Neutral":
	        		g2.draw(new Line2D.Double(leftEyeX, leftEyeY + 40, rightEyeX, rightEyeY + 40));  
	        		break;
	        }
        }
    }

}
