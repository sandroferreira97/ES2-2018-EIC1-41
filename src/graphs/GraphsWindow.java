package perfil4a;

import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * GraphsWindow is the class that puts the 2Dgraphic in a window.
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */
public class GraphsWindow {
	
	private JFrame j;
	private ArrayList <Integer> values = new ArrayList<Integer>(); 
	
	/**
	 * Initializing the window.
	 */
	public void init(){
		
		int a = 100;
		int b = 140;
		int c = 125;
		
		values.add(a);
		values.add(b);
		values.add(c);
		
		j = new JFrame ("Teste");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawGraphs dg = new DrawGraphs(this, values);
		j.add(dg);
		j.setSize(400, 400);
		j.setResizable(false);
		j.setVisible(true);

	}
	
	/**
	 * Function that get the width of the window
	 * @return the width of the window
	 */
	public int getWidth(){
		return j.getWidth();
	}
	
	/**
	 * Function that get the height of the window
	 * @return the height of the window
	 */
	public int getHeight(){
		return j.getHeight();
	}
	
}
