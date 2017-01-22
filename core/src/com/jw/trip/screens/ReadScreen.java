package com.jw.trip.screens;

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
import com.jw.trip.utils.Page;
import com.jw.trip.utils.Player;

public class ReadScreen extends AbstractScreen {
	
	Stage				stage;
	Skin				skin;
	
	Texture 			bkg;
	Image				bkgimage;
	Texture				picture;
	Image				pictureimage;
	
	Label				title;
	Label				text;
	ScrollPane			scroller;
	Table				container;

	TextButton			continuebtn;
	
	Table				screenlayout;
	
	Page				page;

	public ReadScreen(final TripToSpace game) {
		super(game);
		
		// Check decisions string
		Gdx.app.log(TripToSpace.LOG, "Decision string is: " + game.player.getPagename());
		page = game.player.getPage(game.player.getPagename());
		Gdx.app.log(TripToSpace.LOG, page.getText());
		
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
		
		title = new Label(page.getTitle(), skin);
		text = new Label(page.getText(), skin);
		text.setWrap(true);

		screenlayout		= new Table();
		container	= new Table();
		if (!page.getPicture().equals("null")) {
			Gdx.app.log(TripToSpace.LOG, "Picture: " + page.getPicture());
			picture = new Texture(Gdx.files.internal(page.getPicture()));
			pictureimage = new Image(picture);
			//pictureimage.setSize(50, 50);
			container.add(pictureimage).width(100).height(100).row();
		}
		container.add(text).width(260);

		scroller 	= new ScrollPane(container, skin, "alpha");

		continuebtn	= new TextButton("Continue", skin);
		continuebtn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {		
				dispose();
				game.setScreen(new ChoiceScreen(game));
			}
		});

		screenlayout.setBounds(0, 0, 300, 300);
		screenlayout.add(title).width(300).row();
		screenlayout.add(scroller).width(300).row();
		screenlayout.add(continuebtn);

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
		bkg.dispose();
		
	}


}
