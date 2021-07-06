package info.fandroid.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import info.fandroid.game.states.BeginState;
import info.fandroid.game.states.GameStateManager;

public class SouthPole extends ApplicationAdapter {
	public static final int WIDTH = 320;
	public static final int HEIGHT = 200;

	public static final String TITLE = "South Pole";

	private GameStateManager gsm;
	private SpriteBatch batch;

	private OrthographicCamera cam;
	private StretchViewport viewport;

	public static Preferences prefs;

	public static Vector3 touchPos;

	public static Music music_begin;


	@Override
	public void create () {
		touchPos = new Vector3();

		batch = new SpriteBatch();

		prefs = Gdx.app.getPreferences("My Preferences");

		cam = new OrthographicCamera();
		viewport = new StretchViewport(WIDTH, HEIGHT, cam);
		viewport.apply();
		cam.position.set(WIDTH / 2, HEIGHT / 2, 0);
		cam.update();

		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new BeginState(gsm));

		if (prefs.getString("checkmusic").equals("")){
			prefs.putString("checkmusic", "on");
			prefs.flush();
		}
		if (prefs.getString("checkeffects").equals("")){
			prefs.putString("checkeffects", "on");
			prefs.flush();
		}

		if (prefs.getString("pinguinSkin").equals("")){
			prefs.putString("pinguinSkin", "pinguin");
			prefs.flush();
		}

		if (prefs.getString("pinguin").equals("")){
			prefs.putString("pinguin", "yes");
			prefs.flush();
		}
		if (prefs.getString("orange").equals("")){
			prefs.putString("orange", "no");
			prefs.flush();
		}
		if (prefs.getString("baby").equals("")){
			prefs.putString("baby", "no");
			prefs.flush();
		}
		if (prefs.getString("cock").equals("")){
			prefs.putString("cock", "no");
			prefs.flush();
		}
		if (prefs.getString("superping").equals("")){
			prefs.putString("superping", "no");
			prefs.flush();
		}
		if (prefs.getString("hohlatiy").equals("")){
			prefs.putString("hohlatiy", "no");
			prefs.flush();
		}

		music_begin = Gdx.audio.newMusic(Gdx.files.internal("South Pole Start.wav"));
		music_begin.setLooping(true);
		if (prefs.getString("checkmusic").equals("on")){
			music_begin.setVolume(0.6f);
		}
		else if (prefs.getString("checkmusic").equals("off")){
			music_begin.setVolume(0.0f);
		}
		music_begin.play();

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
		batch.setProjectionMatrix(cam.combined);
		super.render();

		if (Gdx.input.isTouched()) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			cam.unproject(touchPos);  //преобразование координат нажатия в ваши рабочие координаты (координаты камеры)
		}

	}

	@Override
	public void resize (int width, int height) {
		viewport.update(width, height);
		super.resize(width, height);
	}

	@Override
	public void dispose () {
		super.dispose();
		music_begin.dispose();
	}

}
