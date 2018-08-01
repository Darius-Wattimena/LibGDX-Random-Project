package nl.antimeta.game.Textures;

import nl.antimeta.game.Blocks.BlockHelper.BlockBase;
import nl.antimeta.game.Blocks.BlockHelper.BlockConfig;
import nl.antimeta.game.Blocks.BlockHelper.BlockLocation;
import nl.antimeta.game.Constants;

public class GrassFlowersRed extends BlockBase {

    private static final int ID = 6;
    public static final BlockConfig config = new BlockConfig(ID, Constants.BLOCK_TYPE_PLAIN, Constants.BLOCK_SIZE);

    public GrassFlowersRed(BlockLocation location) {
        super(config, location, "grass-flower-red.png");
    }
}
