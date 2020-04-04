package domonx.game.core.controller;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import domonx.game.core.entity.NeEntity;

public class NeHoverController extends NeMouseController{
	
	public NeHoverController(JFrame listener) {
		super(listener);
	}
	
	public void mouseMoved(MouseEvent e) {
		hovered = entity.isPointInside(e.getX(), e.getY());
	}

}
