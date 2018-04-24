package EvgeniFomin.sCore.objects;

import EvgeniFomin.sCore.enums.Group;
import EvgeniFomin.sCore.events.eventhandller.*;

import java.awt.*;

public class RPlayer {
    private String player;
    private Group group;
    private Integer coins;
    private Integer level;
    private Integer xp;

    private String mutedBy;
    private String muteReason;
    private Long muteOn;
    private Long muteEnd;
    private Integer amountMutts;
    private Boolean muteActive;

    private String bannedBy;
    private String banReason;
    private Long banOn;
    private Long banEnd;
    private Integer amountBans;
    private Boolean banActive;

    public RPlayer() {
    }

    public RPlayer(String owner) {
        this.player = owner;
        this.group = reGroup(1);
        this.coins = 0;
        this.level = 0;
        this.xp = 0;
    }

    public RPlayer(String owner, Integer id, Integer coins, Integer level, Integer xp) {
        this.player = owner;
        this.group = reGroup(id);
        this.coins = coins;
        this.level = level;
        this.xp = xp;
    }

    public static Builder newBuilder() {
        return new RPlayer().new Builder();
    }

    public boolean isDonater() {
        return group != Group.Игрок;
    }

    public boolean isStaff() {
        return group.equals(Group.Строитель) || group.equals(Group.Хелпер) || group.equals(Group.Модератор) || group.equals(Group.Администратор);
    }

    public Boolean isDefault() {
        return group.equals(Group.Игрок);
    }

    public Boolean isVip() {
        return group.equals(Group.Вип);
    }

    public Boolean isResearcher() {
        return group.equals(Group.Исследователь);
    }

    public Boolean isPremium() {
        return group.equals(Group.Премиум);
    }

    public Boolean isLord() {
        return group.equals(Group.Лорд);
    }

    public Boolean isYouTuber() {
        return group.equals(Group.Ютубер);
    }

    public Boolean isKing() {
        return group.equals(Group.Король);
    }

    public boolean isBuilder() {
        return group.equals(Group.Строитель);
    }

    public boolean isHelper() {
        return group.equals(Group.Хелпер);
    }

    public boolean isModerator() {
        return group.equals(Group.Модератор);
    }

