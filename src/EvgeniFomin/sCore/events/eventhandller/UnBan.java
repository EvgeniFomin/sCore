package EvgeniFomin.sCore.events.eventhandller;

import EvgeniFomin.sCore.events.HandlerList;
import EvgeniFomin.sCore.events.coreEvents.CoreUnBanEvent;
import EvgeniFomin.sCore.objects.RPlayer;

public class UnBan {
    private RPlayer unBanned;

    public UnBan(RPlayer player, RPlayer unMuted){
        this.unBanned = unMuted;
        CoreUnBanEvent e = new CoreUnBanEvent(player,unMuted);
        CoreUnBanEvent event = HandlerList.callEvent(e);
    }

    public UnBan(RPlayer player){
        this.unBanned = new RPlayer("CONSOLE");
        CoreUnBanEvent e = new CoreUnBanEvent(player, unBanned);
        CoreUnBanEvent event = HandlerList.callEvent(e);
    }
}
