package thegame.character.tower;

import javafx.scene.paint.Color;

/**
 * average stats
 */
public class NormalTower extends Tower{
    private static final int RANGE = 200;
    private static final int DAMAGE = 40;
    private static final double SPEED = 0.8;
    private static final int PROJECTILE_SIZE = 5;
    private static final Color PROJECTILE_COLOR = Color.GREEN;
    private final static double PROJECTILE_SPEED = 8;
    private static final int CENTER_X = 0;
    private static final int CENTER_Y = -11;
    private static final int ROTATE_RADIUS = 44;
    public static final int COST = 100;
    private static final String PATH = "src/thegame/res/asset/tower/normalTower.png";
    private static final String SOUND_EFFECT = "/thegame/res/sound/normalTowerEffect.mp3";

    public NormalTower(int x, int y) {
        super(RANGE, DAMAGE, SPEED, COST, x, y, CENTER_X, CENTER_Y, PROJECTILE_SIZE, PROJECTILE_COLOR, PROJECTILE_SPEED,
                ROTATE_RADIUS, PATH, SOUND_EFFECT);
    }
}
