package nl.antimeta.game.Blocks.Map;

import nl.antimeta.game.Constants;
import nl.antimeta.game.Rng;

class BlockMapTypeGenerator {

    private int[][] blockTypeArray;
    private int totalBlocksWidth;
    private int totalBlocksHeight;

    BlockMapTypeGenerator(int totalBlocksWidth, int totalBlocksHeight) {
        this.blockTypeArray = new int[totalBlocksWidth][totalBlocksHeight];
        this.totalBlocksWidth = totalBlocksWidth;
        this.totalBlocksHeight = totalBlocksHeight;
        generateTypeMap();
    }

    private void generateTypeMap() {
        boolean first = true;
        for (int x = 0; x < totalBlocksWidth; x++) {
            for (int y = 0; y < totalBlocksHeight; y++) {
                if (first) {
                    first = false;
                    blockTypeArray[x][y] = Rng.randInt(Constants.BLOCK_TYPE_PLAIN, Constants.BLOCK_TYPE_SEA);
                }
                else {
                    int blockLeftType = getLeftBlockType(x, y);
                    int blockBelowType = getBelowBlockType(x, y);

                    int blockType = calculateNewBlockType(blockLeftType, blockBelowType);
                    blockTypeArray[x][y] = blockType;
                }
            }
        }
    }

    int[][] getBlockTypeArray() {
        return blockTypeArray;
    }

    private int calculateNewBlockType(int leftBlockType, int belowBlockType) {
        int randomBlockTypeChance = Rng.nextInt(100);
        int newBlockType = -1;

        if (leftBlockType != -1 && belowBlockType != -1 && leftBlockType == belowBlockType) {
            if (randomBlockTypeChance < 80) {
                newBlockType = leftBlockType;
            }
        } else if (leftBlockType != -1 && belowBlockType != -1) {
            if (randomBlockTypeChance < 45) {
                newBlockType = leftBlockType;
            } else if (randomBlockTypeChance < 90) {
                newBlockType = belowBlockType;
            }
        } else if (leftBlockType != -1) {
            if (randomBlockTypeChance < 60) {
                newBlockType = leftBlockType;
            }
        } else if (belowBlockType != -1) {
            if (randomBlockTypeChance < 60) {
                newBlockType = belowBlockType;
            }
        }

        if (newBlockType == -1) {
            newBlockType = getRandomBlockType();
        }

        return newBlockType;
    }

    private int getRandomBlockType() {
        return Rng.randInt(Constants.BLOCK_TYPE_PLAIN, Constants.BLOCK_TYPE_SEA);
    }

    private int getLeftBlockType(int currentX, int currentY) {
        if (currentX != 0) {
            return blockTypeArray[currentX - 1][currentY];
        }
        return -1;
    }

    private int getBelowBlockType(int currentX, int currentY) {
        if (currentY != 0) {
            return blockTypeArray[currentX][currentY - 1];
        }
        return -1;
    }

    int getTotalBlocksWidth() {
        return totalBlocksWidth;
    }

    int getTotalBlocksHeight() {
        return totalBlocksHeight;
    }
}