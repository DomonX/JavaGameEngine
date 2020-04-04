package domonx.game.core.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class NeMouseController extends NeBaseController implements MouseListener, MouseMotionListener {

	protected boolean clicked;
	
	protected boolean hovered;

	protected int offsetX = 0;
	protected int offsetY = 0;

	public NeMouseController(JFrame listener) {
		super(listener);
	}

	protected void setObjectClicked(int xPos, int yPos) {
		clicked = true;
		xPosOld = entity.getX();
		yPosOld = entity.getY();
		offsetX = xPos - entity.getX();
		offsetY = yPos - entity.getY();
	}

	protected void setObjectNotClicked() {
		this.clicked = false;
	}

	@Override
	public void addListener(JFrame listener) {
		listener.addMouseListener(this);
		listener.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
