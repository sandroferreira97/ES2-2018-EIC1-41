package perfil4a;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DesenhoGraficos extends JPanel {
	
	private GraficosJanela gj;
	private ArrayList <Integer> values = new ArrayList<Integer>();  
	
	public DesenhoGraficos (GraficosJanela gj, ArrayList values){
		this.gj=gj;
		this.values=values;
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		//Graphics2D g2d = (Graphics2D)g;
		//g2d.rotate(Math.toRadians(90));
		
		//AffineTransform at = AffineTransform.getTranslateInstance(400, 400);
		//at.rotate(Math.toRadians(90));
		
		this.setBackground(Color.DARK_GRAY);
		
		int y = 0;
		int a = 1;
		
		for(int i = 0; i != values.size(); i++){
			
			g.setColor(Color.ORANGE);
			g.fillRect(46, 36+y, values.get(i), 30);
			
			g.setColor(Color.WHITE);
			g.drawString("g"+a, 31, 56+y);//dar nomes aos graficos
			g.drawString(Integer.toString(values.get(i)), values.get(i)+46, 56+y);//dar valores
			
			y = y+34;
			a++;
			
		}
		
		
		g.setColor(Color.WHITE);
		g.fillRect(45, 25, 1, gj.getHeight());
		g.fillRect(45, 25, gj.getWidth(), 1);
		
		
		
		/*
		g2d.setColor(Color.ORANGE);
		g2d.fillRect(46, 36, 100, 30);
		
		
		g2d.setColor(Color.GREEN);
		g2d.fillRect(46, 70, 75, 30);
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(45, 25, 1, gj.getHeight());
		g2d.fillRect(45, 25, gj.getWidth(), 1);
		g2d.drawString("g1", 31, 56);//x-15 y+20
		g2d.drawString("100", 146, 15);
		g2d.drawString("g2",31 , 90);//x-15 y+20*/
		
		
		
	}
	
}


