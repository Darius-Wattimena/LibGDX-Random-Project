package nl.antimeta.game.Textures;

import nl.antimeta.game.Blocks.BlockHelper.BlockBase;
import nl.antimeta.game.Blocks.BlockHelper.BlockConfig;
import nl.antimeta.game.Blocks.BlockHelper.BlockLocation;
import nl.antimeta.game.Constants;

public class WaterLow extends BlockBase {

    private static final int ID = 7;
    public static final BlockConfig config = new BlockConfig(ID, Constants.BLOCK_TYPE_LOW_SEA, Constants.BLOCK_SIZE);

    public WaterLow(BlockLocation location) {
        super(config, location, "water-low.png");
    }
}
