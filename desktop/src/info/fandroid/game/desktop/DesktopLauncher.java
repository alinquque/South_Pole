package info.fandroid.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import info.fandroid.game.SouthPole;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SouthPole.WIDTH;
		config.height = SouthPole.HEIGHT;
		config.title = SouthPole.TITLE;
		new LwjglApplication(new SouthPole(), config);
	}
}
