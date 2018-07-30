package nl.antimeta.game.Blocks.BlockHelper;

import nl.antimeta.game.Textures.Grass;
import nl.antimeta.game.Textures.Water;

import java.util.List;

public class BlockList {
    private BlockHashMap<Class<? extends BlockBase>> blockHashMap = new BlockHashMap<>();

    public BlockList() {
        blockHashMap.put(Grass.config.getTypeId(), Grass.class);
        blockHashMap.put(Water.config.getTypeId(), Water.class);
    }

    public Class<? extends BlockBase> getBlockClass(int id) {
        return blockHashMap.getById(id);
    }

    public List<Integer> getBlocksByType(int type) {
        return blockHashMap.getIdsByType(type);
    }
}
