package domonx.game.core.entity.containers;

import domonx.game.core.entity.NeEntity;

public interface NeContainer<TContent extends NeEntity> {
	public void addItem(TContent newItem);
	public void removeItem(int index);
	public int getSize();
}
