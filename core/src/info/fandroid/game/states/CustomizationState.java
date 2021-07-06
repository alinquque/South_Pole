package info.fandroid.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Random;

import info.fandroid.game.SouthPole;
import info.fandroid.game.sprites.AnimationBird;
import info.fandroid.game.sprites.AnimationPinguinSkin;
import info.fandroid.game.sprites.Bird;
import info.fandroid.game.sprites.PinguinSkin;

import static info.fandroid.game.SouthPole.touchPos;

public class CustomizationState extends State implements InputProcessor {

    private Texture background;
    private Texture back;
    private Texture green;

    private Texture select;
    private Texture selected;

    private Texture buy_100;
    private Texture buy_100_non;
    private Texture buy_300;
    private Texture buy_300_non;
    private Texture buy_500;
    private Texture buy_500_non;
    private Texture buy_700;
    private Texture buy_700_non;
    private Texture buy_1000;
    private Texture buy_1000_non;
    private Texture wantToBuy;

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

    private Texture bigFish;

    private Texture pinguin;
    private Texture pinguin1;
    public static PinguinSkin pinguin_animation;
    public static AnimationPinguinSkin pinguinAnimation;
    private Texture orange;
    private Texture orange1;
    public static PinguinSkin orange_animation;
    public static AnimationPinguinSkin orangeAnimation;
    private Texture baby;
    private Texture baby1;
    public static PinguinSkin baby_animation;
    public static AnimationPinguinSkin babyAnimation;
    private Texture cock;
    private Texture cock1;
    public static PinguinSkin cock_animation;
    public static AnimationPinguinSkin cockAnimation;
    private Texture superping;
    private Texture superping1;
    public static PinguinSkin superping_animation;
    public static AnimationPinguinSkin superpingAnimation;
    private Texture hohlatiy;
    private Texture hohlatiy1;
    public static PinguinSkin hohlatiy_animation;
    public static AnimationPinguinSkin hohlatiyAnimation;


    public static Texture textureBird;
    public static AnimationBird birdAnimation;

    private Sound click;

    public static String checkSkin;

    public int frameBird;
    public int rowIndexBird;
    public static int k;

    public String wantToBuy_check;

    public int y1;
    public int x2 = 50;

    Random random = new Random();

    public static ArrayList<Bird> birds;
    public static ArrayList<AnimationBird> birdAnimations;

