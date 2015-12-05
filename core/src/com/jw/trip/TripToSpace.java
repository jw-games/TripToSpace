package com.jw.trip;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jw.trip.screens.TitleScreen;


public class TripToSpace extends Game {
	public static final String LOG = TripToSpace.class.getSimpleName(); // Logging constant
	
	@Override
	public void create () {
		Gdx.app.log(TripToSpace.LOG, "Creating new game");
		setScreen(new TitleScreen(this));
	}

}
