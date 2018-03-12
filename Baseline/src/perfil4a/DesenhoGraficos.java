package perfil4a;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DesenhoGraficos extends JPanel {
	
	private GraficosJanela gj;
	
	public DesenhoGraficos (GraficosJanela gj){
		this.gj=gj;
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		
		g.setColor(Color.ORANGE);
		g.fillRect(46, 36, 100, 30);
		
		g.setColor(Color.CYAN);
		g.fillRect(46, 70, 75, 30);
		
		g.setColor(Color.BLACK);
		g.fillRect(45, 25, 1, gj.getHeight());
		g.fillRect(45, 25, gj.getWidth(), 1);
		g.drawString("g1", 31, 56);
		g.drawString("146", 136, 15);
	}
	
}
