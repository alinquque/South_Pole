package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import info.fandroid.game.states.PlayState;

public class AnimationPinguin {
    private TextureRegion[] frames;
    private float maxFrameTime;
    private float currentFrameTime;
    public int current_frame;
    private TextureRegion[] current_frames;
    private int frameRow;
    private int frameCol;
    private int rowIndex;

    public AnimationPinguin(TextureRegion region, float cycleTime){
        frameRow = 4;
        frameCol = 3;
        rowIndex = 0;
        TextureRegion[][] tmp = TextureRegion.split(PlayState.pinguin.texture, PlayState.pinguin.texture.getWidth()/frameCol, PlayState.pinguin.texture.getHeight()/frameRow);
        frames = new TextureRegion[frameCol * frameRow];
        current_frames = new TextureRegion[frameCol];

        //1 ряд - fall, крылья вверх
        //2 ряд - jump, крылья вниз
        //3 ряд - удерживание touchDown
        //4 ряд - default
        if (PlayState.pinguin.act == ""){
            rowIndex = 3;
            PlayState.pinguin.old_act = "";
        }
        else if (PlayState.pinguin.act == "touchDown"){
            rowIndex = 2;
            PlayState.pinguin.old_act = "touchDown";
        }
        else if (PlayState.pinguin.act == "jump"){
            rowIndex = 1;
            PlayState.pinguin.old_act = "jump";
        }
        else if (PlayState.pinguin.act == "fall"){
            rowIndex = 0;
            PlayState.pinguin.old_act = "fall";
        }

        for (int i = 0; i < frameCol; i++) {
            current_frames[i] = tmp[rowIndex][i];
        }

        current_frame = 0;
        maxFrameTime = cycleTime / frameCol;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime){
            if (PlayState.pinguin.act == "" || PlayState.pinguin.act == "touchDown") {
                currentFrameTime = 0;
                if (current_frame == 2){
                    current_frame = -1;
                }
                current_frame++;
            }
            else if (PlayState.pinguin.act == "jump"){
                if (current_frame < 2){
                    current_frame++;
                }
                else if (current_frame == 2){
                    PlayState.pinguin.old_act = "jump";
                    PlayState.fall();
                }
                currentFrameTime = 0;
            }
            else if (PlayState.pinguin.act == "fall"){
                if (current_frame < 2){
                    current_frame++;
                }
                else if (current_frame == 2){
                    PlayState.pinguin.old_act = "fall";
                    PlayState.actIsEmpty();
                }
                currentFrameTime = 0;
            }
        }

    }

    public TextureRegion getFrame(){
        return current_frames[current_frame];
    }
}