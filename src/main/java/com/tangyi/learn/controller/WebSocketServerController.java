package com.tangyi.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.tangyi.learn.bean.MsgVO;
import com.tangyi.learn.bean.Student;
import com.tangyi.learn.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Component
@ServerEndpoint("/groupChat/{sid}/{userId}")
public class WebSocketServerController {
    @Autowired
    StudentDao studentDao;

    /**
     * 房间号 -> 组成员信息
     */
    private static ConcurrentHashMap<String, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();
    /**
     * 房间号 -> 在线人数
     */
    private static ConcurrentHashMap<String, Set<Integer>> onlineUserMap = new ConcurrentHashMap<>();

    /**
     * 收到消息调用的方法，群成员发送消息
     *
     * @param sid:房间号
     * @param userId：用户id
     * @param message：发送消息
     */
    @OnMessage
    public void onMessage(@PathParam("sid") String sid, @PathParam("userId") Integer userId, String message) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        Set<Integer> onlineUserList = onlineUserMap.get(sid);
        // 先一个群组内的成员发送消息
        sessionList.forEach(item -> {
            try {
                // json字符串转对象
                MsgVO msg = JSONObject.parseObject(message, MsgVO.class);
                msg.setCount(onlineUserList.size());
                // json对象转字符串
                String text = JSONObject.toJSONString(msg);
                item.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 建立连接调用的方法，群成员加入
     *
     * @param session
     * @param sid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid, @PathParam("userId") Integer userId) {
        List<Session> sessionList = groupMemberInfoMap.computeIfAbsent(sid, k -> new ArrayList<>());
        Set<Integer> onlineUserList = onlineUserMap.computeIfAbsent(sid, k -> new HashSet<>());
        onlineUserList.add(userId);
        sessionList.add(session);
        // 发送上线通知
        sendInfo(sid, userId, onlineUserList.size(), "上线了~");
//        System.out.println(sid);
//        System.out.println(userId);
//        System.out.println(onlineUserList.size());
    }


    public void sendInfo(String sid, Integer userId, Integer onlineSum, String info) {
                System.out.println(sid);
        System.out.println(onlineSum);

        System.out.println(userId);
        // 获取该连接用户信息
//        Student currentUser = studentDao.getUserByName(userId);
//        System.out.println(currentUser);

        // 发送通知
        MsgVO msg = new MsgVO();
        msg.setCount(onlineSum);
        msg.setUserid(userId);
        String str="https://dgss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3745265674,139784529&fm=30&app=106&f=JPEG?w=312&h=208&s=CDA58C54006A49159E2C798B030070C8";
        msg.setAvatar(str);
        msg.setMsg(info);
        // json对象转字符串
        String text = JSONObject.toJSONString(msg);
        onMessage(sid, userId, text);
    }

    /**
     * 关闭连接调用的方法，群成员退出
     *
     * @param session
     * @param sid
     */
    @OnClose
    public void onClose(Session session, @PathParam("sid") String sid, @PathParam("userId") Integer userId) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        sessionList.remove(session);
        Set<Integer> onlineUserList = onlineUserMap.get(sid);
        onlineUserList.remove(userId);
        // 发送离线通知
//        sendInfo(sid, userId, onlineUserList.size(), "下线了~");
    }
}

