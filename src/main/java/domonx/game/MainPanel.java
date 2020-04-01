package domonx.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import domonx.game.core.NeBasePanel;
import domonx.game.core.NeSyncFrame;
import domonx.game.core.controller.NeDraggableController;
import domonx.game.core.entity.containers.NeVerticalContainer;
import domonx.game.core.entity.image.NeImage;

public class MainPanel extends NeBasePanel implements KeyListener {
	private static final long serialVersionUID = -3192655610452170233L;
	private NeVerticalContainer container;
	private NeImage x;

	MainPanel(NeSyncFrame owner) {
		super(owner);
		owner.addKeyListener(this);
		NeDraggableController c = new NeDraggableController(owner);
		container = new NeVerticalContainer(c);
		container.setMargin(0);
		container.setWidth(200);
		container.setHeight(300);
		container.setIndent(50);
		container.move(300, 300);
		NeDraggableController c2 = new NeDraggableController(owner);
		x = new NeImage(c2);
		x.load("src/EN/Raccoon.png");
		x.move(100, 100);
		x.setScale(0.4);
	}

	public void updateGame(int hertzPassed) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_1) {
			NeImage i = new NeImage();
			i.load("src/EN/Bat.png");
			container.addItem(i);
		}
		if (e.getKeyCode() == KeyEvent.VK_2) {
			NeImage i = new NeImage();
			i.load("src/EN/Bear.png");
			container.addItem(i);
		}
		if (e.getKeyCode() == KeyEvent.VK_3) {
			NeImage i = new NeImage();
			i.load("src/EN/Horse.png");
			container.addItem(i);
		}
		if (e.getKeyCode() == KeyEvent.VK_4) {
			NeImage i = new NeImage();
			i.load("src/EN/Wolf.png");
			container.addItem(i);
		}
		if (e.getKeyCode() == KeyEvent.VK_0) {
			container.removeItem(container.getSize() - 1);
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
			container.addItem(x);
		}
		if (e.getKeyCode() == KeyEvent.VK_K) {
			x.setScale(x.getScale() * 0.99);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	protected void paintContent(Graphics g) {
		g.setColor(Color.BLUE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		g.fillRect(0, 0, d.width, d.height);
		container.draw(g, null);
		x.draw(g, null);
	}

}
