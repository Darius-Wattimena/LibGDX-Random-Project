package nl.antimeta.game.Blocks.Map;

import com.badlogic.gdx.Gdx;
import nl.antimeta.game.Constants;
import nl.antimeta.game.Rng;

class BlockMapTypeGenerator {

    private int[][] blockTypeArray;
    private double[][] blockHeightArray;
    private int totalBlocksWidth;
    private int totalBlocksHeight;

    BlockMapTypeGenerator(int totalBlocksWidth, int totalBlocksHeight) {
        this.blockTypeArray = new int[totalBlocksWidth][totalBlocksHeight];
        this.blockHeightArray = new double[totalBlocksWidth][totalBlocksHeight];
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
                    double startHeight = 0.0;
                    blockHeightArray[x][y] = startHeight;
                    blockTypeArray[x][y] = calculateNewBlockType(startHeight);
                }
                else {
                    double blockLeftHeight = getLeftBlockHeigth(x, y);
                    double blockBelowHeight = getBelowBlockHeigth(x, y);
                    double newBlockHeight = calculateNewBlockHeight(blockLeftHeight, blockBelowHeight);
                    int blockType = calculateNewBlockType(newBlockHeight);
                    blockHeightArray[x][y] = newBlockHeight;
                    blockTypeArray[x][y] = blockType;
                }
            }
        }
    }

    private double calculateNewBlockHeight(double blockLeftHeight, double blockBelowHeight) {
        double increaseChance = Rng.randDouble(0, 1);
        double blocksAverageHeight = 0.0;
        double newBlockHeight;
        double randomIncrease;

        if (blockLeftHeight != -1 && blockBelowHeight != -1) {
            blocksAverageHeight = (blockLeftHeight + blockBelowHeight) / 2;
        } else if (blockLeftHeight != -1) {
            blocksAverageHeight = blockLeftHeight;
        } else if (blockBelowHeight != -1) {
            blocksAverageHeight = blockBelowHeight;
        }

        if (increaseChance < 0.45) {
            if (blocksAverageHeight < 0.1) {
                newBlockHeight = 0.0;
            } else {
                double randomDecrease = Rng.randDouble(0.05, 0.1);
                newBlockHeight = blocksAverageHeight - randomDecrease;
            }
        } else if (increaseChance < 0.55) {
            randomIncrease = Rng.randDouble(-0.05, 0.05);
            newBlockHeight = blocksAverageHeight + randomIncrease;
        } else {
            randomIncrease = Rng.randDouble(0.05, 0.1);
            newBlockHeight = blocksAverageHeight + randomIncrease;
            if (newBlockHeight > 1.0) {
                newBlockHeight = 1.0;
            }
        }

        return newBlockHeight;
    }

    int[][] getBlockTypeArray() {
        return blockTypeArray;
    }

    private int calculateNewBlockType(double blockHeight) {
        if (blockHeight > 0.5) {
            return Constants.BLOCK_TYPE_PLAIN;
        } else {
            return Constants.BLOCK_TYPE_SEA;
        }
    }

    private int getRandomBlockType() {
        return Rng.randInt(Constants.BLOCK_TYPE_PLAIN, Constants.BLOCK_TYPE_SEA);
    }

    private double getLeftBlockHeigth(int currentX, int currentY) {
        if (currentX != 0) {
            return blockHeightArray[currentX - 1][currentY];
        }
        return -1;
    }

    private double getBelowBlockHeigth(int currentX, int currentY) {
        if (currentY != 0) {
            return blockHeightArray[currentX][currentY - 1];
        }
        return -1;
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