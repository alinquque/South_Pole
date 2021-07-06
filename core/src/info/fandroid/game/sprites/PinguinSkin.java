package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.states.CustomizationState;

public class PinguinSkin {
    private Vector3 position;


    public static Texture texture;


    public PinguinSkin(int x, int y, Texture texture1){
        position = new Vector3(x, y, 0);
        texture = texture1;
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getPinguinSkin_pinguin() {
        return CustomizationState.pinguinAnimation.getFrame();
    }

    public TextureRegion getPinguinSkin_orange() {
        return CustomizationState.orangeAnimation.getFrame();
    }

    public TextureRegion getPinguinSkin_baby() {
        return CustomizationState.babyAnimation.getFrame();
    }

    public TextureRegion getPinguinSkin_cock() {
        return CustomizationState.cockAnimation.getFrame();
    }

    public TextureRegion getPinguinSkin_superping() {
        return CustomizationState.superpingAnimation.getFrame();
    }

    public TextureRegion getPinguinSkin_hohlatiy() {
        return CustomizationState.hohlatiyAnimation.getFrame();
    }

    public void update(float dt){

        if (CustomizationState.checkSkin.equals("pinguin")){
            CustomizationState.pinguinAnimation.update(dt);
        }
        else if (CustomizationState.checkSkin.equals("orange")){
            CustomizationState.orangeAnimation.update(dt);
        }
        else if (CustomizationState.checkSkin.equals("baby")){
            CustomizationState.babyAnimation.update(dt);
        }
        else if (CustomizationState.checkSkin.equals("cock")){
            CustomizationState.cockAnimation.update(dt);
        }
        else if (CustomizationState.checkSkin.equals("superping")){
            CustomizationState.superpingAnimation.update(dt);
        }
        else if (CustomizationState.checkSkin.equals("hohlatiy")){
            CustomizationState.hohlatiyAnimation.update(dt);
        }


        position.add(0, 0 , 0);
    }

    public void dispose(){
        texture.dispose();
    }
}
