package domonx.game.core.controller;

import javax.swing.JFrame;

import domonx.game.core.entity.NeEntity;
import domonx.game.core.entity.containers.NeBaseContainer;

public class NeCardController extends NeDraggableController{

	public NeCardController(JFrame listener) {
		super(listener);
	}
	
	@SuppressWarnings("unchecked")
	protected boolean isMovePermitted() {
		NeEntity owner = entity.getOwner();
		if(owner == null) {
			return true;
		}
		NeBaseContainer<NeEntity> ownerContainer = null;
		if(owner instanceof NeBaseContainer<?>) {
			ownerContainer = (NeBaseContainer<NeEntity>)owner;
		}
		if(ownerContainer == null) {
			return true;
		}
		int x = entity.getX() + offsetX;
		int y = entity.getY() + offsetY;
		for(NeBaseContainer<NeEntity> newContainer : ownerContainer.possibleMoves) {
			if(!newContainer.isPointInside(x, y)) {
				continue;
			}
			if(ownerContainer != null) {
				int index = ownerContainer.getItemIndex(entity);
				ownerContainer.removeItem(index);			
			}
			newContainer.addItem(entity);
			return true;
		}
		return true;
	}

}
