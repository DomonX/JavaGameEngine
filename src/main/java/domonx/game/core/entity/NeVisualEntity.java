package domonx.game.core.entity;

import domonx.game.core.controller.NeController;

public class NeVisualEntity extends NeScalableEntity{
	
	protected String srcPath;
		
	public NeVisualEntity() {
		super();
	}

	public NeVisualEntity(NeController controller) {
		super(controller);
	}
	
	public void load(String srcPath) {
		this.srcPath = srcPath;
		reload();
	}

}
