package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import info.fandroid.game.states.PlayState;


public class Background {

    private Texture bg1;
    private Texture bg1_1;
    private Texture bg1_n;
    private Texture bg1_1_n;
    private Texture bg1_d;
    private Texture bg1_1_d;
    private Texture bg1_p;
    private Texture bg1_1_p;
    private Texture bg2;
    private Texture bg2_1;
    private Texture bg3;
    private Texture bg3_1;
    private Texture bg3_n;
    private Texture bg3_1_n;
    private Texture bg3_d;
    private Texture bg3_1_d;
    private Texture bg3_p;
    private Texture bg3_1_p;
    private Texture bg4;
    private Texture bg4_1;
    private Texture bg5;
    private Texture bg5_1;
    private Texture bg6;
    private Texture bg6_1;
    private Texture bg6_n;
    private Texture bg6_1_n;
    private Texture bg6_d;
    private Texture bg6_1_d;
    private Texture bg6_p;
    private Texture bg6_1_p;

    private Texture bg_snow_1;
    private Texture bg_snow_1_1;
    private Texture bg_snow_1_y;
    private Texture bg_snow_1_1_y;
    private Texture bg_snow_2;
    private Texture bg_snow_2_1;
    private Texture bg_snow_2_y;
    private Texture bg_snow_2_1_y;

    private Vector3 position_bg1;
    private Vector3 position_bg1_1;
    private Vector3 position_bg1_n;
    private Vector3 position_bg1_1_n;
    private Vector3 position_bg1_d;
    private Vector3 position_bg1_1_d;
    private Vector3 position_bg1_p;
    private Vector3 position_bg1_1_p;
    private Vector3 position_bg2;
    private Vector3 position_bg2_1;
    private Vector3 position_bg3;
    private Vector3 position_bg3_1;
    private Vector3 position_bg3_n;
    private Vector3 position_bg3_1_n;
    private Vector3 position_bg3_d;
    private Vector3 position_bg3_1_d;
    private Vector3 position_bg3_p;
    private Vector3 position_bg3_1_p;
    private Vector3 position_bg4;
    private Vector3 position_bg4_1;
    private Vector3 position_bg5;
    private Vector3 position_bg5_1;
    private Vector3 position_bg6;
    private Vector3 position_bg6_1;
    private Vector3 position_bg6_n;
    private Vector3 position_bg6_1_n;
    private Vector3 position_bg6_d;
    private Vector3 position_bg6_1_d;
    private Vector3 position_bg6_p;
    private Vector3 position_bg6_1_p;
    private Vector3 position_bg_snow_1;
    private Vector3 position_bg_snow_1_1;
    private Vector3 position_bg_snow_1_y;
    private Vector3 position_bg_snow_1_1_y;
    private Vector3 position_bg_snow_2;
    private Vector3 position_bg_snow_2_1;
    private Vector3 position_bg_snow_2_y;
    private Vector3 position_bg_snow_2_1_y;

    private float speed_bg1;
    private float speed_bg2;
    private float speed_bg3;
    private float speed_bg4;
    private float speed_bg5;
    private float speed_bg6;
    private float speed_snow_1;
    private float speed_snow_2;

