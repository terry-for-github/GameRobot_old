/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Mobs;


import Entity.CombatableEntity;
import Goods.Armor;
import Goods.Good;
import Interfaces.AttackSingle;
import Interfaces.BuffAddable;
import Interfaces.Equipable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class Mob extends CombatableEntity implements Cloneable, AttackSingle, BuffAddable, Equipable {

    private Map<String, Good> Equip;
    private Map<String, Good> goods;
    private long money;
    private long exp;

    public Mob(String name, long ATK, long DEF, long MATK, long MDEF, long strength, long agile, long wisdom, double ASPD, double DSPD) {
        super(name);
        this.setATK(ATK);
        this.setDEF(DEF);
        this.setMATK(MATK);
        this.setMDEF(MDEF);
        this.setStrength(strength);
        this.setAgile(agile);
        this.setWisdom(wisdom);
        this.setASPD(ASPD);
        this.setDSPD(DSPD);
        this.exp = 0;
        this.money = 0;
        this.goods = new HashMap<>();
    }

    @Override
    public void Equip(Armor armor)
    {
         Equip.put(armor.getArmortype().toString(), armor);
    }
    
    @Override
    public int AttackSingle(CombatableEntity A, CombatableEntity B) {
        return 0;
    }

    @Override
    public Object clone() {
        Mob mob = null;
        try {
            mob = (Mob) super.clone();
            mob.setUuid(UUID.randomUUID());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return mob;
    }

    /**
     * @return the money
     */
    public long getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(long money) {
        this.money = money;
    }

    /**
     * @return the exp
     */
    public long getExp() {
        return exp;
    }

    /**
     * @param exp the exp to set
     */
    public void setExp(long exp) {
        this.exp = exp;
    }

    /**
     * @return the goods
     */
    public Map<String, Good> getGoods() {
        return goods;
    }

    /**
     * @param goods the goods to set
     */
    public void setGoods(Map<String, Good> goods) {
        this.goods = goods;
    }


}
