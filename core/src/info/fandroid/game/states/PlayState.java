package info.fandroid.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Random;

import info.fandroid.game.SouthPole;
import info.fandroid.game.sprites.AnimationPinguin;
import info.fandroid.game.sprites.AnimationEnemy;
import info.fandroid.game.sprites.AnimationPlayButton;
import info.fandroid.game.sprites.Background;
import info.fandroid.game.sprites.Bottle;
import info.fandroid.game.sprites.Enemy;
import info.fandroid.game.sprites.Fish;
import info.fandroid.game.sprites.Pinguin;
import info.fandroid.game.sprites.PlayButton;

import static info.fandroid.game.SouthPole.touchPos;

public class PlayState extends State implements InputProcessor{

    private Background bg1;
    private Background bg1_1;
    private Background bg1_n;
    private Background bg1_1_n;
    private Background bg1_d;
    private Background bg1_1_d;
    private Background bg1_p;
    private Background bg1_1_p;
    private Background bg2;
    private Background bg2_1;
    private Background bg3;
    private Background bg3_1;
    private Background bg3_n;
    private Background bg3_1_n;
    private Background bg3_d;
    private Background bg3_1_d;
    private Background bg3_p;
    private Background bg3_1_p;
    private Background bg4;
    private Background bg4_1;
    private Background bg5;
    private Background bg5_1;
    private Background bg6;
    private Background bg6_1;
    private Background bg6_n;
    private Background bg6_1_n;
    private Background bg6_d;
    private Background bg6_1_d;
    private Background bg6_p;
    private Background bg6_1_p;
    private Background bg_snow_1;
    private Background bg_snow_1_1;
    private Background bg_snow_1_y;
    private Background bg_snow_1_1_y;
    private Background bg_snow_2;
    private Background bg_snow_2_1;
    private Background bg_snow_2_y;
    private Background bg_snow_2_1_y;

    public static Pinguin pinguin;
    public static AnimationPinguin pinguinAnimation;
    private Texture bg;
    private Texture bg_n;
    private Texture bg_d;
    private Texture bg_p;
    private Texture tutorialBg;

    public static long touch_count;

    private Sound fish;
    public static Sound gameover;
    private Sound click;
    public static Sound fly;
    public static Music music_play;

    public static ArrayList<Bottle> bottles;
    public Bottle bottle;

    public static AnimationEnemy enemyAnimation;

    public static Texture texture;

    Random random = new Random();

    public int back;
    public int y1;
    public int x1;
    public int x2 = 50;

    public int t = 0;

    public int frameEnemy;
    public int rowIndexEnemy;
    public static int k;
    public int k1 = 0;

    public static float boost = 0.0f;

    public static boolean fishWasEaten = false;
    public static int fishTimeCount = 0;

    public static int eatenFishes = 0;
    public static char[] arrEatenFishes;
    public static char[] arrHighScore;
    public int[] scoreX;
    public int scoreY = 170;
    public static Texture zero;
    public static Texture one;
    public static Texture two;
    public static Texture three;
    public static Texture four;
    public static Texture five;
    public static Texture six;
    public static Texture seven;
    public static Texture eight;
    public static Texture nine;

    public static Texture pause;
    public static Texture score;
    public static Texture blur;

    public static String GAME_RUNNING = "RUN";
    public static String GAME_PAUSED = "PAUSE";

    public static String gamestatus;

    public static ArrayList<Enemy> enemies;

    public static ArrayList<AnimationEnemy> enemyAnimations;

    public static ArrayList<Fish> fishes;

    public static PlayButton playButton;
    public static AnimationPlayButton playButtonAnimation;

    public boolean tutorial = false;
    public int tutorialCount = 0;

    public static boolean recordIsReached;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        recordIsReached = false;

        music_play = Gdx.audio.newMusic(Gdx.files.internal("South Pole.wav"));
        music_play.setLooping(true);
        music_play.setVolume(0.6f);
        if (SouthPole.prefs.getString("checkmusic").equals("on")){
            music_play.play();
        }

