package nl.antimeta.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import nl.antimeta.game.Renderers.BlockRenderer;
import nl.antimeta.game.Renderers.ScreenRenderer;

public class GameScreen implements Screen {

    private Stage stage;
    private Game game;

    private ScreenRenderer screenRenderer;

    public GameScreen(Game game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());

        this.screenRenderer = new ScreenRenderer();
        screenRenderer.setup(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        screenRenderer.handleInput();
        screenRenderer.render(stage);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
