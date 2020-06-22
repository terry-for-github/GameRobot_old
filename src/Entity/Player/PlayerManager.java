/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Player;

import Utils.GsonUtil;
import com.google.gson.Gson;
import java.util.Date;
import java.util.Timer;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.contact.Member;
import static gamerobot.GameRobot.players;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class PlayerManager {

    public static boolean ExistThisPlayer(Friend sender) {
        if (players.containsKey(String.valueOf(sender.getId()))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ExistThisPlayer(Member sender) {
        if (players.containsKey(String.valueOf(sender.getId()))) {
            return true;
        } else {
            return false;
        }
    }

    public static void PlayerLevelUp(Player player) {
        if (player.getExp() >= player.getMaxexp()) {
            player.setLevel(player.getLevel() + 1);
            player.setPoints(player.getPoints() + 5);
            player.setExp(player.getExp() - player.getMaxexp());
            player.setMaxexp((long) (player.getMaxexp() * 1.25));
            if (player.getExp() >= player.getMaxexp()) {
                player.setExp(player.getExp() - player.getMaxexp());
                PlayerLevelUp(player);
            }
        }
    }

    public static void PlayerSeeEquip(Player player) {

    }

    public void PlayerSeeStore() {

    }

    public static void RevividPlayer(Player player) {

        if (player.getHP() == 0) {
            Date date = new Date();
            date.setTime(date.getTime() + 600000);
            player.SendMessageToPlayer("你正在复活中\n到" + date + "复活");
            Timer timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    player.setHealth(player.getMaxHealth());
//                    
//                    player.setLocation("家");
//                    player.setDoing("无");
//                    qq.sendMessage("======================\n你已经复活了\n======================");
//                }
//            }, 600000);
//            Timer timer1 = new Timer();
//            timer1.scheduleAtFixedRate(new TimerTask() {
//                @Override
//                public void run() {
//                    if (player.getHealth() > 0) {
//                        timer.cancel();
//                        timer1.cancel();
//                    }
//                }
//            }, 0, 100);

        }
    }

    public static void SavePlayerToFile(long id, Player player) {
        Gson gson = new Gson();
        File f = new File("");
        String cf = "";
        try {
            cf = f.getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(PlayerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        File file = new File(cf + "/Saves/Players/" + id + "/" + id + ".json");
        if (file.exists()) {
            String string = gson.toJson(player);
            GsonUtil.SaveStringToJsonFile(string, file);
        } else {
            try {
                file.createNewFile();
                String string = gson.toJson(player);
                GsonUtil.SaveStringToJsonFile(string, file);
            } catch (IOException ex) {
                Logger.getLogger(PlayerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
