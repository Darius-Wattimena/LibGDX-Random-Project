package nl.antimeta.game.Blocks.BlockHelper;

import com.badlogic.gdx.graphics.Texture;

public class BlockConfig {

    private BlockTypeId typeId;
    private int width;
    private int height;

    private Texture texture;

    public BlockConfig(int id, int type, int size) {
        this.typeId = new BlockTypeId(id, type);
        this.width = size;
        this.height = size;
    }

    public BlockConfig(int id, int type, int width, int height) {
        this.typeId = new BlockTypeId(id, type);
        this.width = width;
        this.height = height;
    }

    public BlockTypeId getTypeId() {
        return typeId;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
