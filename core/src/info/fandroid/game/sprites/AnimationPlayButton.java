package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import info.fandroid.game.states.MenuState;
import info.fandroid.game.states.PlayState;

public class AnimationPlayButton {
    private TextureRegion[] frames;
    private float maxFrameTime;
    private float currentFrameTime;
    public int current_frame;
    private TextureRegion[] current_frames;
    private int frameRow;
    private int frameCol;
    private String state;


    public AnimationPlayButton(TextureRegion region, Texture texture, float cycleTime, String state1) {
        frameRow = 1;
        frameCol = 6;
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/frameCol, texture.getHeight()/frameRow);
        frames = new TextureRegion[frameCol * frameRow];
        current_frames = new TextureRegion[frameCol];

        for (int i = 0; i < frameCol; i++) {
            current_frames[i] = tmp[0][i];
        }
        maxFrameTime = cycleTime / frameCol;

        state = state1;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {

            currentFrameTime = 0;
            if (current_frame == 5){
                if (state == "Menu") {
                    MenuState.playButtonAnimationIsChanged();
                }
                else if (state == "Play"){
                    PlayState.playButtonAnimationIsChanged();
                }
                current_frame = -1;
            }
            current_frame++;
        }

    }
    public TextureRegion getFrame(){
        return current_frames[current_frame];
    }

}
