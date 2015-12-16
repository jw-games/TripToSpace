package com.jw.trip;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.jw.trip.screens.TitleScreen;


public class TripToSpace extends Game {
	public static final String LOG = TripToSpace.class.getSimpleName(); // Logging constant
	
	public String							decisions;
	
	public GameData							gamedata;
	
	@Override
	public void create () {
		Gdx.app.log(TripToSpace.LOG, "Creating new game");
		
		gamedata = new GameData();
		
		setScreen(new TitleScreen(this));
	}

}
