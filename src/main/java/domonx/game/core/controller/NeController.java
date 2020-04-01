package domonx.game.core.controller;

import javax.swing.JFrame;

import domonx.game.core.entity.NeEntity;

public interface NeController {
	/** 
	 *  
	 * @param entity Entity that will be controller by this controller;
	 */
	public void connectEntity(NeEntity entity);
	/**
	 * This method needs to have at least one of methods listed below:
	 * informer.addMouseMotionListener(this) - to create controller using mouse motion
	 * informer.addMouseListener(this) - to create controller using mouse clicks
	 * informer.addMouseWheelListener(this) -
	 * informer.addKeyListener(this) - to create controller using keyboard
	 * @param informer Frame that will tell this controller about actions that happened
	 */
	public void addListener(JFrame informer);
}
