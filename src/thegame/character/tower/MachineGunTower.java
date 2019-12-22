package thegame.character.tower;

import javafx.scene.paint.Color;

/**
 * low range, average damage output, high speed
 */
public class MachineGunTower extends Tower{
    private static final int RANGE = 160;
    private static final int DAMAGE = 50;
    private static final double SPEED = 1.0;
    private static final int PROJECTILE_SIZE = 5;
    private static final Color PROJECTILE_COLOR = Color.RED;
    private final static double PROJECTILE_SPEED = 8;
    private static final int CENTER_X = 0;
    private static final int CENTER_Y = -12;
    private static final int ROTATE_RADIUS = 44;
    public static final int COST = 140;
    private static final String PATH = "src/thegame/res/asset/tower/machineGunTower.png";
    private static final String SOUND_EFFECT = "/thegame/res/sound/machineTowerEffect.mp3";

    public MachineGunTower(int x, int y) {
        super(RANGE, DAMAGE, SPEED, COST, x, y, CENTER_X, CENTER_Y, PROJECTILE_SIZE, PROJECTILE_COLOR, PROJECTILE_SPEED,
                ROTATE_RADIUS, PATH, SOUND_EFFECT);
    }
}
