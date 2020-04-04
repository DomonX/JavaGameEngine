package domonx.game.core.entity.containers;

import java.util.ArrayList;

import domonx.game.core.controller.NeController;
import domonx.game.core.entity.NeBaseEntity;
import domonx.game.core.entity.NeEntity;

public abstract class NeBaseContainer<TContent extends NeEntity> extends NeBaseEntity implements NeContainer<TContent> {
	
	NeBaseContainer(){
		super();
	}
	
	NeBaseContainer(NeController controller){
		super(controller);
	}
	
	public ArrayList<NeBaseContainer<TContent>> possibleMoves = new ArrayList<NeBaseContainer<TContent>>();
	
	public ArrayList<TContent> content = new ArrayList<TContent>();
	
	protected NeEntity owner;
	
	
	public void addItem(TContent newItem) {
		if (content.contains(newItem)) {
			return;
		}
		newItem.setOwner(this);
		content.add(reloadItem(newItem));
	}
	
	public boolean hasItem(TContent item) {
		return content.contains(item);
	}
	
	public void removeItem(int index) {
		content.get(index).setOwner(null);
		content.remove(index);
	}
	
	public int getItemIndex(TContent item) {
		return content.lastIndexOf(item);
	}
	
	public int getSize() {
		return content.size();
	}
	
	public void setItemController(int index, boolean state) {
		content.get(index).setControllerActivity(state);
	}
	
	protected abstract TContent reloadItem(TContent item);
	
	protected void reload() {
		content.forEach(item -> {
			item = reloadItem(item);
		});
	}

}
