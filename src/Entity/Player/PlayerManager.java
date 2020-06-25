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
    
    
    //是否存在这个玩家
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

    
    //玩家查看自身装备
    public static void PlayerSeeEquip(Player player) {

    }
    
    //玩家查看商店
    public void PlayerSeeStore() {

    }

    //将玩家保存到文件
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
