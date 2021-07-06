package info.fandroid.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.SouthPole;
import info.fandroid.game.states.PlayState;

public class Pinguin {
    public static String act = "";
    public static String old_act = "";
    public static float GRAVITY;
    private Vector3 position;
    private static Vector3 velosity;
    private Rectangle boundsping;
    public static boolean collides;

    private static Sound jump;

    public static Texture texture;
    public static boolean actIsChanged = false;

    public Pinguin(int x, int y){
        GRAVITY = -3;
        collides = false;
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);

        if (SouthPole.prefs.getString("pinguinSkin").equals("pinguin")) texture = new Texture("ping_frames.png");
        else if (SouthPole.prefs.getString("pinguinSkin").equals("orange")) texture = new Texture("orange.png");
        else if (SouthPole.prefs.getString("pinguinSkin").equals("baby")) texture = new Texture("baby.png");
        else if (SouthPole.prefs.getString("pinguinSkin").equals("cock")) texture = new Texture("cock.png");
        else if (SouthPole.prefs.getString("pinguinSkin").equals("superping")) texture = new Texture("superping.png");
        else if (SouthPole.prefs.getString("pinguinSkin").equals("hohlatiy")) texture = new Texture("hohlatiy.png");


        boundsping = new Rectangle(x, y, texture.getWidth() /3, texture.getHeight() /4 - 15);
        jump = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getPinguin() {
        return PlayState.pinguinAnimation.getFrame();
    }

    public void update(float dt){

        PlayState.pinguinAnimation.update(dt);
        if (position.y > 0)
            velosity.add(0, GRAVITY, 0);
        velosity.scl(dt);
        position.add(0, velosity.y, 0);
        if(position.y < -10)
            collides = true;
        if(position.y > 178){
            position.y = 178;
        }

        velosity.scl(1 / dt);

        boundsping.setPosition(position.x, position.y);
    }

    public static void jump(){
        velosity.y = 75;
        if (SouthPole.prefs.getString("checkeffects").equals("on")) {
            jump.play(1.0f);
        }
    }

    public static void touchDown(){
        velosity.y = 0;
    }

    public void dispose(){
        texture.dispose();
        jump.dispose();
    }

    public Rectangle getBounds(){
        return boundsping;
    }


}
