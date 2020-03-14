package domonx.game.core.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import domonx.game.core.controller.NeController;

public class NeScalableEntity extends NeBaseEntity {

	public NeScalableEntity(NeController controller) {
		super(controller);
	}
	public NeScalableEntity() {}
	
	protected boolean valid;

	protected double scale = 1;	

	public void setScale(double scale) {
//		this.scale = scale;
//		rescale();
	}
	
	protected void reload() {}
	
	protected void rescale() {}

	protected Image getScaledImage(Image source, int width, int height) {
//		if (scale == 1) {
//			return source;
//		}
//		return source.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
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
