package info.fandroid.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Random;

import info.fandroid.game.SouthPole;
import info.fandroid.game.sprites.AnimationBird;
import info.fandroid.game.sprites.Bird;

import static info.fandroid.game.SouthPole.touchPos;

public class SettingsState extends State implements InputProcessor {

    private Texture background;
    private Texture back;
    private Texture music;
    private Texture effects;
    private Texture on;
    private Texture off;


    public static Texture textureBird;
    public static AnimationBird birdAnimation;

    private Sound click;

    public int frameBird;
    public int rowIndexBird;
    public static int k;

    public int y1;
    public int x2 = 50;

    Random random = new Random();

    public static ArrayList<Bird> birds;
    public static ArrayList<AnimationBird> birdAnimations;

    public SettingsState(GameStateManager gsm) {
        super(gsm);

        background = new Texture("background_settings.png");
        back = new Texture("back.png");
        music = new Texture("music.png");
        effects = new Texture("effects.png");
        on = new Texture("on.png");
        off = new Texture("off.png");

        textureBird = new Texture("bird_settings.png");

        birds = new ArrayList<>();
        birdAnimations = new ArrayList<>();
        k = 0;

        Gdx.input.setInputProcessor(this);

        birds.clear();
        birdAnimations.clear();


        click = Gdx.audio.newSound(Gdx.files.internal("click.wav"));
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {
        y1 = random.nextInt(120) + 50;

        frameBird = random.nextInt(5);
        rowIndexBird = random.nextInt(2);

        if (birds.isEmpty()){
            birdAnimation = new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, frameBird, k, rowIndexBird, "Settings");
            birdAnimations.add(birdAnimation);
            Bird bird = new Bird(340, y1, textureBird, "Settings");
            birds.add(bird);
            k++;
        }
        else{
            if (320 - birds.get(k-1).getPosition().x >= x2){
                birdAnimation = new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, frameBird, k, rowIndexBird, "Settings");
                birdAnimations.add(birdAnimation);
                Bird bird = new Bird(340, y1,  textureBird, "Settings");
                birds.add(bird);
                k++;
                x2 = random.nextInt(100) + 50;
            }
            if (birds.get(0).getPosition().x < -16.0f){
                birds.remove(0);
                birdAnimations.remove(0);
                k--;
                for(int i = 0; i<birds.size(); i++) {
                    birds.get(i).index -= 1;
                    birdAnimations.get(i).index -= 1;
                }
            }
        }

        for(int i=0; i<birds.size(); i++) {
            birds.get(i).update(dt);
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, SouthPole.WIDTH, SouthPole.HEIGHT);

        for(int i=0; i<birds.size(); i++) {
            sb.draw(birds.get(i).getBirdSettings(), birds.get(i).getPosition().x, birds.get(i).getPosition().y);
        }
        sb.draw(back, 10, 174);
        sb.draw(music, 82, 132);
        sb.draw(effects, 82, 86);

        if (SouthPole.prefs.getString("checkmusic").equals("on")) {
            sb.draw(on, 181, 122);
        }
        else if (SouthPole.prefs.getString("checkmusic").equals("off")) {
            sb.draw(off, 181, 122);
        }
        if (SouthPole.prefs.getString("checkeffects").equals("on")) {
            sb.draw(on, 181, 76);
        }
        else if (SouthPole.prefs.getString("checkeffects").equals("off")) {
            sb.draw(off, 181, 76);
        }

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }

    public static boolean birdAnimationIsChanged(int num, int rowIndex){
        if (rowIndex == 1){
            birdAnimations.set(num, new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, 0, num, 0, "Settings"));
        }
        else{
            birdAnimations.set(num, new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, 0, num, 1, "Settings"));
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (touchPos.x >= 10 && touchPos.x <= 10 + 16 && touchPos.y >= 174 && touchPos.y <= 174 + 16){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            gsm.set(new MenuState(gsm));
        }

        if (touchPos.x >= 181 && touchPos.x <= 181 + 57 && touchPos.y >= 122 && touchPos.y <= 122 + 36){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }

            if (SouthPole.prefs.getString("checkmusic").equals("on")) {
                SouthPole.prefs.putString("checkmusic", "off");
                SouthPole.music_begin.setVolume(0.0f);
                SouthPole.prefs.flush();
            }
            else if (SouthPole.prefs.getString("checkmusic").equals("off")){
                SouthPole.prefs.putString("checkmusic", "on");
                SouthPole.music_begin.setVolume(0.6f);
                SouthPole.prefs.flush();
            }
        }

        if (touchPos.x >= 181 && touchPos.x <= 181 + 57 && touchPos.y >= 76 && touchPos.y <= 76 + 36){
            click.play(1.0f);
            if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                SouthPole.prefs.putString("checkeffects", "off");
                SouthPole.prefs.flush();
            }
            else if (SouthPole.prefs.getString("checkeffects").equals("off")){
                SouthPole.prefs.putString("checkeffects", "on");
                SouthPole.prefs.flush();
            }
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
