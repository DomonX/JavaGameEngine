package domonx.game;

import domonx.game.core.NeSyncFrame;

public class MainFrame extends NeSyncFrame {
	private static final long serialVersionUID = 8590211693728083963L;
	private MainPanel panel;

	public MainFrame() {
		super();
		setTitle("Application");
		panel = new MainPanel(this);
		panel.showFps();
		add(panel);
	}

	protected void updateScreen() {
		super.updateScreen();
		panel.repaint();
	}

	protected void updateGame(int hertzPassed) {
		super.updateGame(hertzPassed);
		panel.updateGame(hertzPassed);
	}

}
