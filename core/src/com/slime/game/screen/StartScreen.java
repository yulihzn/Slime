package com.slime.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.slime.game.actor.ParticleActor;

public class StartScreen implements Screen{
	private Stage stage;
	private TextureAtlas atlas_button;
	private ImageButton ib_start;
	private Image background;
	private ParticleEffect effect;
	private ParticleEffectPool effectPool;
	private ParticleActor torch;

	@Override
	public void show() {
		atlas_button = new TextureAtlas(Gdx.files.internal("images/buttons.pack"));
		TextureRegionDrawable imageUp = new TextureRegionDrawable(atlas_button.findRegion("button_start_normal"));
		TextureRegionDrawable imageDown = new TextureRegionDrawable(atlas_button.findRegion("button_start_pressed"));
		ib_start = new ImageButton(imageUp, imageDown);
		ib_start.setPosition(Gdx.graphics.getWidth()/2-75, 100);
		background = new Image(new Texture(Gdx.files.internal("images/start_bg.png")));
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		stage.addActor(background);
		stage.addActor(ib_start);
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal("data/fire.p"),Gdx.files.internal("images"));
		effectPool = new ParticleEffectPool(effect, 1, 2);
		torch = new ParticleActor(effect);
		stage.addActor(torch);
		torch.startEffect();
		torch.setPosition(725, 135);
	}

	@Override
	public void render(float delta) {
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
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
		atlas_button.dispose();
		effectPool.clear();
		stage.dispose();
		
	}

}
