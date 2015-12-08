package com.jw.trip.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jw.trip.TripToSpace;
import com.jw.trip.utils.Constants;

public class TitleScreen extends AbstractScreen {
	float				worldWidth 	= 300;
	float				worldHeight = 300;
	
	Stage				stage;
	
	Texture 			bkg;
	Image				bkgimage;
	
	Table 				menuButtonTable;
	Skin 				menuButtonSkin;
	TextButton 			buttonPlay, buttonContinue, buttonHelp, buttonExit;

	public TitleScreen(final TripToSpace game) {
		super(game);
		
		// Create stage and adjust camera and viewport
		stage = new Stage();
		stage.getViewport().setWorldSize(worldWidth, worldHeight);
		stage.getCamera().position.set(worldWidth/2, worldHeight/2, 0);
		stage.getViewport().setScreenBounds(0, 0, w, h);
		stage.getCamera().update();
		stage.getViewport().apply();		
		
		// Add background image actor and add to stage
		bkg = new Texture(Gdx.files.internal("title.jpg"));
		bkgimage = new Image(bkg);
		bkgimage.setBounds(0, 0, worldWidth, worldWidth);
		bkgimage.setColor(1, 1, 1, 0);
		bkgimage.addAction(Actions.sequence(Actions.delay(2f), Actions.alpha(0f), Actions.fadeIn(3f)));
		stage.addActor(bkgimage);
		
		// Set up button table actors and listeners
		menuButtonTable = new Table();
		menuButtonTable.setPosition(worldWidth/2, worldHeight/3);
		//menuButtonTable.setBounds(worldWidth/4, worldHeight/8, worldWidth/2, worldHeight*0.75f);
		menuButtonSkin = new Skin(Gdx.files.internal("mainMenu/mainMenuButtons.json"),
				new TextureAtlas(Gdx.files.internal("mainMenu/mainMenuButtons.pack")));
		
		buttonPlay = new TextButton("New game", menuButtonSkin, "buttonPlay");
		buttonContinue = new TextButton("Continue", menuButtonSkin, "buttonContinue");
		buttonHelp = new TextButton("Help", menuButtonSkin, "buttonHelp");
		buttonExit = new TextButton("Exit", menuButtonSkin, "buttonExit");		
		buttonPlay.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				bkgimage.addAction(Actions.sequence(Actions.fadeOut(0.6f), Actions.run(new Runnable() {				
					public void run() {				
						dispose();
						game.setScreen(new GameScreen(game));
					}
				})));
			}});
		buttonHelp.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				bkgimage.addAction(Actions.sequence(Actions.fadeOut(0.6f), Actions.run(new Runnable() {				
					public void run() {				
						dispose();
						game.setScreen(new HelpScreen(game));
					}
				})));
			}});
		buttonExit.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				bkgimage.addAction(Actions.sequence(Actions.fadeOut(0.6f), Actions.run(new Runnable() {				
					public void run() {				
						game.dispose();
						Gdx.app.exit();
					}
				})));
		}});		
		
		menuButtonTable.add(buttonPlay).width(worldWidth/2).height(worldHeight/9).pad(1f).space(1f).row();
		menuButtonTable.add(buttonContinue).width(worldWidth/2).height(worldHeight/9).pad(1f).space(1f).row();
		menuButtonTable.add(buttonHelp).width(worldWidth/2).height(worldHeight/9).pad(1f).space(1f).row();
		menuButtonTable.add(buttonExit).width(worldWidth/2).height(worldHeight/9).pad(1f).space(1f).row();
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
