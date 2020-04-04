package domonx.game.core.entity.containers;

import java.awt.Point;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeImage;
import domonx.game.core.entity.NeVisual;

public class NeIndentContainer<TBackground extends NeImage, TContent extends NeVisual>
		extends NeVisualContainer<TContent, TBackground> {

	public NeIndentContainer(TBackground background) {
		super(background);
	}

	public NeIndentContainer(TBackground background, NeController controller) {
		super(background, controller);
	}

	protected int indent = 0;

	protected int currentIndent = 0;

	public int getCurrentIndent() {
		return currentIndent;
	}

	public void setIndent(int newIndent) {
		indent = newIndent;
		reload();
	}

	public int getIndent() {
		return indent;
	}

	protected void afterDrawingItem() {
		currentIndent += indent;
	}

	protected void afterDrawing() {
		currentIndent = 0;
	}

	protected Point getItemPosition(TContent item) {
		return super.getItemPosition(item);
	}
}
