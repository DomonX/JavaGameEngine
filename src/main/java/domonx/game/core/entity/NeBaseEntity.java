package domonx.game.core.entity;

import java.awt.Dimension;
import java.awt.Point;

import domonx.game.core.controller.NeController;
import domonx.game.util.NeEntityUtils;

public abstract class NeBaseEntity implements NeEntity {

	protected NeBaseEntity(NeController controller) {
		this.controller = controller;
		position = new Point();
		size = new Dimension();
		controller.connectEntity(this);
	}

	protected NeBaseEntity() {
		position = new Point();
		size = new Dimension();
	}

	protected Point position;
	protected Dimension size;

	protected NeController controller;
	protected NeEntity owner;
	
	protected boolean controllerActive;

	public NeEntity getOwner() {
		return owner;
	}

	public void setOwner(NeEntity owner) {
		this.owner = owner;
	}

	@Override
	public int getX() {
		return position.x;
	}

	@Override
	public int getY() {
		return position.y;
	}

	@Override
	public int getWidth() {
		return size.width;
	}

	@Override
	public int getHeight() {
		return size.height;
	}

	@Override
	public void move(int x, int y) {
		this.position.x = x;
		this.position.y = y;
	}

	@Override
	public boolean isPointInside(int xPos, int yPos) {
		return NeEntityUtils.isPointInside(this, xPos, yPos);
	}

	protected void setWidth(int width) {
		size.width = width;
	}

	protected void setHeight(int height) {
		size.height = height;
	}
	
	public boolean isControllerActive() {
		return controllerActive;
	}
	
	public void setControllerActivity(boolean activity) {
		controllerActive = activity;
	}

}