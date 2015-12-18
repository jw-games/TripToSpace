package com.jw.trip.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jw.trip.TripToSpace;
import com.jw.trip.utils.Constants;

public class HelpScreen extends AbstractScreen {
	
	Stage				stage;
	Skin				skin;
	
	Texture 			bkg;
	Image				bkgimage;
	
	Label				text;
	ScrollPane			scroller;
	ScrollPaneStyle		scrollstyle;
	Image				scrollarrows;
	TextButton			backbtn;
	Table				table;
	Table				container;


	public HelpScreen(final TripToSpace game) {
		super(game);
		
		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		
		// Create stage and adjust camera and viewport
		stage = new Stage();
		stage.getViewport().setWorldSize(Constants.worldWidth, Constants.worldHeight);
		stage.getCamera().position.set(Constants.worldWidth/2, Constants.worldHeight/2, 0);
		stage.getViewport().setScreenBounds(0, 0, w, h);
		stage.getCamera().update();
		stage.getViewport().apply();		
		
		// Add background image actor and add to stage
		bkg = new Texture(Gdx.files.internal("title.jpg"));
		bkgimage = new Image(bkg);
		bkgimage.setBounds(0, 0, Constants.worldWidth, Constants.worldWidth);
		bkgimage.setColor(1, 1, 1, 0);
		bkgimage.addAction(Actions.sequence(Actions.delay(0.2f), Actions.alpha(0f), Actions.fadeIn(0.3f)));
		stage.addActor(bkgimage);
		
		// Set up button table actors and listeners
		String helpstring = "This is a choose-your-own adventure game targeted at children 6-600 years old. "
				+ "The game is played by reading a part of the story, then choosing from several options about how to proceed. "
				+ "Some choices will have an immediate and obvious impact (such as the end of the game), "
				+ "while others may not be apparent until much later in the game, "
				+ "but all choices made by the player will have some impact on the outcome of the story. "
				+ "There's no one single way to \"win\" the game, although there are certainly many choices that will lead to \"losing\". "
				+ "Your game will be autosaved after each choice you make, so you can quit at anytime and resume where you left off "
				+ "by simply clicking the \"Continue\" button (but beware if you start a new game your old one will be erased). "
				+ "Best of luck in your travels...";
		text 		= new Label(helpstring, skin);
		text.setWrap(true);
		
		table		= new Table();
		container	= new Table();
		container.add(text).width(260);

		scroller 	= new ScrollPane(container, skin, "alpha");

		backbtn 	= new TextButton("Return to menu", skin);
		
		table.setBounds(0, 0, 300, 300);
		table.add(scroller).width(300).row();
		table.add(backbtn);

		backbtn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				bkgimage.addAction(Actions.sequence(Actions.fadeOut(0.6f), Actions.run(new Runnable() {				
					public void run() {				
						dispose();
						game.setScreen(new TitleScreen(game));
					}
				})));
			}});

		
		//menuButtonTable.setScale(0.5f);
		stage.addActor(table);
		scroller.setPosition(Constants.worldWidth/2, Constants.worldHeight/2);
		//table.
	}
	
	public void show() {
		super.show();
		Gdx.input.setInputProcessor(stage);
	}
	
	public void render(float delta) {
		super.render(delta);
		
		stage.getCamera().update();
		stage.getViewport().apply();
		stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
		stage.draw();
		stage.act(delta);

	}
	
	public void dispose() {
		
	}

}
