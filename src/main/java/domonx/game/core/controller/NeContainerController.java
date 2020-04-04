package domonx.game.core.controller;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import domonx.game.core.NeFrameConfiguration;
import domonx.game.core.entity.NeEntity;
import domonx.game.core.entity.containers.NeVerticalContainer;

public class NeContainerController extends NeHoverController {
	
	public NeContainerController(JFrame listener) {
		super(listener);
	}
	
	protected NeEntity managedEntity;

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		if(!entity.isControllerActive()) {
			return;
		}
		if(!hovered) {
			return;
		}
		if(!isEntityViable()) {
			return;
		}
		try {
			manageContentControllers(e);
		} catch (Exception e1) {
			if(NeFrameConfiguration.isDeveloperMode()) {
				e1.printStackTrace();
			}
		}		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if(managedEntity == null) {
			return;
		}
		if(!entity.isControllerActive()) {
			return;
		}
		if(!isEntityViable()) {
			return;
		}
		try {
			managedEntity.setControllerActivity(false);
		} catch (Exception e1) {
			if(NeFrameConfiguration.isDeveloperMode()) {
				e1.printStackTrace();
			}
		}
	}
	
	protected void manageContentControllers(MouseEvent e) {}
	
	protected boolean isEntityViable() {
		return false;
	}
}
