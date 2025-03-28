package tiles;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTilesImage();
        loadMap();
    }

    public void getTilesImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/002.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/maps/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while(col < gp.maxScreenCol){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {
                int tileNum = mapTileNum[row][col];
                int x = col * gp.TitleSize; // Changed from TitleSize to tileSize
                int y = row * gp.TitleSize;
                if (tileNum >= 0 && tileNum < tile.length && tile[tileNum] != null && tile[tileNum].image != null) {
                    g2.drawImage(tile[tileNum].image, x, y, gp.TitleSize, gp.TitleSize, null);
                } else {
                    System.err.println("Invalid tile at [" + row + "][" + col + "]: " + tileNum);
                }
            }
        }
    }
}