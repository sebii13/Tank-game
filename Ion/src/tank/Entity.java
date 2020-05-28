package tank;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

abstract class Entity {
	protected float x;
	protected float y;
	protected Texture texture;
	protected Rectangle bounds;

	public abstract void update();
	

	public void render(SpriteBatch sb) {
		sb.draw(this.texture, this.x - this.texture.getWidth() / 2, this.y - this.texture.getHeight() / 2);
	}

	public void dispose() {
		this.texture.dispose();
	
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
