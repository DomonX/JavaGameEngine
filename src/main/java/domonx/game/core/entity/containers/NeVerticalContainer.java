package domonx.game.core.entity.containers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeBaseEntity;
import domonx.game.core.entity.NeScalableEntity;

public class NeVerticalContainer extends NeBaseEntity {

	private Image background;
	private int margin = 0;

	private int currentIndent = 0;
	
	private boolean waitsForReload = false;
	protected ArrayList<NeScalableEntity> content = new ArrayList<NeScalableEntity>();
	protected int indent = 10;

	public NeVerticalContainer() {
	}

	public NeVerticalContainer(NeController controller) {
		super(controller);
	}

	public void setIndent(int newIndent) {
		indent = newIndent;
		reload();
	}
	
	public int getIndent() {
		return indent;
	}

	public void setWidth(int width) {
		this.width = width;
		reload();
	}
	
	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setMargin(int margin) {
		this.margin = margin;
		reload();
	}
	
	public int getMargin() {
		return margin;
	}

	public void draw(Graphics g, ImageObserver observer) {
		content.forEach(item -> {
			item.move(xPos, yPos + currentIndent);
			item.draw(g, observer);
			currentIndent += indent;
		});
		currentIndent = 0;
	}

	public void addItem(NeScalableEntity newItem) {
		content.add(loadItem(newItem));
	}

	public void reload() {
		content.forEach(item -> {
			item = loadItem(item);
		});
	}

	private NeScalableEntity loadItem(NeScalableEntity item) {
		int width = item.getWidth();
		double scale = (double) this.width / width;
		item.setScale(scale);
		return item;
	}
}
