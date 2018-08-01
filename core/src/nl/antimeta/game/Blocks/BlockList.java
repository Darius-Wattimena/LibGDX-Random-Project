package nl.antimeta.game.Blocks;

import nl.antimeta.game.Blocks.BlockHelper.BlockBase;
import nl.antimeta.game.Blocks.BlockHelper.BlockHashMap;
import nl.antimeta.game.Textures.*;

import java.util.List;

public class BlockList {
    private BlockHashMap<Class<? extends BlockBase>> blockHashMap = new BlockHashMap<>();

    public BlockList() {
        blockHashMap.put(Grass.config.getTypeId(), Grass.class);
        blockHashMap.put(Water.config.getTypeId(), Water.class);
        blockHashMap.put(Sand.config.getTypeId(), Sand.class);
        //blockHashMap.put(Sand2.config.getTypeId(), Sand2.class); TODO needs new texture
        blockHashMap.put(GrassFlowersRed.config.getTypeId(), GrassFlowersRed.class);
        blockHashMap.put(WaterLow.config.getTypeId(), WaterLow.class);
    }

    public Class<? extends BlockBase> getBlockClass(int id) {
        return blockHashMap.getById(id);
    }

    public List<Integer> getBlocksByType(int type) {
        return blockHashMap.getIdsByType(type);
    }
}
