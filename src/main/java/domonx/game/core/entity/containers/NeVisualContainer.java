package domonx.game.core.entity.containers;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeEntity;
import domonx.game.core.entity.NeVisual;
import domonx.game.core.entity.NeVisualEntity;

public class NeVisualContainer<TContent extends NeVisual, TBackground extends NeVisualEntity>
		extends NeBaseContainer<TContent> implements NeVisual {

	protected String srcPath = "";
	protected double scale = 1;

	protected int cachedWidth = 0;
	protected int cachedHeight = 0;

	protected boolean valid = false;

	protected int margin = 0;

	protected TBackground background;

	public NeVisualContainer(TBackground background) {
		this.background = background;
	}

	public NeVisualContainer(TBackground background, NeController controller) {
		super(controller);
		this.background = background;
	}

	@Override
	public void draw(Graphics g, ImageObserver observer) {
		background.draw(g, observer);
		beforeDrawing();
		content.forEach(i -> {
			beforeDrawingItem();
			Point itemPosition = getItemPosition(i);
			if (!i.isControllerActive()) {
				i.move(itemPosition.x, itemPosition.y);
			}
			i.draw(g, observer);
			afterDrawingItem();
		});
		afterDrawing();
	}

	@Override
	public void load(String srcPath) {
		background.load(srcPath);
		cachedWidth = background.getCachedWidth();
		cachedHeight = background.getCachedHeight();
		setDynamicSize();
	}

	@Override
	public void setScale(double scale) {
		this.scale = scale;
		background.setScale(scale);
		setDynamicSize();
		reload();
	}

	@Override
	public double getScale() {
		return scale;
	}

	@Override
	public int getCachedWidth() {
		return cachedWidth;
	}

	@Override
	public int getCachedHeight() {
		return cachedHeight;
	}

	public void setMargin(int margin) {
		this.margin = margin;
		reload();
	}

	public int getMargin() {
		return margin;
	}

	public void move(int x, int y) {
		super.move(x, y);
		background.move(x, y);
	}

	protected void setDynamicSize() {
		setWidth(background.getWidth());
		setHeight(background.getHeight());
	}

	protected void beforeDrawingItem() {

	}

	protected void afterDrawingItem() {

	}

	protected void beforeDrawing() {

	}

	protected void afterDrawing() {

	}

	protected Point getItemPosition(TContent item) {
		return new Point(getX() + margin, getY() + margin);
	}

	@Override
	protected TContent reloadItem(TContent item) {
		return item;
	}

	@Override
	public void tick(int hertzPassed) {
		// TODO Auto-generated method stub
	}

}
