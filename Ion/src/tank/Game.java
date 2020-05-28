package tank;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.renderers.BillboardControllerRenderData;
import com.badlogic.gdx.math.Vector2;

import javafx.scene.input.KeyCode;

public class Game implements ApplicationListener {

	private Map map;
	private SpriteBatch sb;

	private Player1 p1;
	private Player1 p2;
	private ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	float x;
	float y;

	@Override
	public void create() {

		p1 = new Player1("player1");
		p1.setKey("UP", Input.Keys.UP);
		p1.setKey("DOWN", Input.Keys.DOWN);
		p1.setKey("LEFT", Input.Keys.LEFT);
		p1.setKey("RIGHT", Input.Keys.RIGHT);

		p2 = new Player1("player2");
		p2.setKey("UP", Input.Keys.W);
		p2.setKey("DOWN", Input.Keys.S);
		p2.setKey("LEFT", Input.Keys.A);
		p2.setKey("RIGHT", Input.Keys.D);

		map = new Map(Gdx.graphics.getWidth() / 25, Gdx.graphics.getHeight() / 25);
		sb = new SpriteBatch();

		int a = Gdx.graphics.getWidth() / 25 / 2;
		int b = Gdx.graphics.getHeight() / 25 / 2;
		int r = 7;

		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getHeight(); j++) {
				if ((i - a) * (i - a) + (j - b) * (j - b) <= r * r) {
					map.setTile(i, j, 1);
				}
			}
		}
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void render() {
		p1.update();
		p2.update();
		for (Bullet bill : bullet) {

			bill.update(Gdx.graphics.getDeltaTime());

		}

		sb.begin();
		map.render(sb);
		p1.render(sb);
		p2.render(sb);
		for (Bullet bill : bullet) {
			bill.draw(sb);

		}

		sb.end();

		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {

			Bullet myBullet = new Bullet(p1.getX(), p1.getY() + 10);

			bullet.add(myBullet);

		}

		if (Gdx.input.isKeyJustPressed(Keys.B)) {

			bullet.add(new Bullet(p2.getX(), p2.getY() + 10));

		}

	}

	@Override
	public void resize(int w, int h) {
	}

	@Override
	public void dispose() {

	}

}
