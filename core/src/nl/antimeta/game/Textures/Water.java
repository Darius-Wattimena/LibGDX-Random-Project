package nl.antimeta.game.Textures;

import nl.antimeta.game.Constants;
import nl.antimeta.game.Blocks.BlockHelper.BlockBase;
import nl.antimeta.game.Blocks.BlockHelper.BlockConfig;
import nl.antimeta.game.Blocks.BlockHelper.BlockLocation;

public class Water extends BlockBase {

    private static final int ID = 2;

    public static final BlockConfig config = new BlockConfig(ID, Constants.BLOCK_TYPE_SEA, Constants.BLOCK_SIZE);

    public Water(BlockLocation location) {
        super(config, location, "water.png");
    }
}
