package com.jw.trip.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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

public class HelpScreen extends AbstractScreen {
	float				worldWidth 	= 300;
	float				worldHeight = 300;
	
	Stage				stage;
	
	Texture 			bkg;
	Image				bkgimage;
	
	Label				text;
	ScrollPane			scroller;
	TextButton			backbtn;
	Table				table;
	Table				container;


	public HelpScreen(final TripToSpace game) {
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
		bkgimage.addAction(Actions.sequence(Actions.delay(0.2f), Actions.alpha(0f), Actions.fadeIn(0.3f)));
		stage.addActor(bkgimage);
		
		// Set up button table actors and listeners
		final Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		CharSequence helpstring = "asdf\n"
				+ "as;lfghsflgh\n"
				+ "lasghafffffffffffffffffffffffffffffffffffffl;fjsg;flsgj\n"
				+ "s;lfdgkflsjg\n"
				+ "s;kjgfffffffffffffffffffffsfalgjsfljg\n"
				+ "sfjghsfjgs\n"
				+ "lsfjfffffffffffffffffffffffffffffffffffffffffffffffglsfjgnfsj\n"				
				+ "s;lfdgkflsjg\n"
				+ "s;kjgsfalgjsfljg\n"
				+ "sfjghsfjgs\n"
				+ "lsfjglsfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffjgnfsj\n"
				+ "s;kjgsfalgjsfljg\n"
				+ "sfjghsfjgs\n"
				+ "lsfjglsfjgnfsj\n"				
				+ "s;lfdgkflsjg\n"
				+ "s;kjgsfalgjsfljg\n"
				+ "sfjghsfjgs\n"
				+ "lsfjglsfjgnfsj\n"
				+ "slfjglsfjglsjgls\n";
		text 		= new Label(helpstring, skin);
		//text.setWrap(true);
		backbtn 	= new TextButton("Return to menu", skin);
		table		= new Table();
		container	= new Table();
		container.add(text);
		scroller 	= new ScrollPane(container);
		scroller.setScrollbarsOnTop(true);
		scroller.setScrollBarPositions(true, true);
		scroller.setStyle(new ScrollPane.ScrollPaneStyle());
		scroller.setSize(250, 200);
		table.setBounds(0, 0, 300, 300);
		table.add(scroller).row();
		table.add(backbtn);

		//scroller.setBounds(0, 300, 300, 90);
		

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
		scroller.setPosition(worldWidth/2, worldHeight/2);
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
