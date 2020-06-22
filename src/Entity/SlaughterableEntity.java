/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Goods.Good;
import Interfaces.Growable;
import Interfaces.Harvestable;
import Interfaces.Hungerable;
import java.util.HashMap;


/**
 *
 * @author Administrator
 */
public abstract class SlaughterableEntity extends Entity {

    private HashMap<String, Integer> good = new HashMap<>();
    private int times;
    private long age;
    private long maxage;

    public SlaughterableEntity(String name, long MAXHP, int times, long maxage) {
        super(name, MAXHP);
        this.times = times;
        this.age = 0;
        this.maxage = maxage;

    }

    /**
     * @return the times
     */
    public int getTimes() {
        return times;
    }

    /**
     * @param times the times to set
     */
    public void setTimes(int times) {
        this.times = times;
    }

    /**
     * @return the age
     */
    public long getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(long age) {
        this.age = age;
    }

    /**
     * @return the maxage
     */
    public long getMaxage() {
        return maxage;
    }

    /**
     * @param maxage the maxage to set
     */
    public void setMaxage(int maxage) {
        this.maxage = maxage;
    }

    /**
     * @return the goods
     */
    public HashMap<String, Integer> getGoods() {
        return good;
    }

    /**
     * @param goods the goods to set
     */
    public void setGoods(HashMap<String, Integer> goods) {
        this.good = goods;
    }

}
