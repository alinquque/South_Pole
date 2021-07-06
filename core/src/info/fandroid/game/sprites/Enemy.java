package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.states.PlayState;

public class Enemy {
    private Vector3 position;
    private float speed;
    private Rectangle boundsenemy;
    public int index;


    public static Texture texture;


    public Enemy(int x, int y, Texture texture1){
        position = new Vector3(x, y, 0);
        texture = texture1;
        speed = 0.5f;

        index = PlayState.k;
        boundsenemy = new Rectangle(x, y, texture.getWidth() /5, texture.getHeight() /2 - 10);

    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getEnemy() {
        return PlayState.enemyAnimations.get(index).getFrame();
    }

    public void update(float dt){
        PlayState.enemyAnimations.get(index).update(dt);
        position.x -= speed + PlayState.boost;
        position.add(0, 0 , 0);

        boundsenemy.setPosition(position.x, position.y);
    }

    public void dispose(){
        texture.dispose();
    }

    public boolean collides (Rectangle player){
        return player.overlaps(boundsenemy);
    }

}
