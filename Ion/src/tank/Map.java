package tank;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	private final int tileSize = 25;
	private final Texture backgroundTile;
	private final Texture wallFlat;
	private int[][] tiles;
	
	public Map(int width, int height) {
		this.tiles = new int[width][height];
		this.backgroundTile = new Texture("assets/background_tile.png");
		this.wallFlat = new Texture("assets/wall_flat.png");
	}
	
	public int getWidth() {
		return tiles.length;
	}
	
	public int getHeight() {
		return this.tiles[0].length;
	}
	
	public void render(SpriteBatch sb) {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[i].length; j++) {
				int tileType = tiles[i][j];
				drawTile(sb, i, j, tileType);
			}
		}
	}
	
	public void setTile(int i, int j, int type) {
		this.tiles[i][j] = type;
	}

	private void drawTile(SpriteBatch sb, int i, int j, int tileType) {
		if(tileType == 0) {
			sb.draw(backgroundTile, i * tileSize, j * tileSize, tileSize, tileSize);
		}else if(tileType == 1) {
			sb.draw(wallFlat, i * tileSize, j * tileSize, tileSize, tileSize);
		}
	}
}
