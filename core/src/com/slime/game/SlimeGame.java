package com.slime.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.slime.game.screen.StartScreen;

public class SlimeGame extends Game {
	@Override
	public void create() {
		setScreen(new StartScreen());
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
}
