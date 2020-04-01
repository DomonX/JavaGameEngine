package domonx.game.core.entity;

import domonx.game.core.NeFrameConfiguration;
import domonx.game.core.controller.NeController;

public abstract class NeVisualEntity extends NeScalableEntity{
	
	protected String srcPath;
	
	public NeVisualEntity() {
		super();
	}

	public NeVisualEntity(NeController controller) {
		super(controller);
	}
	
	public void load(String srcPath) {
		this.srcPath = NeFrameConfiguration.getPath() + "/" + srcPath;
		cache();
		setDynamicSize();
		reload();
	}
	
	protected void cache() {}
	
	protected void cacheSize() {}

}
