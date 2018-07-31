package nl.antimeta.game.Blocks.Map;

import nl.antimeta.game.Blocks.BlockHelper.BlockList;

public class BlockMap {

    private int[][] mapArray;
    private int mapWidth;
    private int mapHeight;

    public BlockMap(BlockList list, int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        BlockMapTypeGenerator mapTypeGenerator = new BlockMapTypeGenerator(mapWidth, mapHeight);
        BlockMapGenerator mapGenerator = new BlockMapGenerator(mapTypeGenerator, list);
        mapArray = mapGenerator.getMapArray();
    }

    public void generateNew(BlockList list) {
        BlockMapTypeGenerator mapTypeGenerator = new BlockMapTypeGenerator(mapWidth, mapHeight);
        BlockMapGenerator mapGenerator = new BlockMapGenerator(mapTypeGenerator, list);
        mapArray = mapGenerator.getMapArray();
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getBlockId(int x, int y) {
        return mapArray[x][y];
    }


}
