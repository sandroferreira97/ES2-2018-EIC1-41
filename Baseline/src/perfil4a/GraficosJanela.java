package perfil4a;
import javax.swing.JFrame;

public class GraficosJanela {
	
	private JFrame j;
	
	public void init(){
		
		j = new JFrame ("Teste");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DesenhoGraficos dg = new DesenhoGraficos(this);
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