    public CustomizationState(GameStateManager gsm) {
        super(gsm);
        checkSkin = SouthPole.prefs.getString("pinguinSkin");

        background = new Texture("background_cust.png");
        back = new Texture("back.png");
        green = new Texture("settings_green.png");

        select = new Texture("select.png");
        selected = new Texture("selected.png");

        bigFish = new Texture("big_fish.png");

        buy_100 = new Texture("buy_100.png");
        buy_100_non = new Texture("buy_100_non.png");
        buy_300 = new Texture("buy_300.png");
        buy_300_non = new Texture("buy_300_non.png");
        buy_500 = new Texture("buy_500.png");
        buy_500_non = new Texture("buy_500_non.png");
        buy_700 = new Texture("buy_700.png");
        buy_700_non = new Texture("buy_700_non.png");
        buy_1000 = new Texture("buy_1000.png");
        buy_1000_non = new Texture("buy_1000_non.png");

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

        wantToBuy = new Texture("areyousure.png");
        wantToBuy_check = "no";

        pinguin = new Texture("pinguin_settings.png");
        pinguin1 = new Texture("pinguin_settings1.png");
        pinguin_animation = new PinguinSkin(65,102, new Texture("pinguin_settings_animation.png"));
        pinguinAnimation = new AnimationPinguinSkin(new TextureRegion(pinguin_animation.texture), pinguin_animation.texture, 0.5f);
        orange = new Texture("orange_settings.png");
        orange1 = new Texture("orange_settings1.png");
        orange_animation = new PinguinSkin(65,102, new Texture("orange_settings_animation.png"));
        orangeAnimation = new AnimationPinguinSkin(new TextureRegion(orange_animation.texture), orange_animation.texture, 0.5f);
        baby = new Texture("baby_settings.png");
        baby1 = new Texture("baby_settings1.png");
        baby_animation = new PinguinSkin(65,102, new Texture("baby_settings_animation.png"));
        babyAnimation = new AnimationPinguinSkin(new TextureRegion(baby_animation.texture), baby_animation.texture, 0.5f);
        cock = new Texture("cock_settings.png");
        cock1 = new Texture("cock_settings1.png");
        cock_animation = new PinguinSkin(65,102, new Texture("cock_settings_animation.png"));
        cockAnimation = new AnimationPinguinSkin(new TextureRegion(cock_animation.texture), cock_animation.texture, 0.5f);
        superping = new Texture("superping_settings.png");
        superping1 = new Texture("superping_settings1.png");
        superping_animation = new PinguinSkin(65,102, new Texture("superping_settings_animation.png"));
        superpingAnimation = new AnimationPinguinSkin(new TextureRegion(superping_animation.texture), superping_animation.texture, 0.5f);
        hohlatiy = new Texture("hohlatiy_settings.png");
        hohlatiy1 = new Texture("hohlatiy_settings1.png");
        hohlatiy_animation = new PinguinSkin(65,102, new Texture("hohlatiy_settings_animation.png"));
        hohlatiyAnimation = new AnimationPinguinSkin(new TextureRegion(hohlatiy_animation.texture), hohlatiy_animation.texture, 0.5f);

        textureBird = new Texture("bird_cust.png");

        birds = new ArrayList<>();
        birdAnimations = new ArrayList<>();
        k = 0;

        Gdx.input.setInputProcessor(this);

        birds.clear();
        birdAnimations.clear();


        click = Gdx.audio.newSound(Gdx.files.internal("click.wav"));
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {
        y1 = random.nextInt(120) + 50;

        frameBird = random.nextInt(5);
        rowIndexBird = random.nextInt(2);

        if (birds.isEmpty()){
            birdAnimation = new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, frameBird, k, rowIndexBird, "Cust");
            birdAnimations.add(birdAnimation);
            Bird bird = new Bird(340, y1, textureBird, "Cust");
            birds.add(bird);
            k++;
        }
        else{
            if (320 - birds.get(k-1).getPosition().x >= x2){
                birdAnimation = new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, frameBird, k, rowIndexBird, "Cust");
                birdAnimations.add(birdAnimation);
                Bird bird = new Bird(340, y1,  textureBird, "Cust");
                birds.add(bird);
                k++;
                x2 = random.nextInt(100) + 50;
            }
            if (birds.get(0).getPosition().x < -16.0f){
                birds.remove(0);
                birdAnimations.remove(0);
                k--;
                for(int i = 0; i<birds.size(); i++) {
                    birds.get(i).index -= 1;
                    birdAnimations.get(i).index -= 1;
                }
            }
        }

        for(int i=0; i<birds.size(); i++) {
            birds.get(i).update(dt);
        }

        if (checkSkin.equals("pinguin")){
            pinguin_animation.update(dt);
        }
        else if (checkSkin.equals("orange")){
            orange_animation.update(dt);
        }
        else if (checkSkin.equals("baby")){
            baby_animation.update(dt);
        }
        else if (checkSkin.equals("cock")){
            cock_animation.update(dt);
        }
        else if (checkSkin.equals("superping")){
            superping_animation.update(dt);
        }
        else if (checkSkin.equals("hohlatiy")){
            hohlatiy_animation.update(dt);
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, SouthPole.WIDTH, SouthPole.HEIGHT);

        for(int i=0; i<birds.size(); i++) {
            sb.draw(birds.get(i).getBirdCustomization(), birds.get(i).getPosition().x, birds.get(i).getPosition().y);
        }
        sb.draw(back, 10, 174);
        sb.draw(green, 0, 0);
        sb.draw(bigFish, 298, 174);

        char [] arrFishes = (String.valueOf(SouthPole.prefs.getInteger("Fishes"))).toCharArray();

