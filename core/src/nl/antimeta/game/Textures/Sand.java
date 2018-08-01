package nl.antimeta.game.Textures;

import nl.antimeta.game.Blocks.BlockHelper.BlockBase;
import nl.antimeta.game.Blocks.BlockHelper.BlockConfig;
import nl.antimeta.game.Blocks.BlockHelper.BlockLocation;
import nl.antimeta.game.Constants;

public class Sand extends BlockBase {

    private static final int ID = 3;
    public static final BlockConfig config = new BlockConfig(ID, Constants.BLOCK_TYPE_BEACH, Constants.BLOCK_SIZE);

    public Sand(BlockLocation location) {
        super(config, location, "sand.png");
    }
}
