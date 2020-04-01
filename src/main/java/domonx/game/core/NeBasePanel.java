package domonx.game.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class NeBasePanel extends JPanel {
	private Font baseFont = new Font(Font.SERIF, Font.PLAIN, 20);
	private NeSyncFrame owner;
	private boolean showFps = false;
	private static final long serialVersionUID = -2013484543573015813L;	

	protected void paintContent(Graphics g) {}
	public void updateGame() {}
	
	public NeBasePanel(NeSyncFrame owner) {
		this.owner = owner;		
	}

	public void showFps() {
		this.showFps = true;
	}

	public void hideFps() {
		this.showFps = false;
	}

	protected void paintComponent(Graphics g) {
		paintContent(g);
		if (showFps) {
			paintFps(g);
		}
	}

	protected void paintFps(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.BLACK);
		g.setFont(baseFont);
		g.drawString(Integer.toString(owner.lastFps), 0, baseFont.getSize());
		g.setColor(oldColor);
	}	

}
