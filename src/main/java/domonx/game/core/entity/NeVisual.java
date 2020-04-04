package domonx.game.core.entity;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface NeVisual extends NeEntity{

	public void load(String srcPath);

	public int getCachedWidth();

	public int getCachedHeight();
	
	public void draw(Graphics g, ImageObserver observer);
	
	public void setScale(double scale);

	public double getScale();
}
