package nl.antimeta.game.Textures;

import nl.antimeta.game.Constants;
import nl.antimeta.game.Blocks.BlockHelper.BlockBase;
import nl.antimeta.game.Blocks.BlockHelper.BlockConfig;
import nl.antimeta.game.Blocks.BlockHelper.BlockLocation;

public class Grass extends BlockBase {

    private static final int ID = 1;
    public static final BlockConfig config = new BlockConfig(ID, Constants.BLOCK_TYPE_PLAIN, Constants.BLOCK_SIZE);

    public Grass(BlockLocation location) {
        super(config, location, "grass.png");
    }
}
