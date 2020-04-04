package domonx.game.core.controller;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import domonx.game.core.entity.NeEntity;
import domonx.game.core.entity.containers.NeHorizontalContainer;
import domonx.game.core.entity.containers.NeVerticalContainer;

public class NeVerticalContainerController extends NeContainerController{	
	public NeVerticalContainerController(JFrame listener) {
		super(listener);
	}
	
	protected void manageContentControllers(MouseEvent e) {
		NeVerticalContainer<?, ?> entity = (NeVerticalContainer<?, ?>) this.entity;
		int indent = entity.getIndent();
		int y = entity.getY();
		int mouseY = e.getY();
		int shiftY = mouseY - y;
		int size = entity.getSize();
		if(size == 0) {
			return;
		}
		int index  = shiftY / indent;
		if (index > (size - 1)) {
			index = size - 1;
		}
		NeEntity possibleItem = entity.content.get(index);
		possibleItem.setControllerActivity(true);
		managedEntity = possibleItem;
	}	
	
	@Override
	protected boolean isEntityViable() {
		return entity instanceof NeVerticalContainer<?, ?>;
	}
}
