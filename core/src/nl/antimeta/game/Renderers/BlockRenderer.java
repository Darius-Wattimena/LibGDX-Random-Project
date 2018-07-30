package nl.antimeta.game.Renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import nl.antimeta.game.Blocks.BlockHelper.BlockBase;
import nl.antimeta.game.Blocks.BlockHelper.BlockList;
import nl.antimeta.game.Blocks.BlockHelper.BlockLocation;
import nl.antimeta.game.Blocks.Map.BlockMap;
import nl.antimeta.game.Constants;

public class BlockRenderer {

    private BlockMap map;
    private BlockList list;
    private BlockBase[][] blocks;

    public BlockRenderer() {
        int mapWidth = 150;
        int mapHeight = 100;

        list = new BlockList();
        map = new BlockMap(list, mapWidth, mapHeight);
        blocks = new BlockBase[mapWidth][mapHeight];
    }

    public void setup() {
        for (int x = 0; x < map.getMapWidth(); x++) {
            for (int y = 0; y < map.getMapHeight(); y++) {
                int id = map.getBlockId(x, y);

                int realX = x * Constants.BLOCK_SIZE;
                int realY = y * Constants.BLOCK_SIZE;
                BlockLocation location = new BlockLocation(realX, realY);
                try {
                    Class<?> blockClass = list.getBlockClass(id);
                    if (blockClass != null) {
                        blocks[x][y] = (BlockBase) blockClass.getDeclaredConstructor(BlockLocation.class).newInstance(location);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void render(int screenX, int screenY, int screenWidth, int screenHeight, Stage stage) {
        stage.clear();
        int realScreenX = 0;
        int realScreenY;
        for (int x = screenX; x < screenWidth; x++) {
            realScreenY = 0;
            for (int y = screenY; y < screenHeight; y++) {
                try {
                    BlockBase block = blocks[x][y];
                    BlockLocation location = block.getLocation();
                    location.setScreenX(realScreenX * Constants.BLOCK_SIZE);
                    location.setScreenY(realScreenY * Constants.BLOCK_SIZE);

                    stage.addActor(block);
                } catch(ArrayIndexOutOfBoundsException exception) {
                    Gdx.app.error("ArrayIndexOutOfBoundsException", exception.getMessage());
                }
                realScreenY++;
            }
            realScreenX++;
        }
    }

    public BlockMap getMap() {
        return map;
    }
}
