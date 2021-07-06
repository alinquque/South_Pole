package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.states.PlayState;

public class Fish {
    private Vector3 position;
    public static AnimationFish fishAnimation;

    public static Texture texture;
    private float speed;
    private float speed2;
    private Rectangle boundsfish;
    public static boolean direction = true; //true - положительное направление, false - отрицательное

    public Fish(int x, int y){
        position = new Vector3(x, y, 0);
        texture = new Texture("fish.png");
        fishAnimation = new AnimationFish(new TextureRegion(texture), 0.5f);
        speed = 0.5f;
        speed2 = 0.5f;

        boundsfish = new Rectangle(x, y, texture.getWidth() / 5 - 6, texture.getHeight() - 6);

    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getFish() {
        return fishAnimation.getFrame();
    }

    public void update(float dt){
        fishAnimation.update(dt);
        position.x -= speed + PlayState.boost;
        if (direction) {
            position.y += speed2;
        }
        else{
            position.y -= speed2;
        }
        position.add(0, 0 , 0);

        boundsfish.setPosition(position.x, position.y);
    }

    public void dispose(){
        texture.dispose();
    }

    public boolean collides (Rectangle player){
        return player.overlaps(boundsfish);
    }

}
