package domonx.game.core.controller;

import javax.swing.JFrame;

public class NeCardController extends NeDraggableController{

	public NeCardController(JFrame listener) {
		super(listener);
	}
	
	protected boolean isMovePermitted() {
		return true;
	}

}
