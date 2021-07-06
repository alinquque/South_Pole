package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import info.fandroid.game.states.PlayState;

public class AnimationBottle {
    private TextureRegion[] frames;
    private float maxFrameTime;
    private float currentFrameTime;
    public int current_frame;
    private TextureRegion[] current_frames;
    private int frameRow;
    private int frameCol;
    public static int rowIndex = 0;

    public AnimationBottle(TextureRegion region, float cycleTime) {
        frameRow = 1;
        frameCol = 6;
        TextureRegion[][] tmp = TextureRegion.split(Bottle.texture, Bottle.texture.getWidth()/frameCol, Bottle.texture.getHeight()/frameRow);
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
            if (PlayState.bottles.get(0).getPosition().y < 50) {
                if (current_frame == 5) {
                    current_frame = 0;
                } else {
                    current_frame++;
                }
            }
            else if (PlayState.bottles.get(0).getPosition().y > 50) {
                if (current_frame == 5) {
                    current_frame = 0;
                } else {
                    current_frame++;
                }
                PlayState.bottles.get(0).direction = false;
            }
        }

    }
    public TextureRegion getFrame(){
        return current_frames[current_frame];
    }
}
