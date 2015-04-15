package com.slime.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class StartScreen implements Screen{
	private Stage stage;
	private TextureAtlas atlas;
	private ImageButton ib_start;
	private Image background;
	private float scalewidth=1.0f,scaleheight=1.0f;
	public static final int W = 800;
	public static final int H = 600;

	@Override
	public void show() {
		atlas = new TextureAtlas(Gdx.files.internal("images/buttons.pack"));
		TextureRegionDrawable imageUp = new TextureRegionDrawable(atlas.findRegion("button_start_normal"));
		TextureRegionDrawable imageDown = new TextureRegionDrawable(atlas.findRegion("button_start_pressed"));
		ib_start = new ImageButton(imageUp, imageDown);
		ib_start.setPosition((400-75)*scalewidth, 100*scaleheight);
		background = new Image(new Texture(Gdx.files.internal("images/start_bg.png")));
		ib_start.setDebug(true);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		stage.addActor(background);
		stage.addActor(ib_start);
		
	}

	@Override
	public void render(float delta) {
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		scalewidth = width/W;
		scaleheight = height/H;
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
