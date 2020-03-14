package domonx.game.core.controller;

import javax.swing.JFrame;

import domonx.game.core.entity.NeBaseEntity;

public interface NeController {
	public void connectEntity(NeBaseEntity entity);
	public void addListener(JFrame listener);
}
