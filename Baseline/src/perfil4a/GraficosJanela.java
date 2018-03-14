package perfil4a;

import java.util.ArrayList;

import javax.swing.JFrame;

public class GraficosJanela {
	
	private JFrame j;
	private ArrayList <Integer> values = new ArrayList<Integer>(); 
	
	public void init(){
		
		int a = 100;
		int b = 140;
		int c = 125;
		
		values.add(a);
		values.add(b);
		values.add(c);
		
		j = new JFrame ("Teste");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DesenhoGraficos dg = new DesenhoGraficos(this, values);
		j.add(dg);
		j.setSize(400, 400);
		j.setResizable(false);
		j.setVisible(true);

	}
	
	public int getWidth(){
		return j.getWidth();
	}
	
	public int getHeight(){
		return j.getHeight();
	}
	
}
