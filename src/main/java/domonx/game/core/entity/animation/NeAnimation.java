package domonx.game.core.entity.animation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeScalableEntity;
import domonx.game.core.entity.NeVisualEntity;

public class NeAnimation extends NeVisualEntity {

	public NeAnimation(NeController controller) {
		super(controller);
	}
	private Image[] frames;
	private int hertzForFrame = 1;
	private int xFrames = 1;
	private int yFrames = 1;
	private int sumFrames = 1;
	private int currentAnimationCounter = 0;
	private int currentAnimationFrame = 0;	
	
	public boolean isLoop = true;
	private boolean hasFinished = false;
	
	public void load(String path, int xFrames, int yFrames) {
		this.xFrames = xFrames;
		this.yFrames = yFrames;
		sumFrames = xFrames * yFrames;
		srcPath = path;
		reload();
	}
	
	public void reload() {
		if(srcPath == null) {
			return;
		}
		try {
			frames = slice();
			valid = true;
		} catch (IOException e) {
			frames = new Image[xFrames * yFrames];
			valid = false;
		}
	}
	
	public void setHertz(int newHertz) {
		this.hertzForFrame = newHertz; 
	}
	
	public void restart() {
		currentAnimationFrame = 0;
		hasFinished = false;
	}
	
	public void tick() {
		if (hasFinished) {
			return;
		}
		if (!valid) {
			return;
		}
		currentAnimationCounter++;
		if (currentAnimationCounter > hertzForFrame) {
			currentAnimationFrame++;
			currentAnimationCounter = 0;
		}
		if (currentAnimationFrame > sumFrames - 1) {
			if(isLoop) {
				currentAnimationFrame = 0;
			} else {
				currentAnimationFrame = sumFrames - 1;
				hasFinished = true;
			}
		}
	}
	public void draw(Graphics g, ImageObserver observer) {
		g.drawImage(frames[currentAnimationFrame], getDrawX(), getDrawY(), observer);
	}
	protected int getDrawX() {
		return xPos;
	}
	protected int getDrawY() {
		return yPos;
	}
	private Image[] slice() throws IOException {
		System.out.println(srcPath);
		BufferedImage x = ImageIO.read(new File(srcPath));
		Image[] slicedImage = new Image[xFrames * yFrames];
		int width = x.getWidth();
		int xOffset = width / xFrames;
		this.width = (int) (xOffset * scale);
		int height = x.getHeight();
		int yOffset = height / yFrames;
		this.height = (int) (yOffset * scale);
		int currentWidth = 0;
		int currentHeight = 0;
		int i = 0;
		int j = 0;
		while (i < xFrames) {
			while(j < yFrames) {
				int index = i * yFrames + j;
				slicedImage[index] = getScaledImage(x.getSubimage(currentWidth, currentHeight, xOffset, yOffset), xOffset, yOffset);
				currentHeight += yOffset;
				j++;
			}
			j = 0;
			currentHeight = 0;
			currentWidth += xOffset;
			i++;
		}
		return slicedImage;
	}

}
