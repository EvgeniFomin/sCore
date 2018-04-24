package EvgeniFomin.sCore.events.coreEvents;

import EvgeniFomin.sCore.Core;
import EvgeniFomin.sCore.events.Event;
import EvgeniFomin.sCore.objects.RPlayer;

public class CoreUnmuteEvent implements Event {
    private RPlayer mutedPlayer;
    private RPlayer unMutedBy;

    public CoreUnmuteEvent(RPlayer player, RPlayer mutedBy) {
        this.mutedPlayer = player;
        this.unMutedBy = mutedBy;
        if (player.getMuteActive()) {
            player.setMutedBy("");
            player.setMuteReason("");
            player.setMuteOn(0L);
            player.setMuteEnd(0L);
            player.setMuteActive(false);
            Core.getInstance().getrPlayerManager().save(player.getName());
        }
    }

    public RPlayer getUnMutedPlayer() {
        return mutedPlayer;
    }

    public RPlayer getUnMutedBy() {
        return this.unMutedBy;
    }
}