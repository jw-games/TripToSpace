package com.jw.trip.screens;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jw.trip.TripToSpace;
import com.jw.trip.utils.Constants;

public class TitleScreen extends AbstractScreen {
	float	worldWidth 	= 200;
	float	worldHeight = 220;
	
	Stage	stage;

	public TitleScreen(TripToSpace game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	public void show() {
		super.show();
		stage = new Stage();
		stage.getViewport().setWorldSize(Constants.VIEW_WIDTH, Constants.VIEW_HEIGHT);
		stage.getCamera().position.set(worldWidth/2, worldHeight/2, 0);
	}
	
	public void render(float delta) {
		
	}
	
	public void dispose() {
		
	}

}
