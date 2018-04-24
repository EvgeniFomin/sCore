package EvgeniFomin.sCore.rListener;

import EvgeniFomin.sCore.other.Messages;
import EvgeniFomin.sCore.events.EventHandler;
import EvgeniFomin.sCore.events.HandlerList;
import EvgeniFomin.sCore.events.Listener;
import EvgeniFomin.sCore.events.Plugin;
import EvgeniFomin.sCore.events.coreEvents.*;
import EvgeniFomin.sCore.utils.logger.Logger;

public class RPlayerListener extends Plugin implements Listener {

    public void onEnable() {
        HandlerList.registerEvent(this);
        Logger.getLogger().message(Messages.EVENT_REGISTERED);
    }

    @EventHandler
    public void onMute(CoreMuteEvent e) {
        System.out.println("Замучен: " + e.getMutedPlayer().getName());
        System.out.println("Замутил: " + e.getMutedBy().getName());
        System.out.println("Причина: " + e.getMuteReason());
        System.out.println("Время: " + e.remainingTime());
    }

    @EventHandler
    public void onBan(CoreBanEvent e) {
        System.out.println("Забанен: " + e.getBannedPlayer().getName());
        System.out.println("Забанил: " + e.getBannedBy().getName());
        System.out.println("Причина: " + e.getBanReason());
        System.out.println("Время: " + e.remainingTime());
    }

    @EventHandler
    public void onKick(CoreKickEvent e) {
        System.out.println("Кикнули: " + e.getPlayer().getName());
        System.out.println("Кикнул: " + e.getKickedBy().getName());
        System.out.println("Причина: " + e.getKickReason());
    }


        @EventHandler
    public void onUnBan(CoreUnBanEvent e) {
        System.out.println("Разбанен: " + e.getUnBannedPlayer().getName());
        System.out.println("Разбанил: " + e.getUnBannedBy().getName());
    }


    @EventHandler
    public void onUnMute(CoreUnmuteEvent e) {
        System.out.println("Размучен: " + e.getUnMutedPlayer().getName());
        System.out.println("Размутил: " + e.getUnMutedBy().getName());
    }
}
