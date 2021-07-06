package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.states.BeginState;
import info.fandroid.game.states.CustomizationState;
import info.fandroid.game.states.MenuState;
import info.fandroid.game.states.SettingsState;

public class Bird {
    private Vector3 position;
    private float speed;
    public int index;


    public static Texture texture;

    String state;


    public Bird(int x, int y, Texture texture1, String state1){
        position = new Vector3(x, y, 0);
        texture = texture1;
        speed = 0.5f;
        state = state1;

        if (state == "Menu") {
            index = MenuState.k;
        }
        else if (state == "Begin"){
            index = BeginState.k;
        }
        else if (state == "Settings"){
            index = SettingsState.k;
        }
        else if (state == "Cust"){
            index = CustomizationState.k;
        }
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getBirdMenu() {
        return MenuState.birdAnimations.get(index).getFrame();
    }

    public TextureRegion getBirdBegin() {
        return BeginState.birdAnimations.get(index).getFrame();
    }

    public TextureRegion getBirdSettings() {
        return SettingsState.birdAnimations.get(index).getFrame();
    }

    public TextureRegion getBirdCustomization() {
        return CustomizationState.birdAnimations.get(index).getFrame();
    }

    public void update(float dt){
        if (state == "Menu") {
            MenuState.birdAnimations.get(index).update(dt);
        }
        else if (state == "Begin"){
            BeginState.birdAnimations.get(index).update(dt);
        }
        else if (state == "Settings"){
            SettingsState.birdAnimations.get(index).update(dt);
        }
        else if (state == "Cust"){
            CustomizationState.birdAnimations.get(index).update(dt);
        }
        position.x -= speed;
        position.add(0, 0 , 0);
    }

    public void dispose(){
        texture.dispose();
    }
}
