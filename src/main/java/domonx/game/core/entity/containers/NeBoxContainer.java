package domonx.game.core.entity.containers;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeVisual;
import domonx.game.core.entity.NeVisualEntity;

public class NeBoxContainer<TContent extends NeVisualEntity> 
	extends NeBaseContainer<TContent> implements NeVisual{

	public NeBoxContainer() {
		super();
	}
	public NeBoxContainer(NeController controller) {
		super(controller);
	}
	
	protected Point getItemPosition(TContent item) {
		return new Point(item.getX(), item.getY());
	}

	@Override
	public void tick(int hertzPassed) {
		// TODO Auto-generated method stub		
	}

	@Override
	protected TContent reloadItem(TContent item) {
		// TODO Auto-generated method stub
		return item;
	}
	@Override
	public void draw(Graphics g, ImageObserver observer) {
		content.forEach(i -> {
			i.draw(g, observer);
		});		
	}
	@Override
	public void load(String srcPath) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getCachedWidth() {
		// TODO Auto-generated method stub
		return getWidth();
	}
	@Override
	public int getCachedHeight() {
		// TODO Auto-generated method stub
		return getHeight();
	}
	@Override
	public void setScale(double scale) {
		// TODO Auto-generated method stub		
	}
	@Override
	public double getScale() {
		// TODO Auto-generated method stub
		return 1;
	}
	public void setWidth(int width) {
		super.setWidth(width);
	}
	public void setHeight(int height) {
		super.setHeight(height);
	}
	
}
