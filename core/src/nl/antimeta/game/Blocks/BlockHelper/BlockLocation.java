package nl.antimeta.game.Blocks.BlockHelper;

public class BlockLocation {

    private int x;
    private int y;

    private int screenX;
    private int screenY;

    public BlockLocation(int x, int y) {
        this.x = x;
        this.y = y;
        this.screenX = x;
        this.screenY = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScreenX() {
        return screenX;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }
}
