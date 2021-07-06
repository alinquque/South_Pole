package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.states.BeginState;

public class Title {

    private Vector3 position;
    private float speed;


    public static Texture texture;

    public Title(int x, int y, Texture texture1){
        position = new Vector3(x, y, 0);
        texture = texture1;
        speed = 0.625f;
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTitle() {
        return BeginState.titleAnimation.getFrame();
    }

    public void update(float dt){
        BeginState.titleAnimation.update(dt);
        if (position.x >= 86) {
            position.x -= speed;
        }
        position.add(0, 0 , 0);
    }

    public void dispose(){
        texture.dispose();
    }
}
