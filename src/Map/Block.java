/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

/**
 *
 * @author Administrator
 */
public abstract class Block {
    private int x;
    private int y;
    private int chunkx;
    private int chunky;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getChunkx() {
        return chunkx;
    }

    public void setChunkx(int chunkx) {
        this.chunkx = chunkx;
    }

    public int getChunky() {
        return chunky;
    }

    public void setChunky(int chunky) {
        this.chunky = chunky;
    }
    public Block()
    {
        
    }
    
}
