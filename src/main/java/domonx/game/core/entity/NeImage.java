package domonx.game.core.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import domonx.game.core.controller.NeController;

public class NeImage extends NeVisualEntity {

	private Image frame;
	private Image cashedFrame;

	public NeImage(NeController controller) {
		super(controller);
	}

	public NeImage() {
		super();
	}

	protected void reload() {
		if (!valid) {
			return;
		}
		this.frame = getScaledImage(cashedFrame);
	}

	protected void cache() {
		try {
			cashedFrame = ImageIO.read(new File(srcPath));
			valid = true;
		} catch (IOException e) {
			cashedFrame = null;
			valid = false;
		}
	}

	public void draw(Graphics g, ImageObserver observer) {
		if (!valid) {
			return;
		}
		g.drawImage(frame, getX(), getY(), observer);
	}

	@Override
	protected void cacheSize() {
		setCachedWidth(cashedFrame.getWidth(null));
		setCachedHeight(cashedFrame.getHeight(null));
	}

	@Override
	public void tick(int hertzPassed) {}

}
