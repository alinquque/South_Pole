package info.fandroid.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import info.fandroid.game.states.PlayState;


public class AndroidLauncher extends AndroidApplication {


	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useCompass = false;
		config.useAccelerometer = false;
		config.useImmersiveMode = true;
		initialize(new SouthPole(), config);

	}

	@Override
	public void onStop() {
		super.onStop();
		PlayState.fly.stop();
		PlayState.gamestatus = "PAUSE";
	}
}
