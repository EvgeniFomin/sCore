package EvgeniFomin.sCore.events.eventhandller;

import EvgeniFomin.sCore.events.HandlerList;
import EvgeniFomin.sCore.events.coreEvents.CoreBanEvent;
import EvgeniFomin.sCore.objects.RPlayer;
import EvgeniFomin.sCore.utils.TimeUnit;

public class Ban {
    private RPlayer bannedBy;
    private String reason;

    public Ban(RPlayer player, RPlayer bannedBy, long milliseconds, String format, String reason) {
        this.bannedBy = bannedBy;
        this.reason = reason;
        long millis = milliseconds;
        TimeUnit tu = TimeUnit.find(format);
        millis *= tu.getMilliseconds();
        CoreBanEvent e = new CoreBanEvent(player, bannedBy, millis, reason);
        CoreBanEvent event = HandlerList.callEvent(e);
    }

    public Ban(RPlayer player, long milliseconds, String format, String reason) {
        this.bannedBy = new RPlayer("CONSOLE");
        this.reason = reason;
        long millis = milliseconds;
        TimeUnit tu = TimeUnit.find(format);
        millis *= tu.getMilliseconds();
        CoreBanEvent e = new CoreBanEvent(player, bannedBy, millis, reason);
        CoreBanEvent event = HandlerList.callEvent(e);
    }

    public Ban(RPlayer player, RPlayer bannedBy, String reason) {
        this.bannedBy = bannedBy;
        this.reason = reason;
        CoreBanEvent e = new CoreBanEvent(player, bannedBy, -1L, reason);
        CoreBanEvent event = HandlerList.callEvent(e);
    }

    public Ban(RPlayer player, RPlayer bannedBy, long milliseconds, String format) {
        this.bannedBy = bannedBy;
        this.reason = "Без причины";
        long millis = milliseconds;
        TimeUnit tu = TimeUnit.find(format);
        millis *= tu.getMilliseconds();
        CoreBanEvent e = new CoreBanEvent(player, bannedBy, millis, reason);
        CoreBanEvent event = HandlerList.callEvent(e);
    }

    public Ban(RPlayer player) {
        this.bannedBy = new RPlayer("CONSOLE");
        this.reason = "Без причины";
        CoreBanEvent e = new CoreBanEvent(player, bannedBy, -1L, reason);
        CoreBanEvent event = HandlerList.callEvent(e);
    }

    public Ban(RPlayer player, RPlayer bannedBy) {
        this.bannedBy = bannedBy;
        this.reason = "Без причины";
        CoreBanEvent e = new CoreBanEvent(player, bannedBy, -1L, reason);
        CoreBanEvent event = HandlerList.callEvent(e);
    }
}
