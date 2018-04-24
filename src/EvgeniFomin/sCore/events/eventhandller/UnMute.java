package EvgeniFomin.sCore.events.eventhandller;

import EvgeniFomin.sCore.events.HandlerList;
import EvgeniFomin.sCore.events.coreEvents.CoreUnmuteEvent;
import EvgeniFomin.sCore.objects.RPlayer;

public class UnMute {
    private RPlayer unMuted;

    public UnMute(RPlayer player, RPlayer unMuted){
        this.unMuted = unMuted;
        CoreUnmuteEvent e = new CoreUnmuteEvent(player,unMuted);
        CoreUnmuteEvent event = HandlerList.callEvent(e);
    }

    public UnMute(RPlayer player){
        this.unMuted = new RPlayer("CONSOLE");
        CoreUnmuteEvent e = new CoreUnmuteEvent(player,unMuted);
        CoreUnmuteEvent event = HandlerList.callEvent(e);
    }
}
