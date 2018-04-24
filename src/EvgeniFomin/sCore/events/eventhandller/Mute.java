package EvgeniFomin.sCore.events.eventhandller;

import EvgeniFomin.sCore.events.HandlerList;
import EvgeniFomin.sCore.events.coreEvents.CoreMuteEvent;
import EvgeniFomin.sCore.objects.RPlayer;
import EvgeniFomin.sCore.utils.TimeUnit;

public class Mute {
    private RPlayer mutedBy;
    private String reason;

    public Mute(RPlayer player, RPlayer mutedBy, long milliseconds, String format, String reason) {
        this.mutedBy = mutedBy;
        this.reason = reason;
        long millis = milliseconds;
        TimeUnit tu = TimeUnit.find(format);
        millis *= tu.getMilliseconds();
        CoreMuteEvent e = new CoreMuteEvent(player,mutedBy, millis, reason);
        CoreMuteEvent event = HandlerList.callEvent(e);
    }

    public Mute(RPlayer player, long milliseconds, String format, String reason) {
        this.mutedBy = new RPlayer("CONSOLE");
        this.reason = reason;
        long millis = milliseconds;
        TimeUnit tu = TimeUnit.find(format);
        millis *= tu.getMilliseconds();
        CoreMuteEvent e = new CoreMuteEvent(player,mutedBy, millis, reason);
        CoreMuteEvent event = HandlerList.callEvent(e);
    }

    public Mute(RPlayer player, RPlayer mutedBy, String reason) {
        this.mutedBy = mutedBy;
        this.reason = reason;
        CoreMuteEvent e = new CoreMuteEvent(player,mutedBy, -1L, reason);
        CoreMuteEvent event = HandlerList.callEvent(e);
    }

    public Mute(RPlayer player, RPlayer mutedBy, long milliseconds, String format) {
        this.mutedBy = mutedBy;
        this.reason = "Без причины";
        long millis = milliseconds;
        TimeUnit tu = TimeUnit.find(format);
        millis *= tu.getMilliseconds();
        CoreMuteEvent e = new CoreMuteEvent(player,mutedBy, millis, reason);
        CoreMuteEvent event = HandlerList.callEvent(e);
    }

    public Mute(RPlayer player) {
        this.mutedBy = new RPlayer("CONSOLE");
        this.reason = "Без причины";
        CoreMuteEvent e = new CoreMuteEvent(player,mutedBy, -1L, reason);
        CoreMuteEvent event = HandlerList.callEvent(e);
    }

    public Mute(RPlayer player, RPlayer mutedBy) {
        this.mutedBy = mutedBy;
        this.reason = "Без причины";
        CoreMuteEvent e = new CoreMuteEvent(player,mutedBy, -1L, reason);
        CoreMuteEvent event = HandlerList.callEvent(e);
    }
}
