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
public abstract class Chunk {
    
    String boime;
    Block[][] blockses;
    public Chunk()
    {
    
    }

    public String getBoime() {
        return boime;
    }

    public void setBoime(String boime) {
        this.boime = boime;
    }

    public Block[][] getBlockses() {
        return blockses;
    }

    public void setBlockses(Block[][] blockses) {
        this.blockses = blockses;
    }
}
