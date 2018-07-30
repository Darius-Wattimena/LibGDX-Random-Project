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

    public void setup(int width, int height) {
        blockRenderer = new BlockRenderer();
        blockRenderer.setup();
        blockMap = blockRenderer.getMap();
        widthTotalBlocks = (int) Math.ceil(width / Constants.BLOCK_SIZE);
        heightTotalBlocks = (int) Math.ceil(height / Constants.BLOCK_SIZE);
    }

    public void handleInput() {
        boolean isAPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        boolean isWPressed = Gdx.input.isKeyPressed(Input.Keys.W);
        boolean isDPressed = Gdx.input.isKeyPressed(Input.Keys.D);
        boolean isSPressed = Gdx.input.isKeyPressed(Input.Keys.S);

        if (!(isWPressed && isSPressed) && isWPressed || isSPressed) {
            if (isWPressed) {
                moveScreen(Input.Keys.W);
            } else {
                moveScreen(Input.Keys.S);
            }
        }

        if (!(isAPressed && isDPressed) && isAPressed || isDPressed) {
            if (isAPressed) {
                moveScreen(Input.Keys.A);
            } else {
                moveScreen(Input.Keys.D);
            }
        }
    }

    private void moveScreen(int keySide) {
        switch (keySide) {
            case Input.Keys.A:
                if (x != 0)
                    x -= 1;
                break;
            case Input.Keys.D:
                if (!(widthTotalBlocks + x >= blockMap.getMapWidth())) {
                    x += 1;
                }
                break;
            case Input.Keys.W:
                if (!(heightTotalBlocks + y >= blockMap.getMapHeight())) {
                    y += 1;
                }
                break;
            case Input.Keys.S:
                if (y != 0)
                    y -= 1;
                break;
        }
    }

    public void render(Stage stage) {
        blockRenderer.render(x, y, x + widthTotalBlocks, y + heightTotalBlocks, stage);
    }


}
