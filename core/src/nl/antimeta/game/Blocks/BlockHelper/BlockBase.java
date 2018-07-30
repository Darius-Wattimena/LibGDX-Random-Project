package nl.antimeta.game.Blocks.BlockHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class BlockBase extends Actor {

    private BlockConfig config;
    private BlockLocation location;
    private Texture texture;

    public BlockBase(BlockConfig config, BlockLocation location, String textureFile) {
        this.config = config;
        this.location = location;

        texture = new Texture(Gdx.files.internal(textureFile));
        config.setTexture(texture);
    }

    public BlockConfig getConfig() {
        return config;
    }

    public BlockLocation getLocation() {
        return location;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.end();
        batch.begin();
        batch.draw(texture, location.getScreenX(), location.getScreenY());
    }
}