    public Background(int x, int y){

        bg1 = new Texture("background_1.png");
        bg1_1 = new Texture("background_1.png");
        bg1_n = new Texture("background_1_n.png");
        bg1_1_n = new Texture("background_1_n.png");
        bg1_d = new Texture("background_1_d.png");
        bg1_1_d = new Texture("background_1_d.png");
        bg1_p = new Texture("background_1_p.png");
        bg1_1_p = new Texture("background_1_p.png");

        bg2 = new Texture("background_2.png");
        bg2_1 = new Texture("background_2.png");

        bg3 = new Texture("background_3.png");
        bg3_1 = new Texture("background_3.png");
        bg3_n = new Texture("background_3_n.png");
        bg3_1_n = new Texture("background_3_n.png");
        bg3_d = new Texture("background_3_d.png");
        bg3_1_d = new Texture("background_3_d.png");
        bg3_p = new Texture("background_3_p.png");
        bg3_1_p = new Texture("background_3_p.png");

        bg4 = new Texture("background_4.png");
        bg4_1 = new Texture("background_4.png");

        bg5 = new Texture("background_5.png");
        bg5_1 = new Texture("background_5.png");

        bg6 = new Texture("background_6.png");
        bg6_1 = new Texture("background_6.png");
        bg6_n = new Texture("background_6_n.png");
        bg6_1_n = new Texture("background_6_n.png");
        bg6_d = new Texture("background_6_d.png");
        bg6_1_d = new Texture("background_6_d.png");
        bg6_p = new Texture("background_6_p.png");
        bg6_1_p = new Texture("background_6_p.png");

        bg_snow_1 = new Texture("background_snow_1.png");
        bg_snow_1_1 = new Texture("background_snow_1.png");
        bg_snow_1_y = new Texture("background_snow_1.png");
        bg_snow_1_1_y = new Texture("background_snow_1.png");
        bg_snow_2 = new Texture("background_snow_2.png");
        bg_snow_2_1 = new Texture("background_snow_2.png");
        bg_snow_2_y = new Texture("background_snow_2.png");
        bg_snow_2_1_y = new Texture("background_snow_2.png");

        position_bg1 = new Vector3(x, y, 0);
        position_bg1_1 = new Vector3(x, y, 0);
        position_bg1_n = new Vector3(x, y, 0);
        position_bg1_1_n = new Vector3(x, y, 0);
        position_bg1_d = new Vector3(x, y, 0);
        position_bg1_1_d = new Vector3(x, y, 0);
        position_bg1_p = new Vector3(x, y, 0);
        position_bg1_1_p = new Vector3(x, y, 0);
        position_bg2 = new Vector3(x, y, 0);
        position_bg2_1 = new Vector3(x, y, 0);
        position_bg3 = new Vector3(x, y, 0);
        position_bg3_1 = new Vector3(x, y, 0);
        position_bg3_n = new Vector3(x, y, 0);
        position_bg3_1_n = new Vector3(x, y, 0);
        position_bg3_d = new Vector3(x, y, 0);
        position_bg3_1_d = new Vector3(x, y, 0);
        position_bg3_p = new Vector3(x, y, 0);
        position_bg3_1_p = new Vector3(x, y, 0);
        position_bg4 = new Vector3(x, y, 0);
        position_bg4_1 = new Vector3(x, y, 0);
        position_bg5 = new Vector3(x, y, 0);
        position_bg5_1 = new Vector3(x, y, 0);
        position_bg6 = new Vector3(x, y, 0);
        position_bg6_1 = new Vector3(x, y, 0);
        position_bg6_n = new Vector3(x, y, 0);
        position_bg6_1_n = new Vector3(x, y, 0);
        position_bg6_d = new Vector3(x, y, 0);
        position_bg6_1_d = new Vector3(x, y, 0);
        position_bg6_p = new Vector3(x, y, 0);
        position_bg6_1_p = new Vector3(x, y, 0);
        position_bg_snow_1 = new Vector3(x, y, 0);
        position_bg_snow_1_1 = new Vector3(x, y, 0);
        position_bg_snow_1_y = new Vector3(x, y, 0);
        position_bg_snow_1_1_y = new Vector3(x, y, 0);
        position_bg_snow_2 = new Vector3(x, y, 0);
        position_bg_snow_2_1 = new Vector3(x, y, 0);
        position_bg_snow_2_y = new Vector3(x, y, 0);
        position_bg_snow_2_1_y = new Vector3(x, y, 0);

        speed_bg1 = 0.125f;
        speed_bg2 = 0.3125f;
        speed_bg3 = 0.25f;
        speed_bg4 = 0.34375f;
        speed_bg5 = 0.375f;
        speed_bg6 = 0.0625f;

        speed_snow_1 = 0.3125f;
        speed_snow_2 = 0.34375f;
    }

    public Texture getBg1_1() {
        return bg1_1;
    }

    public Texture getBg1_1_n() {
        return bg1_1_n;
    }

    public Texture getBg1_1_d() {
        return bg1_1_d;
    }

    public Texture getBg1_1_p() {
        return bg1_1_p;
    }

    public Texture getBg2_1() {
        return bg2_1;
    }

    public Vector3 getPosition_bg1_1() {
        return position_bg1_1;
    }

    public Vector3 getPosition_bg1_1_n() {
        return position_bg1_1_n;
    }

    public Vector3 getPosition_bg1_1_d() {
        return position_bg1_1_d;
    }

    public Vector3 getPosition_bg1_1_p() {
        return position_bg1_1_p;
    }

    public Texture getBg6() {
        return bg6;
    }

    public Texture getBg6_n() {
        return bg6_n;
    }

