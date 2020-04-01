package domonx.game.core.entity.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeVisualEntity;

public class NeImage extends NeVisualEntity {
	private Image frame;	
	private Image cashedFrame;
	
	public NeImage(NeController controller) {
		super(controller);
	}

	public NeImage() {}

	protected void reload() {
		if(!valid) {
			return;
		}
		this.frame = getScaledImage(cashedFrame);
	}
	
	protected void cache() {
		try {
			cashedFrame = ImageIO.read(new File(srcPath));
			cachedWidth = cashedFrame.getWidth(null);
			cachedHeight = cashedFrame.getHeight(null);
			valid = true;
		} catch (IOException e) {
			System.out.println("Couldnt load image");
			cashedFrame = null;
			valid = false;
		}
	}

	public void draw(Graphics g, ImageObserver observer) {
		if(!valid) {
			return;
		}
		g.drawImage(frame, xPos, yPos, observer);
	}
}
