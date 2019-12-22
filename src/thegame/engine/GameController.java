package thegame.engine;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import thegame.character.tower.MachineGunTower;
import thegame.character.tower.NormalTower;
import thegame.character.tower.SniperTower;
import thegame.character.tower.Tower;
import thegame.config.Config;
import thegame.tilemap.TileMap;

import javax.crypto.Mac;
import java.lang.reflect.Constructor;

public class GameController {
    @FXML
    private Label currentLives;

    @FXML
    private Label currentResources;

    @FXML
    private Label currentWave;

    @FXML
    private Label waveDelay;

    @FXML
    private Label waveDelayInSecond;

    @FXML
    private ImageView normalTowerBuildView;

    @FXML
    private ImageView machineGunTowerBuildView;

    @FXML
    private ImageView sniperTowerBuildView;

    public void init(GameField gameField, Pane towerLayer, Pane dragLayer, TileMap tileMap) {
        setUpEventHandlers(normalTowerBuildView, "NormalTower",
                gameField, towerLayer, dragLayer, tileMap, 35);
        setUpEventHandlers(machineGunTowerBuildView, "MachineGunTower",
                gameField, towerLayer, dragLayer, tileMap, 110);
        setUpEventHandlers(sniperTowerBuildView, "SniperTower",
                gameField, towerLayer, dragLayer, tileMap, 185);
    }

    private void setUpEventHandlers(ImageView view, String towerType, GameField gameField,
                                    Pane towerLayer, Pane dragLayer, TileMap map, int towerOffset) {
        ImageView dragView = new ImageView(view.getImage());
        dragView.setOpacity(0.5);
        dragLayer.getChildren().add(dragView);
        dragView.setVisible(false);
        view.setOnDragDetected(e -> dragView.setVisible(true));
        view.setOnMouseDragged(e -> {
            int mapX = ((int)e.getX() + towerOffset + Config.UI_OFFSET_X) / Config.TILE_SIZE + 1;
            int mapY = ((int)e.getY() + Config.UI_OFFSET_Y) / Config.TILE_SIZE + 1;
            mapX = Math.max(mapX, 1);
            mapX = Math.min(mapX, Config.TILE_HORIZONTAL);
            mapY = Math.max(mapY, 1);
            mapY = Math.min(mapY, Config.TILE_VERTICAL);
            dragView.setX((mapX - 1) * Config.TILE_SIZE);
            dragView.setY((mapY - 1) * Config.TILE_SIZE - 17);
        });
        view.setOnMouseReleased(e -> {
            dragView.setVisible(false);
            int mapY = ((int)e.getX() + towerOffset + Config.UI_OFFSET_X) / Config.TILE_SIZE + 1;
            int mapX = ((int)e.getY() + Config.UI_OFFSET_Y) / Config.TILE_SIZE + 1;
            if (map.isBuildABle(mapX, mapY)) {
                map.setOccupied(mapX, mapY);
                switch (towerType) {
                    case "NormalTower":
                        if (gameField.getResources() >= NormalTower.COST) {
                            NormalTower normalTower = new NormalTower((mapY - 1) * Config.TILE_SIZE, (mapX - 1) * Config.TILE_SIZE);
                            gameField.addTower(normalTower);
                            gameField.addResource(-NormalTower.COST);
                            towerLayer.getChildren().addAll(normalTower.getView());
                        }
                        break;
                    case "MachineGunTower":
                        if (gameField.getResources() >= MachineGunTower.COST) {
                            MachineGunTower machineGunTower = new MachineGunTower((mapY - 1) * Config.TILE_SIZE, (mapX - 1) * Config.TILE_SIZE);
                            gameField.addTower(machineGunTower);
                            gameField.addResource(-MachineGunTower.COST);
                            towerLayer.getChildren().addAll(machineGunTower.getView());
                        }
                        break;
                    case "SniperTower":
                        if (gameField.getResources() >= SniperTower.COST) {
                            SniperTower sniperTower = new SniperTower((mapY - 1) * Config.TILE_SIZE, (mapX - 1) * Config.TILE_SIZE);
                            gameField.addTower(sniperTower);
                            gameField.addResource(-SniperTower.COST);
                            towerLayer.getChildren().addAll(sniperTower.getView());
                        }
                        break;
                }
            }
            this.currentResources.setText(Integer.toString(gameField.getResources()));
        });
    }

    public void updateLabels(String currentWave, String currentLives, String currentResources, boolean isDelayed, String delay){
        this.currentLives.setText(currentLives);
        this.currentResources.setText(currentResources);
        this.currentWave.setText(currentWave);
        if (isDelayed) this.waveDelayInSecond.setText(delay);
        this.waveDelay.setVisible(isDelayed);
        this.waveDelayInSecond.setVisible(isDelayed);
    }
}
