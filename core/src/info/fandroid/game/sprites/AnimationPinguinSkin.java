package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationPinguinSkin {
    private TextureRegion[] frames;
    private float maxFrameTime;
    private float currentFrameTime;
    public int current_frame;
    private TextureRegion[] current_frames;
    private int frameRow;
    private int frameCol;


    public AnimationPinguinSkin(TextureRegion region, Texture texture, float cycleTime) {
        frameRow = 1;
        frameCol = 6;
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/frameCol, texture.getHeight()/frameRow);
        frames = new TextureRegion[frameCol * frameRow];
        current_frames = new TextureRegion[frameCol];

        for (int i = 0; i < frameCol; i++) {
            current_frames[i] = tmp[0][i];
        }
        maxFrameTime = cycleTime / frameCol;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {

            currentFrameTime = 0;
            if (current_frame == 5){
                current_frame = -1;
            }
            current_frame++;
        }

    }
    public TextureRegion getFrame(){
        return current_frames[current_frame];
    }

}
