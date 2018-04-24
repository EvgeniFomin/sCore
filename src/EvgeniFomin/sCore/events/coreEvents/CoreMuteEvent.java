package EvgeniFomin.sCore.events.coreEvents;

import EvgeniFomin.sCore.Core;
import EvgeniFomin.sCore.events.Event;
import EvgeniFomin.sCore.objects.RPlayer;

import static EvgeniFomin.sCore.utils.Padezh.padezh;

public class CoreMuteEvent implements Event {
    private RPlayer mutedPlayer;
    private RPlayer mutedBy;
    private String muteReason;
    private Long muteEnd;
    private Long mutedOn;
    private boolean active;

    public CoreMuteEvent(RPlayer player, RPlayer mutedBy, long milliseconds, String muteReason) {
        this.mutedPlayer = player;
        this.mutedBy = mutedBy;
        this.muteReason = muteReason;
        this.mutedOn = System.currentTimeMillis();
        if (milliseconds != -1L) {
            this.muteEnd = System.currentTimeMillis() + milliseconds;
        } else {
            this.muteEnd = milliseconds;
        }
        this.active = true;
        player.setMutedBy(mutedBy.getName());
        player.setMuteEnd(muteEnd);
        player.setMuteOn(mutedOn);
        player.setMuteReason(muteReason);
        player.setAmountMutts((player.getAmountMutts() + 1));
        player.setMuteActive(true);
        Core.getInstance().getrPlayerManager().save(player.getName());
    }

    public RPlayer getMutedPlayer() {
        return mutedPlayer;
    }

    public String getMuteReason() {
        return this.muteReason;
    }

    public RPlayer getMutedBy() {
        return this.mutedBy;
    }

    public long getMuteEnd() {
        return this.muteEnd;
    }

    public long getMutedOn() {
        return this.mutedOn;
    }

    private boolean isActive() {
        return this.active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    private boolean isValid() {
        return this.isActive() && (this.muteEnd > System.currentTimeMillis() || this.muteEnd == -1L);
    }

    public String remainingTime() {
        if (!this.isValid()) {
            return null;
        }
        if (this.muteEnd == -1L) {
            return "Навсегда";
        }
        long seconds = (this.muteEnd - System.currentTimeMillis()) / 1000L;
        long minutes = 0L;
        while (seconds >= 60L) {
            ++minutes;
            seconds -= 60L;
        }
        long hours = 0L;
        while (minutes >= 60L) {
            ++hours;
            minutes -= 60L;
        }
        long days = 0L;
        while (hours >= 24L) {
            ++days;
            hours -= 24L;
        }

        String sDay = padezh("Д", "ень", "ня", "ней", (int) days);//Days
        String sHours = padezh("час", "", "а", "ов", (int) hours);//Hours
        String sMinutes = padezh("минут", "а", "ы", "", (int) minutes);//Minutes
        String sSeconds = padezh("секун", "да", "ды", "д", (int) seconds);//Seconds
        return "" + days + " " + sDay + ", " + hours + " " + sHours + ", " + minutes + " " + sMinutes + " и " + seconds + " " + sSeconds + ".".replace("{days}", days + "").replace("{hours}", hours + "").replace("{minutes}", minutes + "").replace("{secs}", seconds + "");
    }
}