    public Texture getBg6_d() {
        return bg6_d;
    }

    public Texture getBg6_p() {
        return bg6_p;
    }

    public Texture getBg_snow_1() {
        return bg_snow_1;
    }

    public Texture getBg_snow_1_y() {
        return bg_snow_1_y;
    }

    public Texture getBg_snow_2() {
        return bg_snow_2;
    }

    public Texture getBg_snow_2_y() {
        return bg_snow_2_y;
    }

    public Texture getBg6_1() {
        return bg6_1;
    }

    public Texture getBg6_1_n() {
        return bg6_1_n;
    }

    public Texture getBg6_1_d() {
        return bg6_1_d;
    }

    public Texture getBg6_1_p() {
        return bg6_1_p;
    }

    public Texture getBg_snow_1_1() {
        return bg_snow_1_1;
    }

    public Texture getBg_snow_1_1_y() {
        return bg_snow_1_1_y;
    }

    public Texture getBg_snow_2_1() {
        return bg_snow_2_1;
    }

    public Texture getBg_snow_2_1_y() {
        return bg_snow_2_1_y;
    }

    public Vector3 getPosition_bg6() {
        return position_bg6;
    }

    public Vector3 getPosition_bg6_n() {
        return position_bg6_n;
    }

    public Vector3 getPosition_bg6_d() {
        return position_bg6_d;
    }

    public Vector3 getPosition_bg6_p() {
        return position_bg6_p;
    }

    public Vector3 getPosition_bg_snow_1() {
        return position_bg_snow_1;
    }

    public Vector3 getPosition_bg_snow_1_y() {
        return position_bg_snow_1_y;
    }

    public Vector3 getPosition_bg_snow_2() {
        return position_bg_snow_2;
    }

    public Vector3 getPosition_bg_snow_2_y() {
        return position_bg_snow_2_y;
    }

    public Vector3 getPosition_bg6_1() {
        return position_bg6_1;
    }

    public Vector3 getPosition_bg6_1_n() {
        return position_bg6_1_n;
    }

    public Vector3 getPosition_bg6_1_d() {
        return position_bg6_1_d;
    }

    public Vector3 getPosition_bg6_1_p() {
        return position_bg6_1_p;
    }

    public Vector3 getPosition_bg_snow_1_1() {
        return position_bg_snow_1_1;
    }

    public Vector3 getPosition_bg_snow_1_1_y() {
        return position_bg_snow_1_1_y;
    }

    public Vector3 getPosition_bg_snow_2_1() {
        return position_bg_snow_2_1;
    }

    public Vector3 getPosition_bg_snow_2_1_y() {
        return position_bg_snow_2_1_y;
    }

    public Vector3 getPosition_bg2_1() {
        return position_bg2_1;
    }

    public Vector3 getPosition_bg1() {
        return position_bg1;
    }

    public Vector3 getPosition_bg1_n() {
        return position_bg1_n;
    }

    public Vector3 getPosition_bg1_d() {
        return position_bg1_d;
    }

    public Vector3 getPosition_bg1_p() {
        return position_bg1_p;
    }

    public Vector3 getPosition_bg2() {
        return position_bg2;
    }

    public Texture getBg1() {
        return bg1;
    }

    public Texture getBg1_n() {
        return bg1_n;
    }

    public Texture getBg1_d() {
        return bg1_d;
    }

    public Texture getBg1_p() {
        return bg1_p;
    }

    public Texture getBg2() {
        return bg2;
    }

    public Texture getBg3() {
        return bg3;
    }

    public Texture getBg3_n() {
        return bg3_n;
    }

    public Texture getBg3_d() {
        return bg3_d;
    }

    public Texture getBg3_p() {
        return bg3_p;
    }

    public Texture getBg3_1() {
        return bg3_1;
    }

    public Texture getBg3_1_n() {
        return bg3_1_n;
    }

    public Texture getBg3_1_d() {
        return bg3_1_d;
    }

    public Texture getBg3_1_p() {
        return bg3_1_p;
    }

    public Vector3 getPosition_bg3() {
        return position_bg3;
    }

    public Vector3 getPosition_bg3_n() {
        return position_bg3_n;
    }

    public Vector3 getPosition_bg3_d() {
        return position_bg3_d;
    }

    public Vector3 getPosition_bg3_p() {
        return position_bg3_p;
    }

    public Vector3 getPosition_bg3_1() {
        return position_bg3_1;
    }

