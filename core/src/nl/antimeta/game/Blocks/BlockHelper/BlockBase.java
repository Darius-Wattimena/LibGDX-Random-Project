package nl.antimeta.game.Blocks.BlockHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class BlockBase extends Actor {

    private BlockConfig config;
    private BlockLocation location;
    private Texture texture;
    private double currentZoomLevel = 1.0;

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

        int x = (int) (location.getScreenX() * currentZoomLevel);
        int y = (int) (location.getScreenY() * currentZoomLevel);
        int width = (int) (config.getWidth() * currentZoomLevel);
        int height = (int) (config.getHeight() * currentZoomLevel);

        batch.draw(texture, x, y, width, height);
    }

    public void setCurrentZoomLevel(double currentZoomLevel) {
        this.currentZoomLevel = currentZoomLevel;
    }
}
