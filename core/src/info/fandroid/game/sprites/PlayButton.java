package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.states.MenuState;
import info.fandroid.game.states.PlayState;

public class PlayButton {
    private Vector3 position;


    public static Texture texture;

    private String state;


    public PlayButton(int x, int y, Texture texture1, String state1){
        position = new Vector3(x, y, 0);
        texture = texture1;
        state = state1;
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getPlayButtonMenu() {
        return MenuState.playButtonAnimation.getFrame();
    }

    public TextureRegion getPlayButtonPlay() {
        return PlayState.playButtonAnimation.getFrame();
    }

    public void update(float dt){
        if (state == "Menu") {
            MenuState.playButtonAnimation.update(dt);
        }
        else if (state == "Play"){
            PlayState.playButtonAnimation.update(dt);
        }
        position.add(0, 0 , 0);
    }

    public void dispose(){
        texture.dispose();
    }
}
