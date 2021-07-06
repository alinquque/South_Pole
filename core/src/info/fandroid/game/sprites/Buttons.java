package info.fandroid.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class Buttons {

    private Vector3 positionhome;
    private Vector3 positionrefresh;

    public static Texture home;
    public static Texture refresh;

    public static Rectangle boundshome;
    public static Rectangle boundsrefresh;

    public float currentFrameTime;
    public float maxFrameTime = 0.25f;

    Random random = new Random();


    public Buttons(){
        positionhome = new Vector3(10, 10, 0);
        positionrefresh = new Vector3(278, 10, 0);

        home = new Texture("home.png");
        refresh = new Texture("refresh.png");

        boundshome = new Rectangle(10, 10, home.getWidth(), home.getHeight());
        boundsrefresh = new Rectangle(278, 10, refresh.getWidth(), refresh.getHeight());
    }

    public Vector3 getPositionhome() {
        return positionhome;
    }

    public Vector3 getPositionrefresh() {
        return positionrefresh;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime >= maxFrameTime) {

            /*
            float dHomeX = random.nextInt(2);
            float dHomeY = random.nextInt(2);

            float dRefreshX = random.nextInt(2);
            float dRefreshY = random.nextInt(2);

            int signHomeX = random.nextInt(2);
            int signRefreshX = random.nextInt(2);

            int signHomeY = random.nextInt(2);
            int signRefreshY = random.nextInt(2);

            if (signHomeX == 0) {
                //"+"
                if (positionhome.x + dHomeX <= 12) {
                    positionhome.x += dHomeX;
                }
            } else if (signHomeX == 1) {
                //"-"
                if (positionhome.x - dHomeX >= 8) {
                    positionhome.x -= dHomeX;
                }
            }

            if (signHomeY == 0) {
                //"+"
                if (positionhome.y + dHomeY <= 12) {
                    positionhome.y += dHomeY;
                }
            } else if (signHomeY == 1) {
                //"-"
                if (positionhome.y - dHomeY >= 8) {
                    positionhome.y -= dHomeY;
                }
            }


            if (signRefreshX == 0) {
                //"+"
                if (positionrefresh.x + dRefreshX <= 280) {
                    positionrefresh.x += dRefreshX;
                }
            } else if (signRefreshX == 1) {
                //"-"
                if (positionrefresh.x - dRefreshX >= 276) {
                    positionrefresh.x -= dRefreshX;
                }

            }


            if (signRefreshY == 0) {
                //"+"
                if (positionrefresh.y + dRefreshY <= 12) {
                    positionrefresh.y += dRefreshY;
                }
            } else if (signRefreshY == 1) {
                //"-"
                if (positionrefresh.y - dRefreshY >= 8) {
                    positionrefresh.y -= dRefreshY;
                }
            }

             */
            currentFrameTime = 0.0f;
        }


        boundshome.setPosition(positionhome.x, positionhome.y);
        boundsrefresh.setPosition(positionrefresh.x, positionrefresh.y);

    }

    public void dispose(){
        home.dispose();
        refresh.dispose();
    }

}