        for (int i = 0; i < arrFishes.length; i++) {
            switch (arrFishes[arrFishes.length-i-1]) {
                case ('0'):
                    sb.draw(zero, 281 - 16 * i, 174);
                    break;
                case ('1'):
                    sb.draw(one, 281 - 16 * i, 174);
                    break;
                case ('2'):
                    sb.draw(two, 281 - 16 * i, 174);
                    break;
                case ('3'):
                    sb.draw(three, 281 - 16 * i, 174);
                    break;
                case ('4'):
                    sb.draw(four, 281 - 16 * i, 174);
                    break;
                case ('5'):
                    sb.draw(five, 281 - 16 * i, 174);
                    break;
                case ('6'):
                    sb.draw(six, 281 - 16 * i, 174);
                    break;
                case ('7'):
                    sb.draw(seven, 281 - 16 * i, 174);
                    break;
                case ('8'):
                    sb.draw(eight, 281 - 16 * i, 174);
                    break;
                case ('9'):
                    sb.draw(nine, 281 - 16 * i, 174);
                    break;
            }
        }

        if (checkSkin.equals("pinguin")){
            sb.draw(pinguin_animation.getPinguinSkin_pinguin(), pinguin_animation.getPosition().x, pinguin_animation.getPosition().y);
            if (SouthPole.prefs.getString("pinguinSkin").equals("pinguin")){
                sb.draw(selected, 144, 24);
            }
            else{
                sb.draw(select, 144, 24);
            }

            sb.draw(pinguin, 144, 124);
            sb.draw(orange1, 194, 124);
            sb.draw(baby1, 244, 124);
            sb.draw(cock1, 144, 74);
            sb.draw(superping1, 194, 74);
            sb.draw(hohlatiy1, 244, 74);
        }
        else if (checkSkin.equals("orange")){
            sb.draw(orange_animation.getPinguinSkin_orange(), orange_animation.getPosition().x, orange_animation.getPosition().y);

            if (SouthPole.prefs.getString("pinguinSkin").equals("orange")) {
                sb.draw(selected, 144, 24);
            }
            else if (SouthPole.prefs.getString("orange").equals("yes")){
                sb.draw(select, 144, 24);
            }
            else if (SouthPole.prefs.getString("orange").equals("no") && SouthPole.prefs.getInteger("Fishes") >= 100){
                sb.draw(buy_100, 144, 24);
            }
            else if (SouthPole.prefs.getString("orange").equals("no") && SouthPole.prefs.getInteger("Fishes") < 100){
                sb.draw(buy_100_non, 144, 24);
            }

            sb.draw(pinguin1, 144, 124);
            sb.draw(orange, 194, 124);
            sb.draw(baby1, 244, 124);
            sb.draw(cock1, 144, 74);
            sb.draw(superping1, 194, 74);
            sb.draw(hohlatiy1, 244, 74);
        }
        else if (checkSkin.equals("baby")){
            sb.draw(baby_animation.getPinguinSkin_baby(), baby_animation.getPosition().x, baby_animation.getPosition().y);

            if (SouthPole.prefs.getString("pinguinSkin") == "baby") {
                sb.draw(selected, 144, 24);
            }
            else if (SouthPole.prefs.getString("baby") == "yes"){
                sb.draw(select, 144, 24);


            }
            else if (SouthPole.prefs.getString("baby").equals("no") && SouthPole.prefs.getInteger("Fishes") >= 300){
                sb.draw(buy_300, 144, 24);
            }
            else if (SouthPole.prefs.getString("baby").equals("no") && SouthPole.prefs.getInteger("Fishes") < 300){
                sb.draw(buy_300_non, 144, 24);
            }

            sb.draw(pinguin1, 144, 124);
            sb.draw(orange1, 194, 124);
            sb.draw(baby, 244, 124);
            sb.draw(cock1, 144, 74);
            sb.draw(superping1, 194, 74);
            sb.draw(hohlatiy1, 244, 74);
        }
        else if (checkSkin.equals("cock")){
            sb.draw(cock_animation.getPinguinSkin_cock(), cock_animation.getPosition().x, cock_animation.getPosition().y);

            if (SouthPole.prefs.getString("pinguinSkin").equals("cock")) {
                sb.draw(selected, 144, 24);
            }
            else if (SouthPole.prefs.getString("cock").equals("yes")){
                sb.draw(select, 144, 24);
            }
            else if (SouthPole.prefs.getString("cock").equals("no") && SouthPole.prefs.getInteger("Fishes") >= 500){
                sb.draw(buy_500, 144, 24);
            }
            else if (SouthPole.prefs.getString("cock").equals("no") && SouthPole.prefs.getInteger("Fishes") < 500){
                sb.draw(buy_500_non, 144, 24);
            }

            sb.draw(pinguin1, 144, 124);
            sb.draw(orange1, 194, 124);
            sb.draw(baby1, 244, 124);
            sb.draw(cock, 144, 74);
            sb.draw(superping1, 194, 74);
            sb.draw(hohlatiy1, 244, 74);
        }
        else if (checkSkin.equals("superping")){
            sb.draw(superping_animation.getPinguinSkin_superping(), superping_animation.getPosition().x, superping_animation.getPosition().y);

            if (SouthPole.prefs.getString("pinguinSkin").equals("superping")) {
                sb.draw(selected, 144, 24);
            }
            else if (SouthPole.prefs.getString("superping").equals("yes")){
                sb.draw(select, 144, 24);
            }
            else if (SouthPole.prefs.getString("superping").equals("no") && SouthPole.prefs.getInteger("Fishes") >= 700){
                sb.draw(buy_700, 144, 24);
            }
            else if (SouthPole.prefs.getString("superping").equals("no") && SouthPole.prefs.getInteger("Fishes") < 700){
                sb.draw(buy_700_non, 144, 24);
            }

            sb.draw(pinguin1, 144, 124);
            sb.draw(orange1, 194, 124);
            sb.draw(baby1, 244, 124);
            sb.draw(cock1, 144, 74);
            sb.draw(superping, 194, 74);
            sb.draw(hohlatiy1, 244, 74);
        }
        else if (checkSkin.equals("hohlatiy")){
            sb.draw(hohlatiy_animation.getPinguinSkin_hohlatiy(), hohlatiy_animation.getPosition().x, hohlatiy_animation.getPosition().y);

            if (SouthPole.prefs.getString("pinguinSkin").equals("hohlatiy")) {
                sb.draw(selected, 144, 24);
            }
            else if (SouthPole.prefs.getString("hohlatiy").equals("yes")){
                sb.draw(select, 144, 24);
            }
            else if (SouthPole.prefs.getString("hohlatiy").equals("no") && SouthPole.prefs.getInteger("Fishes") >= 1000){
                sb.draw(buy_1000, 144, 24);
            }
            else if (SouthPole.prefs.getString("hohlatiy").equals("no") && SouthPole.prefs.getInteger("Fishes") < 1000){
                sb.draw(buy_1000_non, 144, 24);
            }

            sb.draw(pinguin1, 144, 124);
            sb.draw(orange1, 194, 124);
            sb.draw(baby1, 244, 124);
            sb.draw(cock1, 144, 74);
            sb.draw(superping1, 194, 74);
            sb.draw(hohlatiy, 244, 74);
        }

