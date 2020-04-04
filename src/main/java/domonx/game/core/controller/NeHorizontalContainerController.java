package domonx.game.core.controller;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import domonx.game.core.entity.NeEntity;
import domonx.game.core.entity.containers.NeHorizontalContainer;
import domonx.game.core.entity.containers.NeVerticalContainer;

public class NeHorizontalContainerController extends NeContainerController{
	public NeHorizontalContainerController(JFrame listener) {
		super(listener);
	}
	
	protected void manageContentControllers(MouseEvent e) {
		NeHorizontalContainer<?, ?> entity = (NeHorizontalContainer<?, ?>) this.entity;
		int indent = entity.getIndent();
		int x = entity.getX();
		int mouseX = e.getX();
		int shiftX = mouseX - x;
		int size = entity.getSize();
		if(size == 0) {
			return;
		}
		int index  = shiftX / indent;
		if (index > (size - 1)) {
			index = size - 1;
		}
		NeEntity possibleItem = entity.content.get(index);
		possibleItem.setControllerActivity(true);
		managedEntity = possibleItem;
	}
	
	@Override
	protected boolean isEntityViable() {
		return entity instanceof NeHorizontalContainer<?, ?>;
	}
}