    public Vector3 getPosition_bg3_1_n() {
        return position_bg3_1_n;
    }

    public Vector3 getPosition_bg3_1_d() {
        return position_bg3_1_d;
    }

    public Vector3 getPosition_bg3_1_p() {
        return position_bg3_1_p;
    }

    public Texture getBg4() {
        return bg4;
    }

    public Texture getBg4_1() {
        return bg4_1;
    }

    public Texture getBg5() {
        return bg5;
    }

    public Texture getBg5_1() {
        return bg5_1;
    }

    public Vector3 getPosition_bg4() {
        return position_bg4;
    }

    public Vector3 getPosition_bg4_1() {
        return position_bg4_1;
    }

    public Vector3 getPosition_bg5() {
        return position_bg5;
    }

    public Vector3 getPosition_bg5_1() {
        return position_bg5_1;
    }

    public void update(){

        position_bg1.x -= speed_bg1 + PlayState.boost;
        position_bg1_1.x -= speed_bg1 + PlayState.boost;

        position_bg1_n.x -= speed_bg1 + PlayState.boost;
        position_bg1_1_n.x -= speed_bg1 + PlayState.boost;

        position_bg1_d.x -= speed_bg1 + PlayState.boost;
        position_bg1_1_d.x -= speed_bg1 + PlayState.boost;

        position_bg1_p.x -= speed_bg1 + PlayState.boost;
        position_bg1_1_p.x -= speed_bg1 + PlayState.boost;

        position_bg2.x -= speed_bg2 + PlayState.boost;
        position_bg2_1.x -= speed_bg2 + PlayState.boost;

        position_bg3.x -= speed_bg3 + PlayState.boost;
        position_bg3_1.x -= speed_bg3 + PlayState.boost;

        position_bg3_n.x -= speed_bg3 + PlayState.boost;
        position_bg3_1_n.x -= speed_bg3 + PlayState.boost;

        position_bg3_d.x -= speed_bg3 + PlayState.boost;
        position_bg3_1_d.x -= speed_bg3 + PlayState.boost;

        position_bg3_p.x -= speed_bg3 + PlayState.boost;
        position_bg3_1_p.x -= speed_bg3 + PlayState.boost;

        position_bg4.x -= speed_bg4 + PlayState.boost;
        position_bg4_1.x -= speed_bg4 + PlayState.boost;

        position_bg5.x -= speed_bg5 + PlayState.boost;
        position_bg5_1.x -= speed_bg5 + PlayState.boost;

        position_bg6.x -= speed_bg6 + PlayState.boost;
        position_bg6_1.x -= speed_bg6 + PlayState.boost;

        position_bg6_n.x -= speed_bg6 + PlayState.boost;
        position_bg6_1_n.x -= speed_bg6 + PlayState.boost;

        position_bg6_d.x -= speed_bg6 + PlayState.boost;
        position_bg6_1_d.x -= speed_bg6 + PlayState.boost;

        position_bg6_p.x -= speed_bg6 + PlayState.boost;
        position_bg6_1_p.x -= speed_bg6 + PlayState.boost;

        position_bg_snow_1.x -= speed_snow_1 + PlayState.boost;
        position_bg_snow_1_1.x -= speed_snow_1 + PlayState.boost;

        position_bg_snow_1.y -= speed_snow_1;
        position_bg_snow_1_1.y -= speed_snow_1;

        position_bg_snow_1_y.x -= speed_snow_1 + PlayState.boost;
        position_bg_snow_1_1_y.x -= speed_snow_1 + PlayState.boost;

        position_bg_snow_1_y.y -= speed_snow_1;
        position_bg_snow_1_1_y.y -= speed_snow_1;

        position_bg_snow_2.x -= speed_snow_2 + PlayState.boost;
        position_bg_snow_2_1.x -= speed_snow_2 + PlayState.boost;

        position_bg_snow_2.y -= speed_snow_2;
        position_bg_snow_2_1.y -= speed_snow_2;

        position_bg_snow_2_y.x -= speed_snow_2 + PlayState.boost;
        position_bg_snow_2_1_y.x -= speed_snow_2 + PlayState.boost;

        position_bg_snow_2_y.y -= speed_snow_2;
        position_bg_snow_2_1_y.y -= speed_snow_2;



        if (position_bg1.x < -320.0f) {
            position_bg1.x = 0.0f + (position_bg1.x + 320.0f);
        }

        if (position_bg1_1.x < 0.0f) {
            position_bg1_1.x = 320.0f + position_bg1_1.x;
        }

        if (position_bg1_n.x < -320.0f) {
            position_bg1_n.x = 0.0f + (position_bg1_n.x + 320.0f);
        }

        if (position_bg1_1_n.x < 0.0f) {
            position_bg1_1_n.x = 320.0f + position_bg1_1_n.x;
        }

        if (position_bg1_d.x < -320.0f) {
            position_bg1_d.x = 0.0f + (position_bg1_d.x + 320.0f);
        }

        if (position_bg1_1_d.x < 0.0f) {
            position_bg1_1_d.x = 320.0f + position_bg1_1_d.x;
        }

        if (position_bg1_p.x < -320.0f) {
            position_bg1_p.x = 0.0f + (position_bg1_p.x + 320.0f);
        }

        if (position_bg1_1_p.x < 0.0f) {
            position_bg1_1_p.x = 320.0f + position_bg1_1_p.x;
        }

        if (position_bg2.x < -320) {
            position_bg2.x = (position_bg2.x + 320.0f);
        }

        if (position_bg2_1.x < 0) {
            position_bg2_1.x = 320.0f + position_bg2_1.x;
        }

        if (position_bg3.x < -320.0f) {
            position_bg3.x = 0.0f + (position_bg3.x + 320.0f);
        }

        if (position_bg3_1.x < 0.0f) {
            position_bg3_1.x = 320.0f + position_bg3_1.x;
        }

        if (position_bg3_n.x < -320.0f) {
            position_bg3_n.x = 0.0f + (position_bg3_n.x + 320.0f);
        }

        if (position_bg3_1_n.x < 0.0f) {
            position_bg3_1_n.x = 320.0f + position_bg3_1_n.x;
        }

        if (position_bg3_d.x < -320.0f) {
            position_bg3_d.x = 0.0f + (position_bg3_d.x + 320.0f);
        }

        if (position_bg3_1_d.x < 0.0f) {
            position_bg3_1_d.x = 320.0f + position_bg3_1_d.x;
        }

        if (position_bg3_p.x < -320.0f) {
            position_bg3_p.x = 0.0f + (position_bg3_p.x + 320.0f);
        }

        if (position_bg3_1_p.x < 0.0f) {
            position_bg3_1_p.x = 320.0f + position_bg3_1_p.x;
        }

        if (position_bg4.x < -320.0f) {
            position_bg4.x = 0.0f + (position_bg4.x + 320.0f);
        }

        if (position_bg4_1.x < 0.0f) {
            position_bg4_1.x = 320.0f + position_bg4_1.x;
        }

        if (position_bg5.x < -320.0f) {
            position_bg5.x = 0.0f + (position_bg5.x + 320.0f);
        }

        if (position_bg5_1.x < 0.0f) {
            position_bg5_1.x = 320.0f + position_bg5_1.x;
        }

        if (position_bg6.x < -320.0f) {
            position_bg6.x = 0.0f + (position_bg6.x + 320.0f);
        }

        if (position_bg6_1.x < 0.0f) {
            position_bg6_1.x = 320.0f + position_bg6_1.x;
        }

        if (position_bg6_n.x < -320.0f) {
            position_bg6_n.x = 0.0f + (position_bg6_n.x + 320.0f);
        }

        if (position_bg6_1_n.x < 0.0f) {
            position_bg6_1_n.x = 320.0f + position_bg6_1_n.x;
        }

        if (position_bg6_d.x < -320.0f) {
            position_bg6_d.x = 0.0f + (position_bg6_d.x + 320.0f);
        }

        if (position_bg6_1_d.x < 0.0f) {
            position_bg6_1_d.x = 320.0f + position_bg6_1_d.x;
        }

        if (position_bg6_p.x < -320.0f) {
            position_bg6_p.x = 0.0f + (position_bg6_p.x + 320.0f);
        }

        if (position_bg6_1_p.x < 0.0f) {
            position_bg6_1_p.x = 320.0f + position_bg6_1_p.x;
        }

        if (position_bg_snow_1.x < -320.0f) {
            position_bg_snow_1.x = 0.0f + (position_bg_snow_1.x + 320.0f);
        }

        if (position_bg_snow_1_1.x < 0.0f) {
            position_bg_snow_1_1.x = 320.0f + position_bg_snow_1_1.x;
        }

        if (position_bg_snow_1.y < -200.0f) {
            position_bg_snow_1.y = 0.0f + (position_bg_snow_1.y + 200.0f);
        }

        if (position_bg_snow_1_1.y < -200.0f) {
            position_bg_snow_1_1.y = 0.0f + (position_bg_snow_1_1.y + 200.0f);
        }

        if (position_bg_snow_2.x < -320.0f) {
            position_bg_snow_2.x = 0.0f + (position_bg_snow_2.x + 320.0f);
        }

        if (position_bg_snow_2_1.x < 0.0f) {
            position_bg_snow_2_1.x = 320.0f + position_bg_snow_2_1.x;
        }

        if (position_bg_snow_2.y < -200.0f) {
            position_bg_snow_2.y = 0.0f + (position_bg_snow_2.y + 200.0f);
        }

        if (position_bg_snow_2_1.y < -200.0f) {
            position_bg_snow_2_1.y = 0.0f + (position_bg_snow_2_1.y + 200.0f);
        }

        if (position_bg_snow_1_y.y < 0.0f) {
            position_bg_snow_1_y.y = 200.0f + position_bg_snow_1_y.y;
        }

        if (position_bg_snow_1_1_y.y < 0.0f) {
            position_bg_snow_1_1_y.y = 200.0f + position_bg_snow_1_1_y.y;
        }

        if (position_bg_snow_2_y.y < 0.0f) {
            position_bg_snow_2_y.y = 200.0f + position_bg_snow_2_y.y;
        }

        if (position_bg_snow_2_1_y.y < 0.0f) {
            position_bg_snow_2_1_y.y = 200.0f + position_bg_snow_2_1_y.y;
        }

        if (position_bg_snow_1_y.x < -320.0f) {
            position_bg_snow_1_y.x = 0.0f + (position_bg_snow_1_y.x + 320.0f);
        }

        if (position_bg_snow_1_1_y.x < 0.0f) {
            position_bg_snow_1_1_y.x = 320.0f + position_bg_snow_1_1_y.x;
        }

        if (position_bg_snow_2_y.x < -320.0f) {
            position_bg_snow_2_y.x = 0.0f + (position_bg_snow_2_y.x + 320.0f);
        }

        if (position_bg_snow_2_1_y.x < 0.0f) {
            position_bg_snow_2_1_y.x = 320.0f + position_bg_snow_2_1_y.x;
        }

        position_bg1.add(0, 0 , 0);
        position_bg1_1.add(0, 0 , 0);
        position_bg1_n.add(0, 0 , 0);
        position_bg1_1_n.add(0, 0 , 0);
        position_bg1_d.add(0, 0 , 0);
        position_bg1_1_d.add(0, 0 , 0);
        position_bg1_p.add(0, 0 , 0);
        position_bg1_1_p.add(0, 0 , 0);
        position_bg2.add(0, 0 , 0);
        position_bg2_1.add(0, 0 , 0);
        position_bg3.add(0, 0 , 0);
        position_bg3_1.add(0, 0 , 0);
        position_bg3_n.add(0, 0 , 0);
        position_bg3_1_n.add(0, 0 , 0);
        position_bg3_d.add(0, 0 , 0);
        position_bg3_1_d.add(0, 0 , 0);
        position_bg3_p.add(0, 0 , 0);
        position_bg3_1_p.add(0, 0 , 0);
        position_bg4.add(0, 0 , 0);
        position_bg4_1.add(0, 0 , 0);
        position_bg5.add(0, 0 , 0);
        position_bg5_1.add(0, 0 , 0);
        position_bg6.add(0, 0 , 0);
        position_bg6_1.add(0, 0 , 0);
        position_bg6_n.add(0, 0 , 0);
        position_bg6_1_n.add(0, 0 , 0);
        position_bg6_d.add(0, 0 , 0);
        position_bg6_1_d.add(0, 0 , 0);
        position_bg6_p.add(0, 0 , 0);
        position_bg6_1_p.add(0, 0 , 0);
        position_bg_snow_1.add(0, 0 , 0);
        position_bg_snow_1_1.add(0, 0 , 0);
        position_bg_snow_1_y.add(0, 0 , 0);
        position_bg_snow_1_1_y.add(0, 0 , 0);
        position_bg_snow_2.add(0, 0 , 0);
        position_bg_snow_2_1.add(0, 0 , 0);
        position_bg_snow_2_y.add(0, 0 , 0);
        position_bg_snow_2_1_y.add(0, 0 , 0);
    }


}
