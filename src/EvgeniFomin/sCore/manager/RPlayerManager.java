package EvgeniFomin.sCore.manager;

import EvgeniFomin.sCore.Core;
import EvgeniFomin.sCore.objects.RPlayer;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RPlayerManager {
    private Statement statement;
    private Statement statement2;
    private Statement statement3;
    private Cache<String, RPlayer> cache;

    public RPlayerManager() {
        try {
            statement = Core.getSql().getConnection().createStatement();
            statement2 = Core.getSql().getConnection().createStatement();
            statement3 = Core.getSql().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cache = CacheBuilder.newBuilder().softValues().build(new CacheLoader<String, RPlayer>() {
            public RPlayer load(String player) {
                RPlayer.Builder build = RPlayer.newBuilder();
                ResultSet rs = null;
                ResultSet rs2 = null;
                ResultSet rs3 = null;
                try {
                    rs = statement.executeQuery("SELECT * FROM `Stats` WHERE `user` = '" + player + "'");
                    rs2 = statement2.executeQuery("SELECT * FROM `Bans` WHERE `user` = '" + player + "'");
                    rs3 = statement3.executeQuery("SELECT * FROM `Mutes` WHERE `user` = '" + player + "'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (rs.next()) {
                        if (rs2.next()) {
                            build.setBannedBy(rs2.getString("bannedBy"));
                            build.setBanReason(rs2.getString("banReason"));
                            build.setBanEnd(rs2.getLong("banEnd"));
                            build.setBanOn(rs2.getLong("banOn"));
                            build.setAmountBans(rs2.getInt("bans"));
                            build.setIsBanned(rs2.getBoolean("active"));
                        }
                        if (rs3.next()) {
                            build.setMutedBy(rs3.getString("mutedBy"));
                            build.setMuteReason(rs3.getString("muteReason"));
                            build.setMuteEnd(rs3.getLong("muteEnd"));
                            build.setMuteOn(rs3.getLong("muteOn"));
                            build.setAmountMutts(rs3.getInt("mutts"));
                            build.setIsMuted(rs3.getBoolean("active"));
                        }
                        build.setName(player);
                        build.setGroup(rs.getInt("band"));
                        build.setCoins(rs.getInt("coins"));
                        build.setLevel(rs.getInt("level"));
                        build.setXp(rs.getInt("xp"));

                        return build.build();
                    }
                    RPlayerManager.this.statement.executeUpdate("INSERT INTO `Stats` (`user`) VALUES ('" + player + "')");
                    RPlayerManager.this.statement2.executeUpdate("INSERT INTO `Bans` (`user`) VALUES ('" + player + "')");
                    RPlayerManager.this.statement3.executeUpdate("INSERT INTO `Mutes` (`user`) VALUES ('" + player + "')");
                    build.setName(player);
                    build.setGroup(1);
                    build.setCoins(0);
                    build.setLevel(1);
                    build.setXp(0);
                    build.setIsBanned(false);
                    build.setIsMuted(false);

                    build.setBannedBy("");
                    build.setBanReason("");
                    build.setBanEnd(0L);
                    build.setBanOn(0L);
                    build.setAmountBans(0);
                    build.setIsBanned(false);

                    build.setMutedBy("");
                    build.setMuteReason("");
                    build.setMuteEnd(0L);
                    build.setMuteOn(0L);
                    build.setAmountMutts(0);
                    build.setIsMuted(false);

                    return build.build();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    public void save(String player) {
        try {
            RPlayer toSave = this.cache.get(player);
            this.statement.executeUpdate("UPDATE `Stats` SET band = '" + toSave.getGroupId() + "', coins = '" + toSave.getCoins() + "', level = '" + toSave.getLevel() + "', xp = '" + toSave.getXp() + "'  WHERE user = '" + player + "'");
            this.statement2.executeUpdate("UPDATE `Bans` SET bannedBy = '" + toSave.getBannedBy() + "', banReason = '" + toSave.getBanReason() + "', banEnd = '" + toSave.getBanEnd() + "', banOn = '" + toSave.getBanOn() + "', bans = '" + toSave.getAmountBans() + "', active = '" + toSave.getBanActive() + "'  WHERE user = '" + player + "'");
            this.statement3.executeUpdate("UPDATE `Mutes` SET mutedBy = '" + toSave.getMutedBy() + "', muteReason = '" + toSave.getMuteReason() + "', muteEnd = '" + toSave.getMuteEnd() + "', muteOn = '" + toSave.getMuteOn() + "', mutts = '" + toSave.getAmountMutts() + "', active = '" + toSave.getMuteActive() + "'  WHERE user = '" + player + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RPlayer getCPlayer(String player) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        try {
            scheduler.schedule(() -> RPlayerManager.this.save(player), 10, TimeUnit.MILLISECONDS);
            return this.cache.get(player);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
