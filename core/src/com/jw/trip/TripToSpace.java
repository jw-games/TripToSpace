package com.jw.trip;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jw.trip.screens.TitleScreen;


public class TripToSpace extends Game {
	SpriteBatch batch;
	public static final String LOG = TripToSpace.class.getSimpleName(); // Logging constant

	// Set screen methods
	public TitleScreen getScreenSplash(){
		return new TitleScreen (this);
	}

	
	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
