package domonx.game.core.controller;

import javax.swing.JFrame;

import domonx.game.core.entity.NeEntity;

public interface NeController {
	public void connectEntity(NeEntity entity);
	public void addListener(JFrame informer);
	public void move(int x, int y);
}