        fish = Gdx.audio.newSound(Gdx.files.internal("fish.wav"));
        gameover = Gdx.audio.newSound(Gdx.files.internal("game_over.wav"));
        click = Gdx.audio.newSound(Gdx.files.internal("click.wav"));
        fly = Gdx.audio.newSound(Gdx.files.internal("fly.wav"));

        playButton = null;
        playButtonAnimation = null;

        gamestatus = GAME_RUNNING;

        touch_count = 0;

        texture = new Texture("enemy1.png");

        score = new Texture("score.png");

        pinguin = new Pinguin(50, 100);
        pinguinAnimation = new AnimationPinguin(new TextureRegion(pinguin.texture), 0.5f);

        pinguin.act = "";

        back = random.nextInt(4);

        fishes = new ArrayList<Fish>();

        bottles = new ArrayList<Bottle>();

        enemies = new ArrayList<Enemy>();
        enemyAnimations = new ArrayList<>();
        k = 0;

        arrHighScore = String.valueOf(SouthPole.prefs.getInteger("highScore", 0)).toCharArray();

        eatenFishes = 0;

        bg = new Texture("background.png");
        bg_n = new Texture("background_n.png");
        bg_d = new Texture("background_d.png");
        bg_p = new Texture("background_p.png");
        tutorialBg = new Texture("tutorial.png");

        pause = new Texture("pause.png");

        blur = new Texture("blur.png");

        if (back == 0) {
            bg1 = new Background(0, 0);
            bg1_1 = new Background(320, 0);
            bg2 = new Background(0, 0);
            bg2_1 = new Background(320, 0);
            bg3 = new Background(0, 0);
            bg3_1 = new Background(320, 0);
            bg4 = new Background(0, 0);
            bg4_1 = new Background(320, 0);
            bg5 = new Background(0, 0);
            bg5_1 = new Background(320, 0);
            bg6 = new Background(0, 0);
            bg6_1 = new Background(320, 0);
        }
        else if (back == 1) {
            bg1_n = new Background(0, 0);
            bg1_1_n = new Background(320, 0);
            bg2 = new Background(0, 0);
            bg2_1 = new Background(320, 0);
            bg3_n = new Background(0, 0);
            bg3_1_n = new Background(320, 0);
            bg4 = new Background(0, 0);
            bg4_1 = new Background(320, 0);
            bg5 = new Background(0, 0);
            bg5_1 = new Background(320, 0);
            bg6_n = new Background(0, 0);
            bg6_1_n = new Background(320, 0);
        }

        else if (back == 2) {
            bg1_d = new Background(0, 0);
            bg1_1_d = new Background(320, 0);
            bg2 = new Background(0, 0);
            bg2_1 = new Background(320, 0);
            bg3_d = new Background(0, 0);
            bg3_1_d = new Background(320, 0);
            bg4 = new Background(0, 0);
            bg4_1 = new Background(320, 0);
            bg5 = new Background(0, 0);
            bg5_1 = new Background(320, 0);
            bg6_d = new Background(0, 0);
            bg6_1_d = new Background(320, 0);
        }

        else if (back == 3) {
            bg1_p = new Background(0, 0);
            bg1_1_p = new Background(320, 0);
            bg2 = new Background(0, 0);
            bg2_1 = new Background(320, 0);
            bg3_p = new Background(0, 0);
            bg3_1_p = new Background(320, 0);
            bg4 = new Background(0, 0);
            bg4_1 = new Background(320, 0);
            bg5 = new Background(0, 0);
            bg5_1 = new Background(320, 0);
            bg6_p = new Background(0, 0);
            bg6_1_p = new Background(320, 0);
            bg_snow_1 = new Background(0, 0);
            bg_snow_1_1 = new Background(320, 0);
            bg_snow_1_y = new Background(0, 200);
            bg_snow_1_1_y = new Background(320, 200);
            bg_snow_2 = new Background(0, 0);
            bg_snow_2_1 = new Background(320, 0);
            bg_snow_2_y = new Background(0, 200);
            bg_snow_2_1_y = new Background(320, 200);
        }

