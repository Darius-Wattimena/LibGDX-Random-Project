package nl.antimeta.game.Blocks.BlockHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlockHashMap<T> extends HashMap<BlockTypeId, T> {

    @Override
    public T put(BlockTypeId key, T value) {
        return super.put(key, value);
    }

    public T getById(int id) {
        for (BlockTypeId key : keySet()) {
            if (key.getId() == id) {
                return get(key);
            }
        }
        return null;
    }

    public List<T> getByType(int type) {
        List<T> result = new ArrayList<>();
        for (BlockTypeId key : keySet()) {
            if (key.getType() == type) {
                T item = get(key);
                result.add(item);
            }
        }
        return result;
    }

    public List<Integer> getIdsByType(int type) {
        List<Integer> result = new ArrayList<>();
        for (BlockTypeId key : keySet()) {
            if (key.getType() == type) {
                result.add(key.getId());
            }
        }
        return result;
    }
}
