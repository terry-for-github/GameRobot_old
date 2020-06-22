/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Goods;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public enum ArmorType {

    Helemet("Helemet"), Breastplate("Breastplate"), Shinguard("Shinguard"), Boots("Boots"), Weapons("Weapons"), Ornaments("Ornaments");
    private String name;

    ArmorType(String name) {
        this.name = name;
    }

}
