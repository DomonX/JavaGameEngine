package domonx.game.core.entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import domonx.game.core.NeConstantsRegistry;
import domonx.game.core.NeFrameConfiguration;
import domonx.game.core.controller.NeController;
import domonx.game.util.NeEntityUtils;

public abstract class NeVisualEntity extends NeBaseEntity implements NeVisual{

	protected String srcPath = "";
	protected boolean valid = false;
	protected double scale = 1;
	
	protected Dimension cachedSize;

	public NeVisualEntity() {
		super();
		cachedSize = new Dimension();
	}

	public NeVisualEntity(NeController controller) {
		super(controller);
		cachedSize = new Dimension();
	}
	
	public abstract void draw(Graphics g, ImageObserver observer);
	
	protected abstract void cache();
	
	protected abstract void cacheSize();

	protected abstract void reload();


	public void load(String srcPath) {
		buildPath(srcPath);
		cache();
		cacheSize();
		setDynamicSize();
		reload();
	}

	public void setScale(double scale) {
		if (scale < NeConstantsRegistry.MIN_SCALE) {
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
		return cachedSize.width;
	}

	public int getCachedHeight() {
		return cachedSize.height;
	}

	protected void setDynamicSize() {
		setWidth((int) (getCachedWidth() * scale));
		setHeight((int) (getCachedHeight() * scale));
	}

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
	
	protected void buildPath(String srcPath) {
		this.srcPath = NeEntityUtils.buildPath(srcPath);
	}
	
	protected void setCachedWidth(int width) {
		cachedSize.width = width;
	}

	protected void setCachedHeight(int height) {
		cachedSize.height = height;
	}

}
