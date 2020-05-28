package tank;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.sun.javafx.scene.traversal.Direction;

import javafx.scene.input.KeyCode;

public class Bullet extends Entity {

	float a, time;
	int speed;

	public Bullet( float x, float y) {

		super();// ia valorile din clasa pe care o mosteneste
		this.texture = new Texture("assets/p1_enemy_bullet1.png");
		this.x = x;
		this.y = y;
		this.bounds = new Rectangle();
		this.bounds.setWidth(texture.getWidth());
		this.bounds.setHeight(texture.getHeight());
		this.bounds.setCenter(x, y);
		
		

	}

	public void update(float delta) {

		// x= x+5;
		// if (e.getCode() == KeyCode.LEFT) {
		x += 200 * (float) Math.sin(a) * delta;

		y += 200 * (float) Math.cos(a) * delta;

		time -= delta;

		/*
		 * if (face.equals("RIGHT")) { x += 5; } else if (face.equals("LEFT")) { x -= 5;
		 * } else if (face.equals("UP")) { y += 5; } else if (face.equals("DOWN")) { y
		 * -= 5; }
		 */

		bounds.setCenter(x, y);

	}

	public float getY() {
		return y;
	}

	public float getX() {
		return x;
	}

	public void draw(SpriteBatch sb) {
		sb.draw(texture, bounds.x, bounds.y);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
