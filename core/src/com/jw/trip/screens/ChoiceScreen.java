package com.jw.trip.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jw.trip.TripToSpace;
import com.jw.trip.utils.Constants;

public class ChoiceScreen extends AbstractScreen {

	Stage				stage;
	Skin				skin;
	
	Texture 			bkg;
	Image				bkgimage;
	
	int					optionslength;
	List<String>		options;
	
	Label				text;
	ScrollPane			scroller;
	
	TextButton			abtn;
	TextButton			bbtn;
	TextButton			cbtn;
	TextButton			returnbtn;
	
	Table				screenlayout;
	Table				container;

	public ChoiceScreen(final TripToSpace game) {
		super(game);
		
		// Create skin
		skin 			= new Skin(Gdx.files.internal("skin/uiskin.json"));
		
		// Create stage and adjust camera and viewport
		stage 			= new Stage();
		stage.getViewport().setWorldSize(Constants.worldWidth, Constants.worldHeight);
		stage.getCamera().position.set(Constants.worldWidth/2, Constants.worldHeight/2, 0);
		stage.getViewport().setScreenBounds(0, 0, w, h);
		stage.getCamera().update();
		stage.getViewport().apply();		
		
		// Add background image actor and add to stage
		bkg 			= new Texture(Gdx.files.internal("star_nova.png"));
		bkgimage		= new Image(bkg);
		bkgimage.setBounds(0, 0, 2*Constants.worldWidth, Constants.worldWidth);
		bkgimage.setColor(1, 1, 1, 0.f);
		bkgimage.addAction(Actions.sequence(Actions.delay(0.2f), Actions.alpha(0.2f), Actions.fadeIn(0.3f)));
		stage.addActor(bkgimage);
		
		screenlayout	= new Table();
		container		= new Table();
		
		options = new ArrayList<String>();
		optionslength = game.gamedata.data.get(game.decisions).size() - 1;
		Gdx.app.log(TripToSpace.LOG, "Decisions list length is: " + optionslength);
		
		if (optionslength > 1) {
			for (int i = 1; i <= optionslength; i++) {
				if (i == 1) {
					abtn = new TextButton(game.gamedata.data.get(game.decisions).get(i), skin);
					container.add(abtn).center().width(250).row();
					abtn.addListener(new ClickListener() {
						public void clicked(InputEvent event, float x, float y) {		
							game.decisions += "a";
							game.setScreen(new ReadScreen(game));
						}
					});
				}
				if (i == 2) {
					bbtn = new TextButton(game.gamedata.data.get(game.decisions).get(i), skin);
					container.add(bbtn).center().width(250).row();
					bbtn.addListener(new ClickListener() {
						public void clicked(InputEvent event, float x, float y) {		
							game.decisions += "b";
							game.setScreen(new ReadScreen(game));
						}
					});
				}
				if (i == 3) {
					cbtn = new TextButton(game.gamedata.data.get(game.decisions).get(i), skin);
					container.add(cbtn).center().width(250).row();
					cbtn.addListener(new ClickListener() {
						public void clicked(InputEvent event, float x, float y) {		
							game.decisions += "c";
							game.setScreen(new ReadScreen(game));
						}
					});
				}
			}
			returnbtn = new TextButton("Read again", skin);
			container.add(returnbtn);
			returnbtn.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y) {		
					game.setScreen(new ReadScreen(game));
				}
			});
		}
		else {
			
		}
		
		

		screenlayout.setBounds(0, 0, 300, 300);
		screenlayout.add(container);
		

		stage.addActor(screenlayout);

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
		skin.dispose();
		stage.dispose();
		
	}

}
