package nl.antimeta.game;

import com.badlogic.gdx.Game;
import nl.antimeta.game.Screens.GameScreen;

public class MyGame extends Game {

	@Override
	public void create () {
		setScreen(new GameScreen(this));
	}
}
