package com.jw.trip.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.jw.trip.TripToSpace;
import com.jw.trip.utils.Constants;

public class ReadScreen extends AbstractScreen {
	
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

	public ReadScreen(TripToSpace game) {
		super(game);
		
		// Create skin
		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		
		// Create stage and adjust camera and viewport
		stage = new Stage();
		stage.getViewport().setWorldSize(Constants.worldWidth, Constants.worldHeight);
		stage.getCamera().position.set(Constants.worldWidth/2, Constants.worldHeight/2, 0);
		stage.getViewport().setScreenBounds(0, 0, w, h);
		stage.getCamera().update();
		stage.getViewport().apply();		
		
		// Add background image actor and add to stage
		bkg = new Texture(Gdx.files.internal("star_nova.png"));
		bkgimage = new Image(bkg);
		bkgimage.setBounds(0, 0, 2*Constants.worldWidth, Constants.worldWidth);
		bkgimage.setColor(1, 1, 1, 0.f);
		bkgimage.addAction(Actions.sequence(Actions.delay(0.2f), Actions.alpha(0.2f), Actions.fadeIn(0.3f)));
		stage.addActor(bkgimage);
		
		text 		= new Label(game.gamedata.data.get(game.decisions).get(0), skin);
		text.setWrap(true);
		backbtn 	= new TextButton("Return to menu", skin);
		table		= new Table();
		container	= new Table();
		container.add(text).width(250);
		scrollstyle = new ScrollPane.ScrollPaneStyle();
		scrollarrows = new Image(new Texture(Gdx.files.internal("scrollarrows.png")));
		//scrollstyle.vScroll = scrollarrows.getDrawable();
		scrollstyle.vScrollKnob = scrollarrows.getDrawable();
		//scrollstyle.background = scrollarrows.getDrawable();
		scroller 	= new ScrollPane(container, scrollstyle);
		scroller.setScrollbarsOnTop(true);
		scroller.setScrollBarPositions(true, true);
		scroller.setSize(250, 200);
		table.setBounds(0, 0, 300, 300);
		table.add(scroller).row();
		table.add(backbtn);

		stage.addActor(table);
		scroller.setPosition(Constants.worldWidth/2, Constants.worldHeight/2);
		
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
