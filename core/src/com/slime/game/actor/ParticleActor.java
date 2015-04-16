package com.slime.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
/**
 * 一个自带粒子效果的演员
 * @author Yuri
 *
 */
public class ParticleActor extends Actor {
	private ParticleEffect particleEffect;
	private Vector2 vector2_effect = new Vector2();
	public ParticleActor(ParticleEffect particleEffect) {
		super();
		this.vector2_effect.x = getWidth()/2;
		this.vector2_effect.y = getHeight()/2;
		this.particleEffect = particleEffect;
	}
	public ParticleActor(ParticleEffect particleEffect,float x,float y) {
		super();
		this.vector2_effect.x = x;
		this.vector2_effect.y = y;
		this.particleEffect = particleEffect;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		particleEffect.draw(batch);
	}

	public void setEffectPosition(float effect_x,float effect_y) {
		this.vector2_effect.x = effect_x;
		this.vector2_effect.y = effect_y;
	}
	public void setEffectPosition(Vector2 vector2) {
		if(null != vector2){
			this.vector2_effect = vector2;
		}
	}
	public Vector2 getEffectPosition() {
		return vector2_effect;
	}
	@Override
	public void act(float delta) {
		super.act(delta);
		particleEffect.setPosition(getX()+vector2_effect.x, getY()+vector2_effect.y);
		particleEffect.update(delta);
	}
	public void startEffect(){
		particleEffect.start();
	}
	
}
