package domonx.game.core.controller;

import javax.swing.JFrame;

import domonx.game.core.entity.NeEntity;

public abstract class NeBaseController implements NeController {

	protected int xPosOld = -1;
	protected int yPosOld = -1;
	protected NeEntity entity;
	
	public abstract void addListener(JFrame listener);

	public NeBaseController(JFrame listener) {
		addListener(listener);
	}

	@Override
	public void connectEntity(NeEntity entity) {
		this.entity = entity;
		xPosOld = entity.getX();
		yPosOld = entity.getY();
	}

	protected void returnOldPosition() {
		move(xPosOld, yPosOld);
	}
	
	protected boolean isMovePermitted() {
		return true;
	}
	
	public void move(int x, int y) {
		if(!entity.isControllerActive()) {
			return;
		}
		entity.move(x, y);
	}

}