    public boolean isAdministrator() {
        return group.equals(Group.Администратор);
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void addCoins(Integer coins) {
        this.coins += coins;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void addLevel(Integer level) {
        this.level += level;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public void addXp(Integer xp) {
        this.xp += xp;
    }

    public String getName() {
        return player;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setGroup(Integer id) {
        this.group = reGroup(id);
    }

    public String getPrefix() {
        return group.getPrefix();
    }

    public String getTabPrefix() {
        return group.getTabprefix();
    }

    public Float getMultiplier() {
        return group.getMultiplier();
    }

    public Integer getGroupId() {
        return group.getId();
    }

    public Color getChatColor() {
        return group.getChatcolor();
    }

    public void kick(RPlayer kickedBy, String reason) {
        new Kick(this, kickedBy, reason);
    }

    public void kick(RPlayer kickedBy) {
        new Kick(this, kickedBy);
    }

    public void kick(String reason) {
        new Kick(this, reason);
    }

    public void kick() {
        new Kick(this);
    }

    public void mute(RPlayer mutedBy, Integer time, String format, String reason) {
        new Mute(this, mutedBy, time, format, reason);
    }

    public void mute(Integer time, String format, String reason) {
        new Mute(this, time, format, reason);
    }

    public void mute(RPlayer mutedBy, String reason) {
        new Mute(this, mutedBy, reason);
    }

    public void mute(RPlayer mutedBy, Integer time, String format) {
        new Mute(this, mutedBy, time, format);
    }

    public void mute() {
        new Mute(this);
    }

    public void mute(RPlayer mutedBy) {
        new Mute(this, mutedBy);
    }

    public void ban(RPlayer mutedBy, Integer time, String format, String reason) {
        new Ban(this, mutedBy, time, format, reason);
    }

    public void ban(Integer time, String format, String reason) {
        new Ban(this, time, format, reason);
    }

    public void ban(RPlayer mutedBy, String reason) {
        new Ban(this, mutedBy, reason);
    }

    public void ban(RPlayer mutedBy, Integer time, String format) {
        new Ban(this, mutedBy, time, format);
    }

    public void ban() {
        new Ban(this);
    }

    public void ban(RPlayer mutedBy) {
        new Ban(this, mutedBy);
    }

    public void unMute(RPlayer unMuted) {
        new UnMute(this, unMuted);
    }

    public void unMute() {
        new UnMute(this);
    }

    public void unBan(RPlayer unBan) {
        new UnBan(this, unBan);
    }

    public void unBan() {
        new UnBan(this);
    }

    private Group reGroup(Integer id) {
        switch (id) {
            case 1:
                return Group.Игрок;
            case 2:
                return Group.Вип;
            case 3:
                return Group.Исследователь;
            case 4:
                return Group.Премиум;
            case 5:
                return Group.Лорд;
            case 6:
                return Group.Король;
            case 7:
                return Group.Ютубер;
            case 8:
                return Group.Строитель;
            case 9:
                return Group.Хелпер;
            case 10:
                return Group.Модератор;
            case 11:
                return Group.Администратор;
            default:
                return Group.Игрок;
        }
    }

    public String getBannedBy() {
        return bannedBy;
    }

    public String getBanReason() {
        return banReason;
    }

    public Long getBanEnd() {
        return banEnd;
    }

    public Long getBanOn() {
        return banOn;
    }

    public Integer getAmountBans() {
        return amountBans;
    }

    public Boolean getActive() {
        return banActive;
    }

    public Boolean isBanned() {
        return banActive;
    }

    public Boolean isMuted() {
        return muteActive;
    }

    public Integer getAmountMutts(){
        return amountMutts;
    }

    public void setBannedBy(String bannedBy) {
        this.bannedBy = bannedBy;
    }

    public void setAmountBans(Integer amountBans) {
        this.amountBans = amountBans;
    }

    public void setBanEnd(Long banEnd) {
        this.banEnd = banEnd;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    public void setBanOn(Long banOn) {
        this.banOn = banOn;
    }

    public void setAmountMutts(Integer amountMutts) {
        this.amountMutts = amountMutts;
    }

    public void setBanActive(Boolean banActive) {
        this.banActive = banActive;
    }

    public void setMuteActive(Boolean muteActive) {
        this.muteActive = muteActive;
    }

    public Long getMuteOn() {
        return muteOn;
    }

    public String getMutedBy() {
        return mutedBy;
    }

    public String getMuteReason() {
        return muteReason;
    }

    public Long getMuteEnd() {
        return muteEnd;
    }

    public boolean getBanActive() {
        return banActive;
    }

    public boolean getMuteActive() {
        return muteActive;
    }

    public void setMutedBy(String mutedBy) {
        this.mutedBy = mutedBy;
    }

    public void setMuteEnd(Long muteEnd) {
        this.muteEnd = muteEnd;
    }

    public void setMuteOn(Long mutedOn) {
        this.muteOn = mutedOn;
    }

    public void setMuteReason(String muteReason) {
        this.muteReason = muteReason;
    }

    public class Builder {

        private Builder() {
        }

        public Builder setName(String player) {
            RPlayer.this.player = player;
            return this;
        }

        public Builder setGroup(Group group) {
            RPlayer.this.group = group;
            return this;
        }

        public Builder setGroup(Integer id) {
            RPlayer.this.group = reGroup(id);
            return this;
        }

        public Builder setCoins(Integer coins) {
            RPlayer.this.coins = coins;
            return this;
        }

        public Builder addCoins(Integer coins) {
            RPlayer.this.coins += coins;
            return this;
        }

        public Builder setLevel(Integer level) {
            RPlayer.this.level = level;
            return this;
        }

        public Builder addLevel(Integer level) {
            RPlayer.this.level += level;
            return this;
        }

        public Builder setXp(Integer xp) {
            RPlayer.this.xp = xp;
            return this;
        }

        public Builder addXp(Integer xp) {
            RPlayer.this.xp += xp;
            return this;
        }

        public Builder setIsBanned(Boolean isBanned) {
            RPlayer.this.banActive = isBanned;
            return this;
        }

        public Builder setIsMuted(Boolean isMuted) {
            RPlayer.this.muteActive = isMuted;
            return this;
        }

        public Builder setBannedBy(String bannedBy) {
            RPlayer.this.bannedBy = bannedBy;
            return this;
        }

        public Builder setBanReason(String banReason) {
            RPlayer.this.banReason = banReason;
            return this;
        }

        public Builder setBanEnd(Long banEnd) {
            RPlayer.this.banEnd = banEnd;
            return this;
        }

        public Builder setBanOn(Long banOn) {
            RPlayer.this.banOn = banOn;
            return this;
        }

        public Builder setAmountBans(Integer amountBans) {
            RPlayer.this.amountBans = amountBans;
            return this;
        }

        public Builder setBanActive(Boolean banActive) {
            RPlayer.this.banActive = banActive;
            return this;
        }

        public Builder setMutedBy(String mutedBy) {
            RPlayer.this.mutedBy = mutedBy;
            return this;
        }

        public RPlayer build() {
            return RPlayer.this;
        }

        public Builder setMuteReason(String muteReason) {
            RPlayer.this.muteReason = muteReason;
            return this;
        }

        public Builder setMuteEnd(long muteEnd) {
            RPlayer.this.muteEnd = muteEnd;
            return this;
        }

        public Builder setMuteOn(long muteOn) {
            RPlayer.this.muteOn = muteOn;
            return this;
        }

        public Builder setAmountMutts(int amountMutts) {
            RPlayer.this.amountMutts = amountMutts;
            return this;
        }
    }

}
