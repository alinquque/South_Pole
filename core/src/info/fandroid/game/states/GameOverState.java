package info.fandroid.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import info.fandroid.game.SouthPole;
import info.fandroid.game.sprites.Buttons;

import static info.fandroid.game.SouthPole.touchPos;

public class GameOverState extends State implements InputProcessor {

    private Texture background;
    private Texture gameover;
    private Texture totalScore;
    private Texture highScore;
    private Texture wow;
    private Texture bigFish;
    public int wowFlag = 0;
    public char totalFishes[];

    private Sound click;
    private Sound bestscore;

    private Rectangle boundsrefresh;

    private Buttons home;
    private Buttons refresh;

    private Float wowTime;
    private Float currentWowTime;
    private int wowCount;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background_GO.png");
        gameover = new Texture("gameover.png");
        totalScore = new Texture("total.png");
        highScore = new Texture("high.png");
        wow = new Texture("wow.png");
        bigFish = new Texture("big_fish.png");

        wowTime = 3.11f;
        currentWowTime = 0.0f;
        wowCount = 0;

        home = new Buttons();
        refresh = new Buttons();

        Gdx.input.setInputProcessor(this);

        click = Gdx.audio.newSound(Gdx.files.internal("click.wav"));
        bestscore = Gdx.audio.newSound(Gdx.files.internal("best_score.wav"));
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        //home.update(dt);
        //refresh.update(dt);
        currentWowTime += dt;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, SouthPole.WIDTH, SouthPole.HEIGHT);
        sb.draw(gameover, 89, 138);
        sb.draw(totalScore, 52, 94);
        sb.draw(highScore, 52, 70);

        if (PlayState.eatenFishes == SouthPole.prefs.getInteger("highScore", 0) && PlayState.recordIsReached == true){
            wowFlag = 1;
            if (currentWowTime >= wowTime) {
                sb.draw(wow, 258, 94);
                sb.draw(wow, 258, 70);
                if (wowCount == 0) {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        bestscore.play();
                    }
                    wowCount = 1;
                }
            }
        }

        sb.draw(Buttons.home, home.getPositionhome().x, home.getPositionhome().y);
        sb.draw(Buttons.refresh, refresh.getPositionrefresh().x, refresh.getPositionrefresh().y);

        for(int i = PlayState.arrHighScore.length - 1; i >= 0; i--){
            switch (PlayState.arrHighScore[i]){
                case('0'):
                    sb.draw(PlayState.zero, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('1'):
                    sb.draw(PlayState.one, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('2'):
                    sb.draw(PlayState.two, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('3'):
                    sb.draw(PlayState.three, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('4'):
                    sb.draw(PlayState.four, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('5'):
                    sb.draw(PlayState.five, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('6'):
                    sb.draw(PlayState.six, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('7'):
                    sb.draw(PlayState.seven, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('8'):
                    sb.draw(PlayState.eight, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
                case('9'):
                    sb.draw(PlayState.nine, 258 - wowFlag*16 - (PlayState.arrHighScore.length - i - 1)*16, 70);
                    break;
            }

        }

        for(int i = PlayState.arrEatenFishes.length - 1; i >= 0; i--){
            switch (PlayState.arrEatenFishes[i]){
                case('0'):
                    sb.draw(PlayState.zero, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('1'):
                    sb.draw(PlayState.one, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('2'):
                    sb.draw(PlayState.two, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('3'):
                    sb.draw(PlayState.three, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('4'):
                    sb.draw(PlayState.four, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('5'):
                    sb.draw(PlayState.five, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('6'):
                    sb.draw(PlayState.six, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('7'):
                    sb.draw(PlayState.seven, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('8'):
                    sb.draw(PlayState.eight, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
                case('9'):
                    sb.draw(PlayState.nine, 258 - wowFlag*16 - (PlayState.arrEatenFishes.length - i - 1)*16, 94);
                    break;
            }
        }

        totalFishes = String.valueOf(SouthPole.prefs.getInteger("Fishes")).toCharArray();

        int fishAndCountX = 160 - (totalFishes.length + 1) * 8 + 1;

        sb.draw(bigFish, fishAndCountX, 18);

        for (int i = 0; i < totalFishes.length; i++){
            switch(totalFishes[i]){
                case('0'):
                    sb.draw(PlayState.zero, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('1'):
                    sb.draw(PlayState.one, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('2'):
                    sb.draw(PlayState.two, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('3'):
                    sb.draw(PlayState.three, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('4'):
                    sb.draw(PlayState.four, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('5'):
                    sb.draw(PlayState.five, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('6'):
                    sb.draw(PlayState.six, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('7'):
                    sb.draw(PlayState.seven, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('8'):
                    sb.draw(PlayState.eight, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
                case('9'):
                    sb.draw(PlayState.nine, fishAndCountX + 1 + 16 * (i+1), 18);
                    break;
            }

        }

        wowFlag = 0;

        sb.end();
    }

    public boolean collides (Rectangle player){
        return player.overlaps(boundsrefresh);
    }

    @Override
    public void dispose() {
        background.dispose();
        gameover.dispose();
        bestscore.dispose();
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (touchPos.x >= Buttons.boundsrefresh.x && touchPos.x <= Buttons.boundsrefresh.x + Buttons.refresh.getWidth() && touchPos.y >= Buttons.boundsrefresh.y && touchPos.y <= Buttons.boundsrefresh.y + Buttons.refresh.getHeight()){

            if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                click.play(1.0f);
            }
            PlayState.gameover.stop();

            gsm.set(new PlayState(gsm));
            PlayState.touch_count++;
        }

        if (touchPos.x >= Buttons.boundshome.x && touchPos.x <= Buttons.boundshome.x + Buttons.home.getWidth() && touchPos.y >= Buttons.boundshome.y && touchPos.y <= Buttons.boundshome.y + Buttons.home.getHeight()){
            if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                click.play(1.0f);
            }
            PlayState.gameover.stop();
            SouthPole.music_begin.play();

            gsm.set(new MenuState(gsm));
        }

        return false;
    }
}
