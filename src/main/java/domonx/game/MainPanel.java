package domonx.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import domonx.game.core.NeBasePanel;
import domonx.game.core.NeSyncFrame;
import domonx.game.core.controller.NeCardController;
import domonx.game.core.controller.NeDraggableController;
import domonx.game.core.controller.NeHorizontalContainerController;
import domonx.game.core.controller.NeVerticalContainerController;
import domonx.game.core.entity.NeAnimation;
import domonx.game.core.entity.NeImage;
import domonx.game.core.entity.NeVisualEntity;
import domonx.game.core.entity.containers.NeBoxContainer;
import domonx.game.core.entity.containers.NeHorizontalContainer;
import domonx.game.core.entity.containers.NeVerticalContainer;

public class MainPanel extends NeBasePanel implements KeyListener {
	private static final long serialVersionUID = -3192655610452170233L;
	private NeVerticalContainer<NeImage, NeImage> container;
	private NeVerticalContainer<NeImage, NeImage> container2;
	private NeVerticalContainer<NeImage, NeImage> container3;
	private NeHorizontalContainer<NeImage, NeImage> hand;
	NeHorizontalContainer<NeImage, NeVerticalContainer<NeImage, NeImage>> cMain;
	
	MainPanel(NeSyncFrame owner) {
		super(owner);
		
		owner.addKeyListener(this);
		
		NeVerticalContainerController c1 = new NeVerticalContainerController(owner);
		container = new NeVerticalContainer<NeImage, NeImage>(new NeImage(), c1);
		container.setControllerActivity(true);
		container.load("src/1.png");
		container.setScale(0.6);
		container.setMargin(4);
		container.setIndent(20);
		container.move(5, 300);
		NeCardController c = new NeCardController(owner);
		NeImage i = new NeImage(c);
		i.load("src/EN/Bat.png");
		container.addItem(i);
		
		NeVerticalContainerController c2 = new NeVerticalContainerController(owner);
		container2 = new NeVerticalContainer<NeImage, NeImage>(new NeImage(), c2);
		container2.setControllerActivity(true);
		container2.load("src/1.png");
		container2.setScale(0.6);
		container2.setMargin(4);
		container2.setIndent(20);
		container2.move(205, 300);
		
		NeVerticalContainerController c3 = new NeVerticalContainerController(owner);
		container3 = new NeVerticalContainer<NeImage, NeImage>(new NeImage(), c3);
		container3.setControllerActivity(true);
		container3.load("src/1.png");
		container3.setScale(0.6);
		container3.setMargin(4);
		container3.setIndent(20);
		container3.move(405, 300);
		
		cMain.addItem(container);
		cMain.addItem(container2);
		cMain.addItem(container3);		
		
		NeHorizontalContainerController c4 = new NeHorizontalContainerController(owner);
		hand = new NeHorizontalContainer<NeImage, NeImage>(new NeImage(), c4);
		hand.setControllerActivity(true);
		hand.load("src/2.png");
		hand.setScale(1.7);
		hand.setMargin(4);
		hand.setIndent(80);
		hand.move(5, 700);
		
		container2.possibleMoves.add(container);
		
		hand.possibleMoves.add(container);	
		hand.possibleMoves.add(container2);	
		hand.possibleMoves.add(container3);	
	}

	public void updateGame(int hertzPassed) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_1) {
			NeCardController c = new NeCardController(owner);
			NeImage i = new NeImage(c);
			i.load("src/EN/Bat.png");
			hand.addItem(i);
		}
		if (e.getKeyCode() == KeyEvent.VK_2) {
			NeCardController c = new NeCardController(owner);
			NeImage i = new NeImage(c);
			i.load("src/EN/Anthelope.png");
			hand.addItem(i);
		}
		if (e.getKeyCode() == KeyEvent.VK_0) {
			hand.removeItem(container.getSize() - 1);
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
		container2.draw(g, null);
		container3.draw(g, null);
		hand.draw(g, null);
	}

}
