package com.jw.trip.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.TimeUtils;
import com.jw.trip.TripToSpace;

public class AbstractScreen implements Screen {
	protected final TripToSpace game;
	protected final BitmapFont font;
	protected float w;
	protected float h;
	protected float aspect;
	protected long screenShowTime;
	
	public AbstractScreen (TripToSpace game) {
		Gdx.app.log(TripToSpace.LOG, "constructing screen!");

		this.game = game;
		this.font = new BitmapFont(Gdx.files.internal("fonts/bauchaomaicha.fnt"));
		this.w = Gdx.graphics.getWidth();
		this.h = Gdx.graphics.getHeight();
		this.aspect = w/h;
	}
	
	protected String getName() {
		return getClass().getSimpleName();
	}
	
	// Screen implementation
	@Override
	public void show() {
		Gdx.app.log(TripToSpace.LOG, "Showing screen: " + getName());	
		this.screenShowTime = TimeUtils.millis();		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f); //clear screen with black color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height) {
	    Gdx.app.log(TripToSpace.LOG, "Resizing screen: " + getName() + " to: " + width + " x " + height);
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();	
		aspect = w/h;

	}

	@Override
	public void pause() {
		Gdx.app.log(TripToSpace.LOG, "Pausing screen: " + getName());
	}

	@Override
	public void resume() {
		Gdx.app.log(TripToSpace.LOG, "Resuming screen: " + getName());		
	}

	@Override
	public void hide() {
		Gdx.app.log(TripToSpace.LOG, "Hiding screen: " + getName());		
	}

	@Override
	public void dispose() {
        Gdx.app.log(TripToSpace.LOG, "Disposing screen: " + getName());
        font.dispose();
	}

	
}
