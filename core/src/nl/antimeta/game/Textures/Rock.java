package nl.antimeta.game.Textures;

import nl.antimeta.game.Blocks.BlockHelper.BlockBase;
import nl.antimeta.game.Blocks.BlockHelper.BlockConfig;
import nl.antimeta.game.Blocks.BlockHelper.BlockLocation;
import nl.antimeta.game.Constants;

public class Rock extends BlockBase {

    private static final int ID = 4;
    public static final BlockConfig config = new BlockConfig(ID, Constants.BLOCK_TYPE_MOUNTAIN, Constants.BLOCK_SIZE);

    public Rock(BlockLocation location, String textureFile) {
        super(config, location, textureFile);
    }
}
