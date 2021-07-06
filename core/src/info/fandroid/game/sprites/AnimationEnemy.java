package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import info.fandroid.game.states.PlayState;

public class AnimationEnemy {
    private TextureRegion[] frames;
    private float maxFrameTime;
    private float currentFrameTime;
    public int current_frame;
    private TextureRegion[] current_frames;
    private int frameRow;
    private int frameCol;
    public int rowIndex;
    public int index;

    public AnimationEnemy(TextureRegion region, Texture texture, float cycleTime, int current_frame1, int k, int rowIndex1) {
        rowIndex = rowIndex1;
        frameRow = 2;
        frameCol = 5;
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/frameCol, texture.getHeight()/frameRow);
        frames = new TextureRegion[frameCol * frameRow];
        current_frames = new TextureRegion[frameCol];
        //1 ряд - крылья вверх
        //2 ряд - крылья вниз

        for (int i = 0; i < frameCol; i++) {
            current_frames[i] = tmp[rowIndex][i];
        }

        current_frame = current_frame1;
        maxFrameTime = cycleTime / frameCol;

        index = k;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {

            currentFrameTime = 0;
            if (current_frame == 4){
                PlayState.enemyAnimationIsChanged(index, rowIndex);
                current_frame = -1;
            }
            current_frame++;
        }

    }
    public TextureRegion getFrame(){
        return current_frames[current_frame];
    }

}
