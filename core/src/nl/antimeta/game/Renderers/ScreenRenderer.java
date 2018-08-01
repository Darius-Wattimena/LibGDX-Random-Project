package nl.antimeta.game.Renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import nl.antimeta.game.Blocks.Map.BlockMap;
import nl.antimeta.game.Constants;

public class ScreenRenderer {

    private BlockRenderer blockRenderer;
    private BlockMap blockMap;
    private int widthTotalBlocks;
    private int heightTotalBlocks;
    private int x, y;
    private double mapZoomLevel = 1.0;
    private double mapZoomLevelIncrease = 0.03125;
    private int mapMovementSpeed = 1;
    private int screenWidth;
    private int screenHeight;

    public void setup(int screenWidth, int screenHeight) {
        blockRenderer = new BlockRenderer();
        blockRenderer.setup();
        blockMap = blockRenderer.getMap();
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        calculateTotalBlocks();
    }

    private void calculateTotalBlocks() {
        widthTotalBlocks = (int) Math.ceil(screenWidth / (Constants.BLOCK_SIZE * mapZoomLevel));
        heightTotalBlocks = (int) Math.ceil(screenHeight / (Constants.BLOCK_SIZE * mapZoomLevel));
    }

    public void handleInput() {
        boolean isAPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean isWPressed = Gdx.input.isKeyPressed(Input.Keys.W);
        boolean isDPressed = Gdx.input.isKeyPressed(Input.Keys.D);
        boolean isSPressed = Gdx.input.isKeyPressed(Input.Keys.S);
        boolean isRPressed = Gdx.input.isKeyPressed(Input.Keys.R);
        boolean isPlusPressed = Gdx.input.isKeyPressed(Input.Keys.P);
        boolean isMinusPressed = Gdx.input.isKeyPressed(Input.Keys.M);

        if (isRPressed) {
            blockRenderer.renewMap();
        }

        handleZoom(isPlusPressed, isMinusPressed);
        handleMapMovement(isWPressed, isSPressed, isAPressed, isDPressed);
    }

    private void handleMapMovement(boolean wPressed, boolean sPressed, boolean aPressed, boolean dPressed) {
        if (!(wPressed && sPressed) && wPressed || sPressed) {
            if (wPressed) {
                moveScreen(Input.Keys.W);
            } else {
                moveScreen(Input.Keys.S);
            }
        }

        if (!(aPressed && dPressed) && aPressed || dPressed) {
            if (aPressed) {
                moveScreen(Input.Keys.A);
            } else {
                moveScreen(Input.Keys.D);
            }
        }
    }

    private void handleZoom(boolean plusPressed, boolean minusPressed) {
        if (!(plusPressed && minusPressed) && plusPressed || minusPressed) {
            if (plusPressed) {
                if (mapZoomLevel != 1.0) {
                    mapZoomLevel += mapZoomLevelIncrease;
                    calculateTotalBlocks();
                }
            } else {
                if (mapZoomLevel != 0.25) {
                    mapZoomLevel -= mapZoomLevelIncrease;
                    calculateTotalBlocks();
                }
            }
        }
    }

    private void moveScreen(int keySide) {
        switch (keySide) {
            case Input.Keys.A:
                if (x != 0)
                    x -= mapMovementSpeed;
                break;
            case Input.Keys.D:
                if (!(widthTotalBlocks + x >= blockMap.getMapWidth())) {
                    x += mapMovementSpeed;
                }
                break;
            case Input.Keys.W:
                if (!(heightTotalBlocks + y >= blockMap.getMapHeight())) {
                    y += mapMovementSpeed;
                }
                break;
            case Input.Keys.S:
                if (y != 0)
                    y -= mapMovementSpeed;
                break;
        }
    }

    public void render(Stage stage) {
        blockRenderer.render(x, y, x + widthTotalBlocks, y + heightTotalBlocks, stage, mapZoomLevel);
    }


}
