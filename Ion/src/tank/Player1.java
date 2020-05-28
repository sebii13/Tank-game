package tank;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player1 extends Entity {

	private Texture left;
	private Texture right;
	private Texture up;
	private Texture down;

	private Map<String, Integer> keyMap;

	public Player1(String texturePrefix) {

		this.keyMap = new HashMap<String, Integer>();
		String texturePath = "assets/" + texturePrefix + "_tank_";
		this.down = new Texture(texturePath + "down.png");
		this.left = new Texture(texturePath + "left.png");
		this.right = new Texture(texturePath + "right.png");
		this.up = new Texture(texturePath + "up.png");
		this.texture = up;
		this.bounds = new Rectangle();
		this.bounds.setWidth(texture.getWidth());
		this.bounds.setHeight(texture.getHeight());
		this.bounds.setCenter(x, y);

	}

	public void setKey(String name, int key) {
		this.keyMap.put(name, key);

	}

	@Override
	public void update() {
		int upKey = this.keyMap.get("UP");
		if (Gdx.input.isKeyPressed(upKey)) {
			this.y += 1;

			this.texture = this.up;
		}

		int downKey = this.keyMap.get("DOWN");
		if (Gdx.input.isKeyPressed(downKey)) {
			this.y -= 1;
			this.texture = this.down;

		}

		int leftKey = this.keyMap.get("LEFT");
		if (Gdx.input.isKeyPressed(leftKey)) {
			this.x -= 1;
			this.texture = this.left;

		}
		int rightKey = this.keyMap.get("RIGHT");
		if (Gdx.input.isKeyPressed(rightKey)) {
			this.x += 1;
			this.texture = this.right;
		}

	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
