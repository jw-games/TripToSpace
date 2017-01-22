package com.jw.trip.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.jw.trip.TripToSpace;
import com.jw.trip.screens.ReadScreen;

public class Player {
	
	Inventory 	inventory;
	String    	pagename;
	Page	  	page;
	TripToSpace	game;
	
	public Player(TripToSpace game) {
		
		this.game 	= game;
		inventory   = new Inventory();
		pagename    = "Intro";
		
	}

	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	
	public Page getPage(String pagename) {
		Json json = new Json();
		Object page = json.fromJson(Page.class, Gdx.files.internal("json/" + pagename + ".json"));
		return (Page) page;
	}
	
	public void recordChoice(String choice) {
		if (pagename.equals("Intro")) {
			this.setPagename("Launchpad");
			game.setScreen(new ReadScreen(game));
		}
	}


}
