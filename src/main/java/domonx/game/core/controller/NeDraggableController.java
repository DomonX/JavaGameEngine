package domonx.game.core.controller;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;


public class NeDraggableController extends NeMouseController {

	public NeDraggableController(JFrame listener) {
		super(listener);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!this.clicked) {
			return;
		}
		entity.move(e.getX() - offsetX, e.getY() - offsetY);
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
		if (!clicked) {
			return;
		}
		if (!isMovePermitted()) {
			returnOldPosition();
		}
		setObjectNotClicked();
	}

}
