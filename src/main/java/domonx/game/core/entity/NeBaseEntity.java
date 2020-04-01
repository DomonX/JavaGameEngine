package domonx.game.core.entity;


import domonx.game.core.controller.NeController;

public abstract class NeBaseEntity implements NeEntity {
	NeController controller;
	
	protected NeBaseEntity(NeController controller) {
		controller.connectEntity(this);
	}
	protected NeBaseEntity() {}
	
	protected int xPos = 0;
	protected int yPos = 0;
	
	protected int width = 0;
	protected int height = 0;	

	@Override
	public int getPosX() {
		return xPos;
	}

	@Override
	public int getPosY() {
		return yPos;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void move(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public boolean isPointInside(int xPos, int yPos) {
		return this.xPos <= xPos && this.xPos + getWidth() >= xPos && this.yPos <= yPos && this.yPos + getHeight() >= yPos;
	}
}