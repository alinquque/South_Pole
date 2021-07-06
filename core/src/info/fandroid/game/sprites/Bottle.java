package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.states.PlayState;

public class Bottle {

    private Vector3 position;
    public static AnimationBottle bottleAnimation;

    public static Texture texture;
    private float speed;
    private float speed2;
    private Rectangle boundsbottle;
    public static boolean direction = true; //true - положительное направление, false - отрицательное

    public Bottle(int x, int y){
        position = new Vector3(x, y, 0);
        texture = new Texture("bottle.png");
        bottleAnimation = new AnimationBottle(new TextureRegion(texture), 0.5f);
        speed = 0.5f;
        speed2 = 0.5f;

        boundsbottle = new Rectangle(x, y, texture.getWidth() / 6 - 6, texture.getHeight() - 10);

    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getBottle() {
        return bottleAnimation.getFrame();
    }

    public void update(float dt){
        bottleAnimation.update(dt);
        position.x -= speed + PlayState.boost;
        if (direction) {
            position.y += speed2;
        }
        else{
            position.y -= speed2;
        }
        position.add(0, 0 , 0);

        boundsbottle.setPosition(position.x, position.y);
    }

    public void dispose(){
        texture.dispose();
    }

    public boolean collides (Rectangle player){
        return player.overlaps(boundsbottle);
    }
}
