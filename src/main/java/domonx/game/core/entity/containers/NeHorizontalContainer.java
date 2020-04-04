package domonx.game.core.entity.containers;

import java.awt.Point;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeImage;
import domonx.game.core.entity.NeVisual;

public class NeHorizontalContainer<TBackground extends NeImage, TContent extends NeVisual>
		extends NeIndentContainer<TBackground, TContent> {
	public NeHorizontalContainer(TBackground background) {
		super(background);
	}

	public NeHorizontalContainer(TBackground background, NeController controller) {
		super(background, controller);
	}

	protected Point getItemPosition(TContent item) {
		Point position = super.getItemPosition(item);
		position.x += currentIndent;
		return position;
	}

	protected TContent reloadItem(TContent item) {
		double scale = (double) (getHeight() - (2 * margin)) / item.getCachedHeight();
		item.setScale(scale);
		return item;
	}
}
