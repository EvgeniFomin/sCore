package EvgeniFomin.sCore.events.coreEvents;

import EvgeniFomin.sCore.events.Event;
import EvgeniFomin.sCore.objects.RPlayer;

public class CoreKickEvent implements Event {
    private RPlayer player;
    private RPlayer kickedBy;
    private String kickReason;

    public CoreKickEvent(RPlayer player, RPlayer kickedBy, String kickReason) {
        this.player = player;
        this.kickedBy = kickedBy;
        this.kickReason = kickReason;
    }

    public RPlayer getPlayer() {
        return player;
    }

    public RPlayer getKickedBy() {
        return kickedBy;
    }

    public String getKickReason() {
        return kickReason;
    }
}

