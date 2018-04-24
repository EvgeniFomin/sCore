package EvgeniFomin.sCore.manager;

import EvgeniFomin.sCore.objects.Proxy;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

public class ProxyManager {
    private Cache<String, Proxy> cache;

    public ProxyManager() {
        this.cache = CacheBuilder.newBuilder().softValues().build(new CacheLoader<String, Proxy>() {
            public Proxy load(String proxyName) {
                Proxy.Builder proxy = new Proxy().newBuilder();
                proxy.setName(proxyName);
                proxy.setHost("");
                proxy.setPort(25565);
                return proxy.build();
            }
        });
    }

    public Proxy getProxy(String player) {
        try {
            return this.cache.get(player);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cache<String, Proxy> getCache() {
        return cache;
    }
}
