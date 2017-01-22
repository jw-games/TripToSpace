package com.jw.trip;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.jw.trip.screens.TitleScreen;
import com.jw.trip.utils.Player;


public class TripToSpace extends Game {
	public static final String LOG = TripToSpace.class.getSimpleName(); // Logging constant
	
	public String							decisions;
	
	public GameData							gamedata;
	public Player							player;
	
	@Override
	public void create () {
		Gdx.app.log(TripToSpace.LOG, "Creating new game");
		
		gamedata = new GameData();
		player   = new Player(this);
		
		setScreen(new TitleScreen(this));
	}

}
