package domonx.game.core.entity;

public interface NeEntity {	
	public int getPosX();
	public int getPosY();
	public int getWidth();
	public int getHeight();
	public int getNativeWidth();
	public int getNativeHeight();
	public void move(int xPos, int yPos);
	public boolean isPointInside(int xPos, int yPos);	
}
