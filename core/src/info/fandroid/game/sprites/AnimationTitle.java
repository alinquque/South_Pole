package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import info.fandroid.game.states.BeginState;

public class AnimationTitle {
    private TextureRegion[] frames;
    private float maxFrameTime;
    private float currentFrameTime;
    public int current_frame;
    private TextureRegion[] current_frames;
    private int frameRow;
    private int frameCol;
    public int rowIndex;

    public AnimationTitle(TextureRegion region, Texture texture, float cycleTime) {
        frameRow = 1;
        frameCol = 10;
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/frameCol, texture.getHeight()/frameRow);
        frames = new TextureRegion[frameCol * frameRow];
        current_frames = new TextureRegion[frameCol];

        for (int i = 0; i < frameCol; i++) {
            current_frames[i] = tmp[rowIndex][i];
        }

        current_frame = 0;
        maxFrameTime = cycleTime / frameCol;

    }

    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {

            currentFrameTime = 0;
            if (current_frame == 9){
                BeginState.titleAnimationIsChanged();
                current_frame = -1;
            }
            current_frame++;
        }

    }
    public TextureRegion getFrame(){
        return current_frames[current_frame];
    }
}
