package com.jw.trip.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jw.trip.TripToSpace;
import com.jw.trip.utils.Constants;

public class TitleScreen extends AbstractScreen {
	
	Stage				stage;
	
	Texture 			bkg;
	Image				bkgimage;
	
	Table 				menuButtonTable;
	Skin 				menuButtonSkin;
	TextButton 			buttonplay;
	TextButton 			buttoncontinue;
	TextButton 			buttonhelp;
	TextButton 			buttonexit;

	public TitleScreen(final TripToSpace game) {
		super(game);
		
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
		bkgimage.addAction(Actions.sequence(Actions.delay(1f), Actions.alpha(0f), Actions.fadeIn(2f)));
		stage.addActor(bkgimage);
		
		// Set up button table actors and listeners
		menuButtonTable = new Table();
		menuButtonTable.setPosition(Constants.worldWidth/2, Constants.worldHeight/3);
		//menuButtonTable.setBounds(worldWidth/4, worldHeight/8, worldWidth/2, worldHeight*0.75f);
		menuButtonSkin = new Skin(Gdx.files.internal("mainMenu/mainMenuButtons.json"),
				new TextureAtlas(Gdx.files.internal("mainMenu/mainMenuButtons.pack")));
		
		buttonplay = new TextButton("New game", menuButtonSkin, "buttonPlay");
		buttoncontinue = new TextButton("Continue", menuButtonSkin, "buttonContinue");
		buttonhelp = new TextButton("Help", menuButtonSkin, "buttonHelp");
		buttonexit = new TextButton("Exit", menuButtonSkin, "buttonExit");		
		buttonplay.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				bkgimage.addAction(Actions.sequence(Actions.fadeOut(0.6f), Actions.run(new Runnable() {				
					public void run() {				
						dispose();
						game.decisions = "0";
						game.setScreen(new ReadScreen(game));
					}
				})));
			}});
		buttonhelp.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				bkgimage.addAction(Actions.sequence(Actions.fadeOut(0.6f), Actions.run(new Runnable() {				
					public void run() {				
						dispose();
						game.setScreen(new HelpScreen(game));
					}
				})));
			}});
		buttonexit.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				bkgimage.addAction(Actions.sequence(Actions.fadeOut(0.6f), Actions.run(new Runnable() {				
					public void run() {				
						game.dispose();
						Gdx.app.exit();
					}
				})));
		}});		
		
		menuButtonTable.add(buttonplay).width(Constants.worldWidth/2).height(Constants.worldHeight/9).pad(1f).space(1f).row();
		menuButtonTable.add(buttoncontinue).width(Constants.worldWidth/2).height(Constants.worldHeight/9).pad(1f).space(1f).row();
		menuButtonTable.add(buttonhelp).width(Constants.worldWidth/2).height(Constants.worldHeight/9).pad(1f).space(1f).row();
		menuButtonTable.add(buttonexit).width(Constants.worldWidth/2).height(Constants.worldHeight/9).pad(1f).space(1f).row();
		//menuButtonTable.setScale(0.5f);
		stage.addActor(menuButtonTable);
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
