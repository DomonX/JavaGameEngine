package domonx.game.core.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import domonx.game.core.NeFrameConfiguration;
import domonx.game.core.controller.NeController;

public class NeAnimation extends NeVisualEntity {

	public NeAnimation(NeController controller) {
		super(controller);
	}

	public NeAnimation() {
		super();
	}

	public boolean isLoop = true;

	private Image[] frames;
	private int hertzForFrame = 1;
	private int xFrames = 1;
	private int yFrames = 1;
	private int sumFrames = 1;
	private int currentAnimationCounter = 0;
	private int currentAnimationFrame = 0;
	private boolean hasFinished = false;

	public void load(String path, int xFrames, int yFrames) {
		this.xFrames = xFrames;
		this.yFrames = yFrames;
		sumFrames = xFrames * yFrames;
		super.load(path);
	}

	public void load(String path) {
		if (NeFrameConfiguration.isDeveloperMode()) {
			System.out.println("You are loading NeAnimation from " + path
					+ " using NeVisualEntity loader instead of NeAnimation loader"
					+ "Default frames configuration is 1/1 so it will work as static image");
		}
		super.load(path);
	}

	protected void reload() {
		try {
			slice();
			valid = true;
		} catch (IOException e) {
			frames = new Image[sumFrames];
			valid = false;
			if(NeFrameConfiguration.isDeveloperMode()) {
				e.printStackTrace();
			}
		}
	}

	public void setHertz(int newHertz) {
		this.hertzForFrame = newHertz;
	}

	public void restart() {
		currentAnimationFrame = 0;
		hasFinished = false;
	}

	public void tick(int hertzPassed) {
		if (hasFinished) {
			return;
		}
		if (!valid) {
			return;
		}
		currentAnimationCounter += hertzPassed;
		if (currentAnimationCounter > hertzForFrame) {
			currentAnimationFrame++;
			currentAnimationCounter -= hertzForFrame;
		}
		if (currentAnimationFrame <= sumFrames - 1) {
			return;
		}
		if (isLoop) {
			currentAnimationFrame = 0;
		} else {
			currentAnimationFrame = sumFrames - 1;
			hasFinished = true;
		}
	}

	public void draw(Graphics g, ImageObserver observer) {
		g.drawImage(frames[currentAnimationFrame], getX(), getY(), observer);
	}

	private void slice() throws IOException {
		BufferedImage allFramesImage = ImageIO.read(new File(srcPath));
		Image[] frameImages = new Image[sumFrames];
		int widthOfAllFrames = allFramesImage.getWidth();
		int heightOfAllFrames = allFramesImage.getHeight();
		int widthOfOneFrame = widthOfAllFrames / xFrames;
		int heightOfOneFrame = heightOfAllFrames / yFrames;
		setWidth((int) (widthOfOneFrame * getScale()));
		setHeight((int) (heightOfOneFrame * getScale()));
		int i = 0;
		int j = 0;
		while (true) {
			int currentX = widthOfOneFrame * i;
			int currentY = heightOfOneFrame * j;
			int index = i * yFrames + j;
			BufferedImage currentFrame = allFramesImage.getSubimage(currentX, currentY, widthOfOneFrame,
					heightOfOneFrame);
			frameImages[index] = getScaledImage(currentFrame);
			j++;
			if (j >= yFrames) {
				j = 0;
				i++;
			}
			if (i >= xFrames) {
				break;
			}
		}
		frames = frameImages;
	}

	@Override
	protected void cache() {
	}

	@Override
	protected void cacheSize() {

	}

}
