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

	NeVerticalContainer container;

	MainPanel(NeSyncFrame owner) {
		super(owner);
		owner.addKeyListener(this);
		NeDraggableController controller = new NeDraggableController(owner);
		container = new NeVerticalContainer(controller);
		container.setIndent(15);
		container.move(400, 400);
		container.setWidth(300);
		container.setHeight(200);
		NeImage card = new NeImage();
		card.load("src/EN/Bat.png");
		container.addItem(card);
		NeImage card2 = new NeImage();
		card2.load("src/EN/Bear.png");
		container.addItem(card2);
		NeImage card3 = new NeImage();
		card3.load("src/EN/Parrot.png");
		container.addItem(card3);
		container.setWidth(100);
		container.setWidth(100);
	}

	public void updateGame() {
	}

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
