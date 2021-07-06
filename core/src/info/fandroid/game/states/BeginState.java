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
import info.fandroid.game.sprites.AnimationTitle;
import info.fandroid.game.sprites.Bird;
import info.fandroid.game.sprites.Title;

public class BeginState extends State implements InputProcessor {

    private Texture background;


    public static Texture textureBird;
    public static AnimationBird birdAnimation;

    public int frameBird;
    public int rowIndexBird;
    public static int k;

    public static Title title;
    public static AnimationTitle titleAnimation;
    public static Texture textureTitle;

    private Sound click;

    public int y1;
    public int x2 = 50;

    Random random = new Random();

    public static ArrayList<Bird> birds;
    public static ArrayList<AnimationBird> birdAnimations;


    public BeginState(GameStateManager gsm) {
        super(gsm);

        background = new Texture("background_title.png");

        textureBird = new Texture("bird_title.png");

        birds = new ArrayList<>();
        birdAnimations = new ArrayList<>();
        k = 0;

        Gdx.input.setInputProcessor(this);

        birds.clear();
        birdAnimations.clear();

        textureTitle = new Texture("south_pole.png");

        title = new Title(320, 110, textureTitle);

        titleAnimation = new AnimationTitle(new TextureRegion(textureTitle), textureTitle, 1.0f);

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
            birdAnimation = new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, frameBird, k, rowIndexBird, "Begin");
            birdAnimations.add(birdAnimation);
            Bird bird = new Bird(340, y1, textureBird, "Begin");
            birds.add(bird);
            k++;
        }
        else{
            if (320 - birds.get(k-1).getPosition().x >= x2){
                birdAnimation = new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, frameBird, k, rowIndexBird, "Begin");
                birdAnimations.add(birdAnimation);
                Bird bird = new Bird(340, y1,  textureBird, "Begin");
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

        title.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, SouthPole.WIDTH, SouthPole.HEIGHT);

        for(int i=0; i<birds.size(); i++) {
            sb.draw(birds.get(i).getBirdBegin(), birds.get(i).getPosition().x, birds.get(i).getPosition().y);
        }

        sb.draw(title.getTitle(), title.getPosition().x, title.getPosition().y);

        sb.end();
    }

    @Override
    public void dispose() {
        title.dispose();
        background.dispose();
    }

    public static boolean birdAnimationIsChanged(int num, int rowIndex){
        if (rowIndex == 1){
            birdAnimations.set(num, new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, 0, num, 0, "Begin"));
        }
        else{
            birdAnimations.set(num, new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, 0, num, 1, "Begin"));
        }

        return false;
    }

    public static boolean titleAnimationIsChanged(){
        titleAnimation = new AnimationTitle(new TextureRegion(textureTitle), textureTitle, 1.0f);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (title.getPosition().x < 86) {
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            gsm.set(new MenuState(gsm));
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
