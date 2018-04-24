package EvgeniFomin.sCore.events.eventhandller;

import EvgeniFomin.sCore.events.HandlerList;
import EvgeniFomin.sCore.events.Listener;
import EvgeniFomin.sCore.events.Plugin;
import EvgeniFomin.sCore.events.coreEvents.CoreKickEvent;
import EvgeniFomin.sCore.objects.RPlayer;


public class Kick extends Plugin implements Listener {
    private RPlayer kickedBy;
    private String reason;

    public Kick(RPlayer player, RPlayer kickedBy, String reason) {
        this.kickedBy = kickedBy;
        this.reason = reason;
        CoreKickEvent e = new CoreKickEvent(player, kickedBy, reason);
        CoreKickEvent event = HandlerList.callEvent(e);
    }

    public Kick(RPlayer player, RPlayer kickedBy) {
        this.kickedBy = kickedBy;
        this.reason = "Без причины";
        CoreKickEvent e = new CoreKickEvent(player, kickedBy, reason);
        CoreKickEvent event = HandlerList.callEvent(e);
    }

    public Kick(RPlayer player, String reason) {
        this.kickedBy = new RPlayer("CONSOLE");
        this.reason = reason;
        CoreKickEvent e = new CoreKickEvent(player, kickedBy, reason);
        CoreKickEvent event = HandlerList.callEvent(e);
    }

    public Kick(RPlayer player) {
        this.kickedBy = new RPlayer("CONSOLE");
        this.reason = "Без причины";
        CoreKickEvent e = new CoreKickEvent(player, kickedBy, reason);
        CoreKickEvent event = HandlerList.callEvent(e);
    }
}