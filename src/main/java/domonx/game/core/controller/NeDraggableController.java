package domonx.game.core.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import domonx.game.core.entity.NeBaseEntity;
import domonx.game.core.entity.NeEntity;

public class NeDraggableController implements NeController, MouseListener, MouseMotionListener{
	
	NeEntity entity;
	
	private boolean clicked;

	private int offsetX = 0;
	private int offsetY = 0;

	protected int xPosOld = -25;
	protected int yPosOld = -1;
	
	public NeDraggableController(JFrame owner) {
		addListener(owner);
	}
	
	protected void setObjectClicked(int xPos, int yPos) {
		clicked = true;
		xPosOld = entity.getPosX();
		yPosOld = entity.getPosY();
		offsetX = xPos - entity.getPosX();
		offsetY = yPos - entity.getPosY();
	}

	protected void setObjectNotClicked() {
		this.clicked = false;
	}

	protected boolean isMovePermited() {
		return true;
	}

	protected void returnOldPosition() {
		entity.move(xPosOld, yPosOld);
	}

	@Override
	public void connectEntity(NeBaseEntity entity) {
		this.entity = entity;
		xPosOld = entity.getPosX();
		yPosOld = entity.getPosY();
	}

	@Override
	public void addListener(JFrame owner) {
		owner.addMouseListener(this);
		owner.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!this.clicked) {
			return;
		}
		entity.move(e.getX() - offsetX, e.getY() - offsetY);		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();
		if (entity.isPointInside(xPos, yPos)) {
			setObjectClicked(xPos, yPos);
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(!clicked) {
			return;
		}
		if (!isMovePermited()) {
			returnOldPosition();
		}
		setObjectNotClicked();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