        zero = new Texture("zero.png");
        one = new Texture("one.png");
        two = new Texture("two.png");
        three = new Texture("three.png");
        four = new Texture("four.png");
        five = new Texture("five.png");
        six = new Texture("six.png");
        seven = new Texture("seven.png");
        eight = new Texture("eight.png");
        nine = new Texture("nine.png");

        Gdx.input.setInputProcessor(this);

        arrEatenFishes = String.valueOf(eatenFishes).toCharArray();
        scoreX = new int[arrEatenFishes.length];
        for(int i = 0; i < scoreX.length; i++){
            scoreX[i] = 290 - i*16;
        }
        enemies.clear();
        enemyAnimations.clear();
    }

    @Override
    protected void handleInput() {
    }


    @Override
    public void update(float dt) {
        if (gamestatus == GAME_RUNNING && tutorial == false) {
            y1 = random.nextInt(165) + 10;

            frameEnemy = random.nextInt(5);
            rowIndexEnemy = random.nextInt(2);

            if (enemies.isEmpty()) {
                enemyAnimation = new AnimationEnemy(new TextureRegion(texture), texture, 0.5f, frameEnemy, k, rowIndexEnemy);
                enemyAnimations.add(enemyAnimation);
                Enemy enemy = new Enemy(340, y1, texture);
                enemies.add(enemy);
                k++;
            } else {
                if (320 - enemies.get(k - 1).getPosition().x >= x2) {
                    enemyAnimation = new AnimationEnemy(new TextureRegion(texture), texture, 0.5f, frameEnemy, k, rowIndexEnemy);
                    enemyAnimations.add(enemyAnimation);
                    Enemy enemy = new Enemy(340, y1, texture);
                    enemies.add(enemy);
                    k++;
                    x2 = random.nextInt(100) + 50;
                }
                if (enemies.get(0).getPosition().x < -16.0f) {
                    enemies.remove(0);
                    enemyAnimations.remove(0);
                    k--;
                    for (int i = 0; i < enemies.size(); i++) {
                        enemies.get(i).index -= 1;
                        enemyAnimations.get(i).index -= 1;
                    }
                }
            }


            x1 = random.nextInt(50 + 50 * Math.round(boost)) + 150 + 50 * Math.round(boost);

            if (fishes.isEmpty()) {
                if (fishWasEaten == true) {
                    if (fishTimeCount < 150)
                        fishTimeCount++;
                    else {
                        fishWasEaten = false;
                        fishTimeCount = 0;
                    }
                } else if (bottles.isEmpty()) {
                    if (t != 2) {
                        Fish fish = new Fish(x1, -20);
                        fish.direction = true;
                        fishes.add(fish);
                        k1++;
                        t = random.nextInt(3);
                    } else if (t == 2) {
                        bottle = new Bottle(x1, -20);
                        bottle.direction = true;
                        bottles.add(bottle);
                        t = random.nextInt(3);
                    }
                }
            } else {
                if (fishes.get(k1 - 1).getPosition().y < -20) {
                    fishes.remove(0);
                    k1--;
                    t = random.nextInt(3);

                }
            }


            if (back == 0) {
                bg6.update();
                bg6_1.update();
                bg1.update();
                bg1_1.update();
                bg3.update();
                bg3_1.update();
                bg2.update();
                bg2_1.update();
                bg4.update();
                bg4_1.update();
                bg5.update();
                bg5_1.update();
            } else if (back == 1) {
                bg6_n.update();
                bg6_1_n.update();
                bg1_n.update();
                bg1_1_n.update();
                bg3_n.update();
                bg3_1_n.update();
                bg2.update();
                bg2_1.update();
                bg4.update();
                bg4_1.update();
                bg5.update();
                bg5_1.update();
            } else if (back == 2) {
                bg6_d.update();
                bg6_1_d.update();
                bg1_d.update();
                bg1_1_d.update();
                bg3_d.update();
                bg3_1_d.update();
                bg2.update();
                bg2_1.update();
                bg4.update();
                bg4_1.update();
                bg5.update();
                bg5_1.update();
            } else if (back == 3) {
                bg6_p.update();
                bg6_1_p.update();
                bg1_p.update();
                bg1_1_p.update();
                bg3_p.update();
                bg3_1_p.update();
                bg2.update();
                bg2_1.update();
                bg4.update();
                bg4_1.update();
                bg5.update();
                bg5_1.update();
                bg_snow_1.update();
                bg_snow_1_1.update();
                bg_snow_1_y.update();
                bg_snow_1_1_y.update();
            }

            pinguin.update(dt);

            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).update(dt);

                if (enemies.get(i).collides(pinguin.getBounds()) || (pinguin.collides == true)) {
                    boost = 0.0f;
                    gsm.set(new GameOverState(gsm));
                    music_play.stop();
                    if (SouthPole.prefs.getString("checkmusic").equals("on")) {
                        gameover.play(0.6f);
                    }
                }
            }


            if (!bottles.isEmpty() && bottles.get(0).collides(pinguin.getBounds())) {
                boost = 0.0f;
                gsm.set(new GameOverState(gsm));
                bottles.remove(0);
                music_play.stop();
                if (SouthPole.prefs.getString("checkmusic").equals("on")) {
                    gameover.play(0.6f);
                }
            }

            if (!bottles.isEmpty()) {
                bottles.get(0).update(dt);
            }

            for (int i = 0; i < fishes.size(); i++) {
                fishes.get(i).update(dt);

                if (fishes.get(i).collides(pinguin.getBounds())) {

                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        fish.play(1.0f);
                    }

                    boost += 0.0625f;

                    fishWasEaten = true;
                    fishTimeCount++;

                    eatenFishes++;

                    if (SouthPole.prefs.getInteger("Fishes", 0) != 0) {
                        SouthPole.prefs.putInteger("Fishes", SouthPole.prefs.getInteger("Fishes") + 1);
                        SouthPole.prefs.flush();
                    } else {
                        SouthPole.prefs.putInteger("Fishes", eatenFishes);
                        SouthPole.prefs.flush();
                    }

                    if (SouthPole.prefs.getInteger("highScore", 0) != 0) {
                        if (SouthPole.prefs.getInteger("highScore") < eatenFishes) {
                            SouthPole.prefs.putInteger("highScore", eatenFishes);
                            SouthPole.prefs.flush();
                            recordIsReached = true;
                            arrHighScore = null;
                            arrHighScore = String.valueOf(SouthPole.prefs.getInteger("highScore", 0)).toCharArray();
                        }
                    } else {
                        SouthPole.prefs.putInteger("highScore", eatenFishes);
                        SouthPole.prefs.flush();
                        recordIsReached = true;
                        arrHighScore = null;
                        arrHighScore = String.valueOf(SouthPole.prefs.getInteger("highScore", 0)).toCharArray();
                    }

                    arrEatenFishes = null;
                    arrEatenFishes = String.valueOf(eatenFishes).toCharArray();
                    scoreX = new int[arrEatenFishes.length];
                    for (int j = 0; j < scoreX.length; j++) {
                        scoreX[j] = 293 - j * 16;
                    }
                    fishes.remove(i);
                    k1--;
                }
            }

            if (!bottles.isEmpty() && bottles.get(0).direction == false && bottles.get(0).getPosition().y == -100) {
                bottles.remove(0);
                Fish fish = new Fish(x1, -20);
                fish.direction = true;
                fishes.add(fish);
                k1++;
            } else if (back == 3) {
                bg_snow_2.update();
                bg_snow_2_1.update();
                bg_snow_2_y.update();
                bg_snow_2_1_y.update();
            }
        }
        else if (gamestatus == GAME_PAUSED){
            if (playButton == null) {
                playButton = new PlayButton((SouthPole.WIDTH / 2) - 16, (SouthPole.HEIGHT / 2) - 16, new Texture("play.png"), "Play");
                playButtonAnimation = new AnimationPlayButton(new TextureRegion(playButton.texture), playButton.texture, 4.0f, "Play");
            }
            playButton.update(dt);
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        if (back == 0) {
            sb.draw(bg, 0, 0);
            sb.draw(bg6.getBg6(), bg6.getPosition_bg6().x, bg6.getPosition_bg6().y);
            sb.draw(bg6_1.getBg6_1(), bg6_1.getPosition_bg6_1().x, bg6_1.getPosition_bg6_1().y);
            sb.draw(bg1.getBg1(), bg1.getPosition_bg1().x, bg1.getPosition_bg1().y);
            sb.draw(bg1_1.getBg1_1(), bg1_1.getPosition_bg1_1().x, bg1_1.getPosition_bg1_1().y);
            sb.draw(bg3.getBg3(), bg3.getPosition_bg3().x, bg3.getPosition_bg3().y);
            sb.draw(bg3_1.getBg3_1(), bg3_1.getPosition_bg3_1().x, bg3_1.getPosition_bg3_1().y);
            sb.draw(bg2.getBg2(), bg2.getPosition_bg2().x, bg2.getPosition_bg2().y);
            sb.draw(bg2_1.getBg2_1(), bg2_1.getPosition_bg2_1().x, bg2_1.getPosition_bg2_1().y);
            sb.draw(bg4.getBg4(), bg4.getPosition_bg4().x, bg4.getPosition_bg4().y);
            sb.draw(bg4_1.getBg4_1(), bg4_1.getPosition_bg4_1().x, bg4_1.getPosition_bg4_1().y);
            sb.draw(bg5.getBg5(), bg5.getPosition_bg5().x, bg5.getPosition_bg5().y);
            sb.draw(bg5_1.getBg5_1(), bg5_1.getPosition_bg5_1().x, bg5_1.getPosition_bg5_1().y);
        }
        if (back == 1) {
            sb.draw(bg_n, 0, 0);
            sb.draw(bg6_n.getBg6_n(), bg6_n.getPosition_bg6_n().x, bg6_n.getPosition_bg6_n().y);
            sb.draw(bg6_1_n.getBg6_1_n(), bg6_1_n.getPosition_bg6_1_n().x, bg6_1_n.getPosition_bg6_1_n().y);
            sb.draw(bg1_n.getBg1_n(), bg1_n.getPosition_bg1_n().x, bg1_n.getPosition_bg1_n().y);
            sb.draw(bg1_1_n.getBg1_1_n(), bg1_1_n.getPosition_bg1_1_n().x, bg1_1_n.getPosition_bg1_1_n().y);
            sb.draw(bg3_n.getBg3_n(), bg3_n.getPosition_bg3_n().x, bg3_n.getPosition_bg3_n().y);
            sb.draw(bg3_1_n.getBg3_1_n(), bg3_1_n.getPosition_bg3_1_n().x, bg3_1_n.getPosition_bg3_1_n().y);
            sb.draw(bg2.getBg2(), bg2.getPosition_bg2().x, bg2.getPosition_bg2().y);
            sb.draw(bg2_1.getBg2_1(), bg2_1.getPosition_bg2_1().x, bg2_1.getPosition_bg2_1().y);
            sb.draw(bg4.getBg4(), bg4.getPosition_bg4().x, bg4.getPosition_bg4().y);
            sb.draw(bg4_1.getBg4_1(), bg4_1.getPosition_bg4_1().x, bg4_1.getPosition_bg4_1().y);
            sb.draw(bg5.getBg5(), bg5.getPosition_bg5().x, bg5.getPosition_bg5().y);
            sb.draw(bg5_1.getBg5_1(), bg5_1.getPosition_bg5_1().x, bg5_1.getPosition_bg5_1().y);
        }
        if (back == 2) {
            sb.draw(bg_d, 0, 0);
            sb.draw(bg6_d.getBg6_d(), bg6_d.getPosition_bg6_d().x, bg6_d.getPosition_bg6_d().y);
            sb.draw(bg6_1_d.getBg6_1_d(), bg6_1_d.getPosition_bg6_1_d().x, bg6_1_d.getPosition_bg6_1_d().y);
            sb.draw(bg1_d.getBg1_d(), bg1_d.getPosition_bg1_d().x, bg1_d.getPosition_bg1_d().y);
            sb.draw(bg1_1_d.getBg1_1_d(), bg1_1_d.getPosition_bg1_1_d().x, bg1_1_d.getPosition_bg1_1_d().y);
            sb.draw(bg3_d.getBg3_d(), bg3_d.getPosition_bg3_d().x, bg3_d.getPosition_bg3_d().y);
            sb.draw(bg3_1_d.getBg3_1_d(), bg3_1_d.getPosition_bg3_1_d().x, bg3_1_d.getPosition_bg3_1_d().y);
            sb.draw(bg2.getBg2(), bg2.getPosition_bg2().x, bg2.getPosition_bg2().y);
            sb.draw(bg2_1.getBg2_1(), bg2_1.getPosition_bg2_1().x, bg2_1.getPosition_bg2_1().y);
            sb.draw(bg4.getBg4(), bg4.getPosition_bg4().x, bg4.getPosition_bg4().y);
            sb.draw(bg4_1.getBg4_1(), bg4_1.getPosition_bg4_1().x, bg4_1.getPosition_bg4_1().y);
            sb.draw(bg5.getBg5(), bg5.getPosition_bg5().x, bg5.getPosition_bg5().y);
            sb.draw(bg5_1.getBg5_1(), bg5_1.getPosition_bg5_1().x, bg5_1.getPosition_bg5_1().y);
        }
        if (back == 3) {
            sb.draw(bg_p, 0, 0);
            sb.draw(bg6_p.getBg6_p(), bg6_p.getPosition_bg6_p().x, bg6_p.getPosition_bg6_p().y);
            sb.draw(bg6_1_p.getBg6_1_p(), bg6_1_p.getPosition_bg6_1_p().x, bg6_1_p.getPosition_bg6_1_p().y);
            sb.draw(bg1_p.getBg1_p(), bg1_p.getPosition_bg1_p().x, bg1_p.getPosition_bg1_p().y);
            sb.draw(bg1_1_p.getBg1_1_p(), bg1_1_p.getPosition_bg1_1_p().x, bg1_1_p.getPosition_bg1_1_p().y);
            sb.draw(bg3_p.getBg3_p(), bg3_p.getPosition_bg3_p().x, bg3_p.getPosition_bg3_p().y);
            sb.draw(bg3_1_p.getBg3_1_p(), bg3_1_p.getPosition_bg3_1_p().x, bg3_1_p.getPosition_bg3_1_p().y);
            sb.draw(bg2.getBg2(), bg2.getPosition_bg2().x, bg2.getPosition_bg2().y);
            sb.draw(bg2_1.getBg2_1(), bg2_1.getPosition_bg2_1().x, bg2_1.getPosition_bg2_1().y);
            sb.draw(bg4.getBg4(), bg4.getPosition_bg4().x, bg4.getPosition_bg4().y);
            sb.draw(bg4_1.getBg4_1(), bg4_1.getPosition_bg4_1().x, bg4_1.getPosition_bg4_1().y);
            sb.draw(bg5.getBg5(), bg5.getPosition_bg5().x, bg5.getPosition_bg5().y);
            sb.draw(bg5_1.getBg5_1(), bg5_1.getPosition_bg5_1().x, bg5_1.getPosition_bg5_1().y);
            sb.draw(bg_snow_1.getBg_snow_1(), bg_snow_1.getPosition_bg_snow_1().x, bg_snow_1.getPosition_bg_snow_1().y);
            sb.draw(bg_snow_1_1.getBg_snow_1_1(), bg_snow_1_1.getPosition_bg_snow_1_1().x, bg_snow_1_1.getPosition_bg_snow_1_1().y);
            sb.draw(bg_snow_1_y.getBg_snow_1_y(), bg_snow_1_y.getPosition_bg_snow_1_y().x, bg_snow_1_y.getPosition_bg_snow_1_y().y);
            sb.draw(bg_snow_1_1_y.getBg_snow_1_1_y(), bg_snow_1_1_y.getPosition_bg_snow_1_1_y().x, bg_snow_1_1_y.getPosition_bg_snow_1_1_y().y);
        }

        sb.draw(pinguin.getPinguin(), pinguin.getPosition().x, pinguin.getPosition().y);


        for (int i = 0; i < enemies.size(); i++) {
            sb.draw(enemies.get(i).getEnemy(), enemies.get(i).getPosition().x, enemies.get(i).getPosition().y);
        }

        for (int i = 0; i < fishes.size(); i++) {

            sb.draw(fishes.get(i).getFish(), fishes.get(i).getPosition().x, fishes.get(i).getPosition().y);

        }

        if (!bottles.isEmpty()) {
            sb.draw(bottles.get(0).getBottle(), bottles.get(0).getPosition().x, bottles.get(0).getPosition().y);
        }

        if (back == 3) {
            sb.draw(bg_snow_2.getBg_snow_2(), bg_snow_2.getPosition_bg_snow_2().x, bg_snow_2.getPosition_bg_snow_2().y);
            sb.draw(bg_snow_2_1.getBg_snow_2_1(), bg_snow_2_1.getPosition_bg_snow_2_1().x, bg_snow_2_1.getPosition_bg_snow_2_1().y);
            sb.draw(bg_snow_2_y.getBg_snow_2_y(), bg_snow_2_y.getPosition_bg_snow_2_y().x, bg_snow_2_y.getPosition_bg_snow_2_y().y);
            sb.draw(bg_snow_2_1_y.getBg_snow_2_1_y(), bg_snow_2_1_y.getPosition_bg_snow_2_1_y().x, bg_snow_2_1_y.getPosition_bg_snow_2_1_y().y);
        }

        if (gamestatus == GAME_RUNNING) {
            if (tutorial == false) {
                for (int i = 0; i < arrEatenFishes.length; i++) {
                    switch (arrEatenFishes[i]) {
                        case ('0'):
                            sb.draw(zero, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('1'):
                            sb.draw(one, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('2'):
                            sb.draw(two, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('3'):
                            sb.draw(three, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('4'):
                            sb.draw(four, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('5'):
                            sb.draw(five, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('6'):
                            sb.draw(six, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('7'):
                            sb.draw(seven, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('8'):
                            sb.draw(eight, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                        case ('9'):
                            sb.draw(nine, scoreX[arrEatenFishes.length - i - 1], scoreY);
                            break;
                    }
                }

                sb.draw(pause, 16, 170);
            }

            if(SouthPole.prefs.getInteger("Fishes") == 0 && SouthPole.prefs.getInteger("highScore") == 0 && tutorialCount == 0){
                sb.draw(blur, 0, 0);
                tutorial = true;
                sb.draw(tutorialBg,0,0);
            }
        }



        if (gamestatus == GAME_PAUSED) {
            sb.draw(blur, 0, 0);
            sb.draw(playButton.getPlayButtonPlay(), playButton.getPosition().x, playButton.getPosition().y);

            int scorePauseX = 160 - 34 - arrEatenFishes.length*8;
            sb.draw(score, scorePauseX, 18);
            for (int i = 0; i < arrEatenFishes.length; i++) {
                switch (arrEatenFishes[i]) {
                    case ('0'):
                        sb.draw(zero, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('1'):
                        sb.draw(one, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('2'):
                        sb.draw(two, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('3'):
                        sb.draw(three, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('4'):
                        sb.draw(four, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('5'):
                        sb.draw(five, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('6'):
                        sb.draw(six, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('7'):
                        sb.draw(seven, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('8'):
                        sb.draw(eight, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                    case ('9'):
                        sb.draw(nine, scorePauseX + 63 + 5 + 16 * i, 18);
                        break;
                }
            }
        }
        sb.end();
    }

    public void pauseGame() {
        gamestatus = GAME_PAUSED;
    }

    public void runGame() {
        gamestatus = GAME_RUNNING;
        playButtonAnimation = new AnimationPlayButton(new TextureRegion(playButton.texture), playButton.texture, 4.0f, "Play");
    }

    public void pause() {
        pauseGame();
    }

    public void resume() {
        runGame();
    }

    @Override
    public void dispose() {
        if (gamestatus == GAME_PAUSED) {
            playButton.dispose();
        }
        else if (gamestatus == GAME_RUNNING){
            pinguin.dispose();
        }

        fish.dispose();
        click.dispose();
        music_play.dispose();
        fly.dispose();
    }

    public static boolean enemyAnimationIsChanged(int num, int rowIndex){
        if (rowIndex == 1){
            enemyAnimations.set(num, new AnimationEnemy(new TextureRegion(Enemy.texture), texture, 0.5f, 0, num, 0));
        }
        else{
            enemyAnimations.set(num, new AnimationEnemy(new TextureRegion(Enemy.texture), texture, 0.5f, 0, num, 1));
        }

        return false;
    }

    public static boolean playButtonAnimationIsChanged(){
        playButtonAnimation = new AnimationPlayButton(new TextureRegion(playButton.texture), playButton.texture, 4.0f, "Play");
        return false;
    }

    public static boolean actIsEmpty(){
        pinguin.act = "";
        pinguin.actIsChanged = true;
        pinguinAnimation.current_frame = 0;
        pinguinAnimation = new AnimationPinguin(new TextureRegion(pinguin.texture), 0.3f);
        return false;
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
        if (tutorial == false) {
            pinguin.act = "touchDown";
            pinguin.actIsChanged = true;
            pinguinAnimation = new AnimationPinguin(new TextureRegion(pinguin.texture), 0.3f);
            pinguin.GRAVITY = (float) -0.2;
            if (pinguin.old_act != "jump") {
                if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                    long id = fly.play();
                    fly.setLooping(id, true);
                }
                pinguin.touchDown();
            } else if (pinguin.old_act == "jump") {
                pinguin.jump();
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if (touchPos.x >= 16 && touchPos.x <= 16 + 16 && touchPos.y >= 170 && touchPos.y <= 170 + 16 && gamestatus == GAME_RUNNING){
            fly.stop();
            if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                click.play(1.0f);
            }
            if (SouthPole.prefs.getString("checkmusic").equals("on")){
                music_play.setVolume(0.2f);
            }
            pause();
        }

        else if (gamestatus == GAME_PAUSED){
            fly.stop();
            if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                click.play(1.0f);
            }
            if (SouthPole.prefs.getString("checkmusic").equals("on")){
                music_play.setVolume(0.6f);
            }
            pinguin.GRAVITY = -3;
            pinguin.act = "fall";
            resume();
        }

        else if (gamestatus == GAME_RUNNING && tutorial){
            pinguin.GRAVITY = -3;
            pinguin.act = "fall";
            tutorial = false;
            tutorialCount = 1;
        }

        else {
            touch_count++;
            pinguin.GRAVITY = -3;
            if (touch_count != 1) {
                fly.stop();
                pinguin.act = "jump";
                pinguin.actIsChanged = true;
                pinguinAnimation = new AnimationPinguin(new TextureRegion(pinguin.texture), 0.3f);
                pinguin.jump();
            }
        }
        return false;
    }

    public static boolean fall(){
        pinguin.act = "fall";
        pinguin.actIsChanged = true;
        pinguinAnimation.current_frame = 0;
        pinguinAnimation = new AnimationPinguin(new TextureRegion(pinguin.texture), 0.3f);
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

}
