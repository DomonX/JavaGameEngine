package domonx.game.core.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import domonx.game.core.controller.NeController;

public abstract class NeScalableEntity extends NeBaseEntity {

	public NeScalableEntity(NeController controller) {
		super(controller);
	}
	public NeScalableEntity() {}
	
	protected boolean valid;

	protected double scale = 1;	
	
	protected int cachedWidth = 0;
	protected int cachedHeight = 0;

	public void setScale(double scale) {
		if(scale < 0.001) {
			return;
		}
		this.scale = scale;
		setDynamicSize();
		reload();
	}
	
	public double getScale() {
		return scale;
	}
	
	public int getCachedWidth() {
		return cachedWidth;
	}
	public int getCachedHeight() {
		return cachedHeight;
	}
	
	protected void setDynamicSize() {
		this.width = (int) (cachedWidth * scale);
		this.height = (int) (cachedHeight * scale);
	}
	
	protected void reload() {}
	
	protected void rescale() {}
	
	protected Image getScaledImage(Image source, int width, int height) {
		if (scale == 1) {
			return source;
		}
		return source.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
	}
	
	protected Image getScaledImage(Image source) {
		if (scale == 1) {
			return source;
		}
		int width = source.getWidth(null);
		int height = source.getHeight(null);
		return source.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
	}

	public void draw(Graphics g, ImageObserver observer) {}


}
