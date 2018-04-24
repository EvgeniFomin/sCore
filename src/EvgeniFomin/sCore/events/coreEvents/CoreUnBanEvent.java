package EvgeniFomin.sCore.events.coreEvents;

import EvgeniFomin.sCore.Core;
import EvgeniFomin.sCore.events.Event;
import EvgeniFomin.sCore.objects.RPlayer;

public class CoreUnBanEvent implements Event {
    private RPlayer unBannedPlayer;
    private RPlayer unBannedBy;

    public CoreUnBanEvent(RPlayer player, RPlayer unBannedBy) {
        this.unBannedPlayer = player;
        this.unBannedBy = unBannedBy;
        if (player.getBanActive()) {
            player.setBannedBy("");
            player.setBanReason("");
            player.setBanOn(0L);
            player.setBanEnd(0L);
            player.setBanActive(false);
            Core.getInstance().getrPlayerManager().save(player.getName());
        }
    }

    public RPlayer getUnBannedPlayer() {
        return unBannedPlayer;
    }

    public RPlayer getUnBannedBy() {
        return this.unBannedBy;
    }

}