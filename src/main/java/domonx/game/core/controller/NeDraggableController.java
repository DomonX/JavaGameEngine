package domonx.game.core.controller;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import domonx.game.core.entity.NeEntity;


public class NeDraggableController extends NeHoverController {

	public NeDraggableController(JFrame listener) {
		super(listener);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!clicked) {
			return;
		}
		move(e.getX() - offsetX, e.getY() - offsetY);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(hovered) {
			setObjectClicked(e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!clicked) {
			return;
		}
		if (!isMovePermitted()) {
			returnOldPosition();
		}
		setObjectNotClicked();
	}

}
