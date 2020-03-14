package domonx.game.core.entity.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeScalableEntity;
import domonx.game.core.entity.NeVisualEntity;

public class NeImage extends NeVisualEntity {
	public NeImage(NeController controller) {
		super(controller);
	}

	public NeImage() {}
	
	private Image frame;
	
	protected void reload() {
 		if(srcPath == null) {
			return;
		}
		try {
			this.frame = getScaledImage(ImageIO.read(new File(srcPath)));
			this.width = frame.getWidth(null);
			this.height = frame.getHeight(null);
		} catch (IOException e) {
			this.frame = null;
		}
	}
	
	public void draw(Graphics g, ImageObserver observer) {
		g.drawImage(frame, xPos, yPos, observer);
	}
}
