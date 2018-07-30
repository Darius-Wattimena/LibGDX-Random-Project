package nl.antimeta.game.Blocks.Map;

import nl.antimeta.game.Rng;
import nl.antimeta.game.Blocks.BlockHelper.BlockList;

import java.util.List;

class BlockMapGenerator {

    private BlockMapTypeGenerator typeGenerator;
    private int[][] mapTypeArray;
    private int[][] mapArray;
    private BlockList list;

    BlockMapGenerator(BlockMapTypeGenerator typeGenerator, BlockList list) {
        this.typeGenerator = typeGenerator;
        this.list = list;
        mapTypeArray = typeGenerator.getBlockTypeArray();
        mapArray = new int[typeGenerator.getTotalBlocksWidth()][typeGenerator.getTotalBlocksHeight()];
        generateMap();
    }

    private void generateMap() {
        boolean first = true;
        for (int x = 0; x < typeGenerator.getTotalBlocksWidth(); x++) {
            for (int y = 0; y < typeGenerator.getTotalBlocksHeight(); y++) {
                int blockType = mapTypeArray[x][y];
                List<Integer> possibleBlockIds = list.getBlocksByType(blockType);
                int blockId;

                if (first) {
                    first = false;
                    int randomIndex = Rng.nextInt(possibleBlockIds.size());
                    blockId = possibleBlockIds.get(randomIndex);
                } else {
                    int percentage = Rng.nextInt(100);
                    int leftBlockId = getLeftBlock(x, y);
                    int belowBlockId = getBelowBlock(x, y);

                    blockId = decideNewBlockId(percentage, possibleBlockIds, leftBlockId, belowBlockId);
                }

                mapArray[x][y] = blockId;
            }
        }
    }

    private int getLeftBlock(int currentX, int currentY) {
        if (currentX != 0) {
            return mapArray[currentX - 1][currentY];
        }
        return -1;
    }

    private int getBelowBlock(int currentX, int currentY) {
        if (currentY != 0) {
            return mapArray[currentX][currentY - 1];
        }
        return -1;
    }

    private int decideNewBlockId(int percentage, List<Integer> ids, int leftBlockId, int belowBlockId) {
        if (percentage < 70) {
            if (leftBlockId != -1) {
                return leftBlockId;
            } else if (belowBlockId != -1) {
                return belowBlockId;
            }
        }
        int randomIndex = Rng.nextInt(ids.size());
        return ids.get(randomIndex);
    }

    int[][] getMapArray() {
        return mapArray;
    }
}
