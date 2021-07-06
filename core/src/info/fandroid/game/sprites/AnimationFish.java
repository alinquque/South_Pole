package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import info.fandroid.game.states.PlayState;

public class AnimationFish {
    private TextureRegion[] frames;
    private float maxFrameTime;
    private float currentFrameTime;
    public int current_frame;
    private TextureRegion[] current_frames;
    private int frameRow;
    private int frameCol;
    public static int rowIndex = 0;

    public AnimationFish(TextureRegion region, float cycleTime) {
        frameRow = 1;
        frameCol = 5;
        TextureRegion[][] tmp = TextureRegion.split(Fish.texture, Fish.texture.getWidth()/frameCol, Fish.texture.getHeight()/frameRow);
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
            for (int i = 0; i < PlayState.fishes.size(); i++) {
                if (PlayState.fishes.get(i).getPosition().y < 50) {
                    if (PlayState.fishes.get(i).direction == true) {
                        if (current_frame == 0) {
                            current_frame = 1;
                        } else if (current_frame == 1) {
                            current_frame = 0;
                        }
                    } else {
                        if (current_frame == 2){
                            current_frame = 3;

                        }
                        else if (current_frame == 3) {
                            current_frame = 4;
                        }
                        else if (current_frame == 4) {
                            current_frame = 3;
                        }
                    }
                } else if (PlayState.fishes.get(i).getPosition().y > 50) {
                    current_frame = 2;
                    PlayState.fishes.get(0).direction = false;
                }
            }

        }

    }
    public TextureRegion getFrame(){
        return current_frames[current_frame];
    }
}
