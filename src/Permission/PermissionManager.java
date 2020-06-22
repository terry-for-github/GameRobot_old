/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Permission;

import Entity.Player.Player;
import GameEvent.GameEvent;
import Utils.GsonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import gamerobot.GameRobot;
import static gamerobot.GameRobot.gameevents;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class PermissionManager {

    public PermissionManager() {

    }

    public Map<String, String> GetEvents(File file) {
        String message = GsonUtil.readJsonFile(file.getPath());
        JSONObject jobj = JSON.parseObject(message);
        return ((Map<String, String>) jobj.get("events"));
    }

    public Map<Long, String> GetMembers(File file) {
        String message = GsonUtil.readJsonFile(file.getPath());
        JSONObject jobj = JSON.parseObject(message);
        return ((Map<Long, String>)jobj.get("members"));
    }

    public void SaveGroup(PermissionGroup group, File file) {
        Gson gson = new Gson();
        String string = gson.toJson(group);
        GsonUtil.SaveStringToJsonFile(string, file);
    }

    public Map<Long, Boolean> GetPermission(File file) {
        String message = GsonUtil.readJsonFile(file.getPath());
        JSONObject jobj = JSON.parseObject(message);
        Map<Long, Boolean> map = (Map<Long, Boolean>) jobj.get("permissions");
        return map;
    }

    public Boolean GetIsOpen(File file) {
        String message = GsonUtil.readJsonFile(file.getPath());
        JSONObject jobj = JSON.parseObject(message);
        boolean flag = jobj.getBoolean("isopen");
        return flag;
    }

    public Boolean GetOpen(File file) {
        String message = GsonUtil.readJsonFile(file.getPath());
        JSONObject jobj = JSON.parseObject(message);
        boolean flag = jobj.getBoolean("open");
        return flag;
    }

    public void SavePerMission(GameEvent gameevent, File file) {
        Gson gson = new Gson();
        String string = gson.toJson(gameevent);
        GsonUtil.SaveStringToJsonFile(string, file);
    }

}