        if (wantToBuy_check == "yes"){
            sb.draw(wantToBuy, 0,0);
        }

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        if (checkSkin.equals("pinguin")){
            pinguin_animation.dispose();
        }
        else if (checkSkin.equals("orange")){
            orange_animation.dispose();
        }
        else if (checkSkin.equals("baby")){
            baby_animation.dispose();
        }
        else if (checkSkin.equals("cock")){
            cock_animation.dispose();
        }
        else if (checkSkin.equals("superping")){
            superping_animation.dispose();
        }
        else if (checkSkin.equals("hohlatiy")){
            hohlatiy_animation.dispose();
        }
    }

    public static boolean birdAnimationIsChanged(int num, int rowIndex){
        if (rowIndex == 1){
            birdAnimations.set(num, new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, 0, num, 0, "Cust"));
        }
        else{
            birdAnimations.set(num, new AnimationBird(new TextureRegion(textureBird), textureBird, 0.5f, 0, num, 1, "Cust"));
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (touchPos.x >= 10 && touchPos.x <= 10 + 16 && touchPos.y >= 174 && touchPos.y <= 174 + 16 && wantToBuy_check.equals("no")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            gsm.set(new MenuState(gsm));
        }

        if (touchPos.x >= 144 && touchPos.x <= 144 + 40 && touchPos.y >= 124 && touchPos.y <= 124 + 40 && wantToBuy_check.equals("no")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            checkSkin = "pinguin";
        }

        if (touchPos.x >= 194 && touchPos.x <= 194 + 40 && touchPos.y >= 124 && touchPos.y <= 124 + 40 && wantToBuy_check.equals("no")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            checkSkin = "orange";
        }

        if (touchPos.x >= 244 && touchPos.x <= 244 + 40 && touchPos.y >= 124 && touchPos.y <= 124 + 40 && wantToBuy_check.equals("no")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            checkSkin = "baby";
        }

        if (touchPos.x >= 144 && touchPos.x <= 144 + 40 && touchPos.y >= 74 && touchPos.y <= 74 + 40 && wantToBuy_check.equals("no")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            checkSkin = "cock";
        }

        if (touchPos.x >= 194 && touchPos.x <= 194 + 40 && touchPos.y >= 74 && touchPos.y <= 74 + 40 && wantToBuy_check.equals("no")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            checkSkin = "superping";
        }

        if (touchPos.x >= 244 && touchPos.x <= 244 + 40 && touchPos.y >= 74 && touchPos.y <= 74 + 40 && wantToBuy_check.equals("no")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            checkSkin = "hohlatiy";
        }

        //pinguin
        if (touchPos.x >= 144 && touchPos.x <= 144 + 140 && touchPos.y >= 24 && touchPos.y <= 24 + 40 && wantToBuy_check.equals("no")){
            if (checkSkin.equals("pinguin")) {
                if (SouthPole.prefs.getString("pinguinSkin") != "pinguin") {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    SouthPole.prefs.putString("pinguinSkin", "pinguin");
                    SouthPole.prefs.flush();
                }
            }
        }

        //orange
        if (touchPos.x >= 144 && touchPos.x <= 144 + 140 && touchPos.y >= 24 && touchPos.y <= 24 + 40 && wantToBuy_check.equals("no")){
            if (checkSkin.equals("orange")) {
                if ((SouthPole.prefs.getString("orange").equals("no")) && SouthPole.prefs.getInteger("Fishes") >= 100) {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    wantToBuy_check = "yes";
                }
                else if ((SouthPole.prefs.getString("orange").equals("yes")) && SouthPole.prefs.getString("pinguinSkin") != "orange") {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    SouthPole.prefs.putString("pinguinSkin", "orange");
                    SouthPole.prefs.flush();
                }
            }
        }
        else if (touchPos.x >= 48 && touchPos.x <= 48 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("orange")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
            SouthPole.prefs.putString("pinguinSkin", "orange");
            SouthPole.prefs.putString("orange", "yes");
            SouthPole.prefs.putInteger("Fishes", SouthPole.prefs.getInteger("Fishes")-100);
            SouthPole.prefs.flush();
        }
        else if (touchPos.x >= 203 && touchPos.x <= 203 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("orange")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
        }

        //baby
        if (touchPos.x >= 144 && touchPos.x <= 144 + 140 && touchPos.y >= 24 && touchPos.y <= 24 + 40 && wantToBuy_check.equals("no")){
            if (checkSkin == "baby") {
                if ((SouthPole.prefs.getString("baby").equals("no")) && SouthPole.prefs.getInteger("Fishes") >= 300) {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    wantToBuy_check = "yes";
                } else if ((SouthPole.prefs.getString("baby").equals("yes")) && SouthPole.prefs.getString("pinguinSkin") != "baby") {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    SouthPole.prefs.putString("pinguinSkin", "baby");
                    SouthPole.prefs.flush();
                }
            }
        }
        else if (touchPos.x >= 48 && touchPos.x <= 48 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("baby")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
            SouthPole.prefs.putString("pinguinSkin", "baby");
            SouthPole.prefs.putString("baby", "yes");
            SouthPole.prefs.putInteger("Fishes", SouthPole.prefs.getInteger("Fishes")-300);
            SouthPole.prefs.flush();
        }
        else if (touchPos.x >= 203 && touchPos.x <= 203 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("baby")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
        }

        //cock
        if (touchPos.x >= 144 && touchPos.x <= 144 + 140 && touchPos.y >= 24 && touchPos.y <= 24 + 40 && wantToBuy_check.equals("no")){
            if (checkSkin.equals("cock")) {
                if ((SouthPole.prefs.getString("cock").equals("no")) && SouthPole.prefs.getInteger("Fishes") >= 500) {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    wantToBuy_check = "yes";
                } else if ((SouthPole.prefs.getString("cock").equals("yes")) && SouthPole.prefs.getString("pinguinSkin") != "cock") {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    SouthPole.prefs.putString("pinguinSkin", "cock");
                    SouthPole.prefs.flush();
                }
            }
        }

        else if (touchPos.x >= 48 && touchPos.x <= 48 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("cock")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
            SouthPole.prefs.putString("pinguinSkin", "cock");
            SouthPole.prefs.putString("cock", "yes");
            SouthPole.prefs.putInteger("Fishes", SouthPole.prefs.getInteger("Fishes")-500);
            SouthPole.prefs.flush();
        }
        else if (touchPos.x >= 203 && touchPos.x <= 203 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("cock")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
        }

        //superping
        if (touchPos.x >= 144 && touchPos.x <= 144 + 140 && touchPos.y >= 24 && touchPos.y <= 24 + 40 && wantToBuy_check.equals("no")){
            if (checkSkin.equals("superping")) {
                if ((SouthPole.prefs.getString("superping").equals("no")) && SouthPole.prefs.getInteger("Fishes") >= 700) {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    wantToBuy_check = "yes";
                } else if ((SouthPole.prefs.getString("superping").equals("yes")) && SouthPole.prefs.getString("pinguinSkin") != "superping") {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    SouthPole.prefs.putString("pinguinSkin", "superping");
                    SouthPole.prefs.flush();
                }
            }
        }

        else if (touchPos.x >= 48 && touchPos.x <= 48 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("superping")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
            SouthPole.prefs.putString("pinguinSkin", "superping");
            SouthPole.prefs.putString("superping", "yes");
            SouthPole.prefs.putInteger("Fishes", SouthPole.prefs.getInteger("Fishes")-700);
            SouthPole.prefs.flush();
        }
        else if (touchPos.x >= 203 && touchPos.x <= 203 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("superping")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
        }

        //hohlatiy
        if (touchPos.x >= 144 && touchPos.x <= 144 + 140 && touchPos.y >= 24 && touchPos.y <= 24 + 40 && wantToBuy_check.equals("no")){
            if (checkSkin.equals("hohlatiy")) {
                if ((SouthPole.prefs.getString("hohlatiy").equals("no")) && SouthPole.prefs.getInteger("Fishes") >= 1000) {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    wantToBuy_check = "yes";
                } else if ((SouthPole.prefs.getString("hohlatiy").equals("yes")) && SouthPole.prefs.getString("pinguinSkin") != "hohlatiy") {
                    if (SouthPole.prefs.getString("checkeffects").equals("on")) {
                        click.play(1.0f);
                    }
                    SouthPole.prefs.putString("pinguinSkin", "hohlatiy");
                    SouthPole.prefs.flush();
                }
            }
        }

        else if (touchPos.x >= 48 && touchPos.x <= 48 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("hohlatiy")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
            SouthPole.prefs.putString("pinguinSkin", "hohlatiy");
            SouthPole.prefs.putString("hohlatiy", "yes");
            SouthPole.prefs.putInteger("Fishes", SouthPole.prefs.getInteger("Fishes")-1000);
            SouthPole.prefs.flush();
        }
        else if (touchPos.x >= 203 && touchPos.x <= 203 + 57 && touchPos.y >= 48 && touchPos.y <= 48 + 36 && wantToBuy_check.equals("yes") && checkSkin.equals("hohlatiy")){
            if (SouthPole.prefs.getString("checkeffects").equals("on")){
                click.play(1.0f);
            }
            wantToBuy_check = "no";
        }

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
