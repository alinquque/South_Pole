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
import info.fandroid.game.sprites.AnimationPlayButton;
import info.fandroid.game.sprites.Bird;
import info.fandroid.game.sprites.PlayButton;

import static info.fandroid.game.SouthPole.touchPos;

public class MenuState extends State implements InputProcessor {

    private Texture background;
    private Texture settings;
    private Texture cust;


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

    public static PlayButton playButton;
    public static AnimationPlayButton playButtonAnimation;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background_menu.png");
        playButton = new PlayButton((SouthPole.WIDTH / 2) - 16, (SouthPole.HEIGHT / 2) - 16, new Texture("play.png"), "Menu");
        playButtonAnimation = new AnimationPlayButton(new TextureRegion(playButton.texture), playButton.texture, 4.0f, "Menu");
        settings = new Texture("settings.png");
        cust = new Texture("cust.png");

        textureBird = new Texture("bird_menu.png");

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
            birdAnimation = new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, frameBird, k, rowIndexBird, "Menu");
            birdAnimations.add(birdAnimation);
            Bird bird = new Bird(340, y1, textureBird, "Menu");
            birds.add(bird);
            k++;
        }
        else{
            if (320 - birds.get(k-1).getPosition().x >= x2){
                birdAnimation = new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, frameBird, k, rowIndexBird, "Menu");
                birdAnimations.add(birdAnimation);
                Bird bird = new Bird(340, y1,  textureBird, "Menu");
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

        playButton.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, SouthPole.WIDTH, SouthPole.HEIGHT);

        for(int i=0; i<birds.size(); i++) {
            sb.draw(birds.get(i).getBirdMenu(), birds.get(i).getPosition().x, birds.get(i).getPosition().y);
        }

        sb.draw(playButton.getPlayButtonMenu(), playButton.getPosition().x, playButton.getPosition().y);
        //sb.draw(playButton.getPlayButtonMenu(), playButton.getPosition().x, playButton.getPosition().y);
        sb.draw(settings, 10, 174);
        sb.draw(cust, 294, 174);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }

    public static boolean birdAnimationIsChanged(int num, int rowIndex){
        if (rowIndex == 1){
            birdAnimations.set(num, new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, 0, num, 0, "Menu"));
        }
        else{
            birdAnimations.set(num, new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, 0, num, 1, "Menu"));
        }

        return false;
    }

    public static boolean playButtonAnimationIsChanged(){
        playButtonAnimation = new AnimationPlayButton(new TextureRegion(playButton.texture), playButton.texture, 4.0f, "Menu");
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (touchPos.x >= 144 && touchPos.x <= 144 + 32 && touchPos.y >= 84 && touchPos.y <= 84 + 32){
            if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                click.play(1.0f);
            }
            SouthPole.music_begin.stop();
            gsm.set(new PlayState(gsm));
            PlayState.touch_count++;
        }

        if (touchPos.x >= 10 && touchPos.x <= 10 + 16 && touchPos.y >= 174 && touchPos.y <= 174 + 16){
            if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                click.play(1.0f);
            }
            gsm.set(new SettingsState(gsm));
        }

        if (touchPos.x >= 294 && touchPos.x <= 294 + 16 && touchPos.y >= 174 && touchPos.y <= 174 + 16){
            if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                click.play(1.0f);
            }
            gsm.set(new CustomizationState(gsm));
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
