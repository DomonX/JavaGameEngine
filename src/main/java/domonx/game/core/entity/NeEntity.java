package domonx.game.core.entity;

public interface NeEntity {
	public int getX();

	public int getY();

	public int getWidth();

	public int getHeight();

	public NeEntity getOwner();

	public void setOwner(NeEntity owner);

	public void move(int xPos, int yPos);

	public boolean isPointInside(int xPos, int yPos);
	
	public void tick(int hertzPassed);
	
	public boolean isControllerActive();
	
	public void setControllerActivity(boolean activity);
}
