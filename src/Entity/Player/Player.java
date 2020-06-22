/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Player;

import Entity.CombatableEntity;
import Goods.Armor;
import Goods.Good;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import Interfaces.AttackSingle;
import Interfaces.BuffAddable;
import Interfaces.Equipable;
import static gamerobot.GameRobot.bot;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import net.mamoe.mirai.contact.Friend;

/**
 *
 * @author Administrator
 */
public class Player extends CombatableEntity implements Cloneable, AttackSingle, Equipable, BuffAddable {

    private Map<String, Good> Equip;
    private Map<String, Good> Store;
    private long money;
    private long level;
    private long exp;
    private long maxexp;
    private long points;

    public Player(String name) {
        super(name);
        this.level = 1;
        this.exp = 0;
        this.maxexp = 100;
        this.points = 0;
        this.money = 0;
        this.Equip = new ConcurrentHashMap<>();
        this.Store = new ConcurrentHashMap<>();
    }

    public void Revivid() {
        if (this.getHP() == 0) {
            Player player = this;
            Date date = new Date();
            date.setTime(date.getTime() + 600000);
            SendMessageToPlayer("你正在复活中\n" + date);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.setHP(player.getMAXHP());
                    SendMessageToPlayer("你已经复活了");
                }
            }, 600000);
            Timer timer1 = new Timer();
            timer1.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (player.getHP() > 0) {
                        timer.cancel();
                        timer1.cancel();
                    }
                }
            }, 0, 100);

        }
    }

    @Override
    public void Equip(Armor armor) {
        if (Equip.containsKey(armor.getArmortype().toString())) {
            Store.put(Equip.get(armor.getArmortype().toString()).getName(), Equip.get(armor.getArmortype().toString()));
            Equip.put(armor.getArmortype().toString(), armor);
        } else {
            Equip.put(armor.getArmortype().toString(), armor);
        }
    }

    public void GetExp(long exp) {
        this.setExp(this.getExp() + exp);
        PlayerManager.PlayerLevelUp(this);
    }

    public void AddMoney(long money) {
        this.money = this.money + money;
    }

    public boolean RemoveMoney(long money) {
        if (this.money >= money) {
            this.money = this.money - money;
            return true;
        } else {
            return false;
        }
    }

    public boolean HaveEnoughGood(Good good, int number) {
        if (this.Store.containsKey(good.getName()) && this.Store.get(good.getName()).getNumber() >= number) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PlayerAddGood(Good good, int number) {
        if (good instanceof Armor) {
            good.setName(good.getName() + ((Armor) good).getUuid().timestamp());
        }
        good.setNumber(number);
        if (this.getStore().containsKey(good.getName())) {
            Good thegood = this.getStore().get(good.getName());
            thegood.setNumber(thegood.getNumber() + number);
        } else {
            this.getStore().put(good.getName(), good);
        }
        return true;
    }

    public boolean PlayerRemoveGood(Good good, int number) {
        if (HaveEnoughGood(good, number)) {
            Good thegood = this.getStore().get(good.getName());
            if (thegood.getNumber() == number) {
                thegood.setNumber(thegood.getNumber() - number);
            } else if (thegood.getNumber() > number) {
                this.getStore().remove(good.getName());
            }
            return true;

        } else {
            return false;
        }

    }

    public Friend GetQQ() {
        return bot.getFriend(Long.valueOf(this.getName()));
    }

    @Override
    public int AttackSingle(CombatableEntity A, CombatableEntity B) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player clone() {
        Player player = null;
        try {
            player = (Player) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return player;
    }

    public boolean SendMessageToPlayer(String message) {
        message = "======================\n     " + message + "     \n======================";
        if (bot.getFriends().contains(Long.parseLong(this.getName()))) {
            bot.getFriend(Long.valueOf(this.getName())).sendMessage(message);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the Equip
     */
    public Map<String, Good> getEquip() {
        return Equip;
    }

    /**
     * @param Equip the Equip to set
     */
    public void setEquip(Map<String, Good> Equip) {
        this.Equip = Equip;
    }

    /**
     * @return the Store
     */
    public Map<String, Good> getStore() {
        return Store;
    }

    /**
     * @param Store the Store to set
     */
    public void setStore(Map<String, Good> Store) {
        this.Store = Store;
    }

    /**
     * @return the level
     */
    public long getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(long level) {
        this.level = level;
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
     * @return the maxexp
     */
    public long getMaxexp() {
        return maxexp;
    }

    /**
     * @param maxexp the maxexp to set
     */
    public void setMaxexp(long maxexp) {
        this.maxexp = maxexp;
    }

    /**
     * @return the points
     */
    public long getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(long points) {
        this.points = points;
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

    

}
