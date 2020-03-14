package domonx.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import domonx.game.core.NeBasePanel;
import domonx.game.core.NeSyncFrame;
import domonx.game.core.entity.containers.NeVerticalContainer;
import domonx.game.core.entity.image.NeImage;

public class MainPanel extends NeBasePanel implements KeyListener {
	private static final long serialVersionUID = -3192655610452170233L;
	
	NeVerticalContainer container;

	MainPanel(NeSyncFrame owner) {
		super(owner);
		owner.addKeyListener(this);
		container = new NeVerticalContainer();
		container.setMargin(100);
		container.setWidth(300);
		container.move(300, 300);
		NeImage i = new NeImage();
		i.load("src/EN/Bat.png");
		container.addItem(i);
	}

	public void updateGame(int hertzPassed) {}

	protected void paintContent(Graphics g) {
		g.setColor(Color.BLUE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		g.fillRect(0, 0, d.width, d.height);
		container.draw(g, null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
