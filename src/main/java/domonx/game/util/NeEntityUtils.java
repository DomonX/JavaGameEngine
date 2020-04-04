package domonx.game.util;

import domonx.game.core.NeFrameConfiguration;
import domonx.game.core.entity.NeEntity;

public class NeEntityUtils {
	public static boolean isPointInside(NeEntity entity, int x, int y) {
		return 
			entity.getX() <= x && 
			entity.getX() + entity.getWidth() >= x && 
			entity.getY() <= y && 
			entity.getY() + entity.getHeight() >= y;
	}
	public static String buildPath(String srcPath) {
		return NeFrameConfiguration.getPath() + "/" + srcPath;
	}
}
