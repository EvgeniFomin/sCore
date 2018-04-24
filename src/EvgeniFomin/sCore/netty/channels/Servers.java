package EvgeniFomin.sCore.netty.channels;


import io.netty.channel.Channel;

import java.util.HashMap;

public class Servers {
    private static Servers instance;
    private HashMap<String, Channel> proxy = new HashMap<>();
    private HashMap<String, Channel> auth = new HashMap<>();
    private HashMap<String, Channel> hub = new HashMap<>();
    private HashMap<String, Channel> other = new HashMap<>();

    public static Servers getServersManager() {
        if (instance == null) {
            instance = new Servers();
        }
        return instance;
    }

    public HashMap<String, Channel> getAuth() {
        return auth;
    }

    public HashMap<String, Channel> getHub() {
        return hub;
    }

    public HashMap<String, Channel> getOther() {
        return other;
    }

    public HashMap<String, Channel> getProxy() {
        return proxy;
    }

    public HashMap getServers() {
        HashMap<String, Channel> a = new HashMap<>();
        a.putAll(hub);
        a.putAll(other);
        a.putAll(auth);
        return a;
    }
}
