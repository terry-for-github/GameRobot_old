/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map.ForestBoime;

import Map.Block;
import Map.Chunk;

/**
 *
 * @author Administrator
 */
public class ForestChunk extends Chunk {

    public ForestChunk() {
        this.setBoime("forest");
        this.setBlockses(new Block[11][11]);
    }
}
