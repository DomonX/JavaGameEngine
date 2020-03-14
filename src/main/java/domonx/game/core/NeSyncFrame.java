package domonx.game.core;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class NeSyncFrame extends JFrame implements KeyListener {
	private static final long serialVersionUID = 8590211693728083963L;
	private long TARGET_FPS = 75;
	private long TARGET_HERTZ = 60;
	private final int NANO_SECOND = 1000000000;
	private long FPS_UPDATE_TIME = NANO_SECOND / TARGET_FPS;
	private long HERTZ_UPDATE_TIME = NANO_SECOND / TARGET_HERTZ;
	private long currentNanoTimeFps = 0;
	private long currentNanoTimeHertz = 0;
	private long currentNanoTimeCounter = 0;
	protected int lastFps = (int) TARGET_FPS;
	private int currentFps = 0;

	protected NeSyncFrame() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addKeyListener(this);
	}

	public void enterMainLoop() {
		long lastNanoTime = System.nanoTime();
		while (true) {
			mainLoop();
			long currentNanoTime = System.nanoTime();
			long timeElapsed = currentNanoTime - lastNanoTime;
			lastNanoTime = currentNanoTime;
			currentNanoTimeFps += timeElapsed;
			currentNanoTimeHertz += timeElapsed;
			currentNanoTimeCounter += timeElapsed;
		}
	}

	private void mainLoop() {
		if (currentNanoTimeFps > FPS_UPDATE_TIME) {
			updateScreen();
			currentNanoTimeFps = 0;
			currentFps++;
		}
		if (currentNanoTimeHertz > HERTZ_UPDATE_TIME) {
			updateGame();
			currentNanoTimeHertz = 0;
		}
		if (currentNanoTimeCounter > NANO_SECOND) {
			lastFps = currentFps;
			currentNanoTimeCounter = 0;
			currentFps = 0;
		}
	}

	protected void updateScreen() {}

	protected void updateGame() {}

	public void changeTargetFps(long newFps) {
		if (newFps < 1) {
			newFps = 1;
		}
		TARGET_FPS = newFps;
		FPS_UPDATE_TIME = NANO_SECOND / TARGET_FPS;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
