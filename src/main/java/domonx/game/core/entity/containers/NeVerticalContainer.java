package domonx.game.core.entity.containers;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeBaseEntity;
import domonx.game.core.entity.NeVisualEntity;
import domonx.game.core.entity.image.NeImage;

public class NeVerticalContainer extends NeImage {

	protected ArrayList<NeVisualEntity> content = new ArrayList<NeVisualEntity>();
	protected int indent = 10;

	private int margin = 0;
	private int currentIndent = 0;

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

	public void setHeight(int height) {
		this.height = height;
	}

	public void setMargin(int margin) {
		this.margin = margin;
		reload();
	}

	public int getMargin() {
		return margin;
	}

	public void draw(Graphics g, ImageObserver observer) {
		super.draw(g, observer);
		content.forEach(item -> {
			item.move(xPos + margin, yPos + currentIndent + margin);
			item.draw(g, observer);
			currentIndent += indent;
		});
		currentIndent = 0;
	}

	public void addItem(NeVisualEntity newItem) {
		if(content.contains(newItem)) {
			return;
		}
		content.add(loadItem(newItem));
	}
	
	public void removeItem(int index) {
		content.remove(index);
	}
	
	public int getSize() {
		return content.size();
	}

	public void reload() {
		super.reload();
		content.forEach(item -> {
			item = loadItem(item);
		});
	}

	private NeVisualEntity loadItem(NeVisualEntity item) {
		int width = item.getCachedWidth();
		double scale = (double) (this.width - 2 * margin) / width;
		item.setScale(scale);
		return item;
	}
}
