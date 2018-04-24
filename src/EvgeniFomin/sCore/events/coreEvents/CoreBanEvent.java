package EvgeniFomin.sCore.events.coreEvents;

import EvgeniFomin.sCore.Core;
import EvgeniFomin.sCore.events.Event;
import EvgeniFomin.sCore.objects.RPlayer;

import static EvgeniFomin.sCore.utils.Padezh.padezh;

public class CoreBanEvent implements Event {
    private RPlayer bannedPlayer;
    private RPlayer bannedBy;
    private String banReason;
    private Long banEnd;
    private Long bannedOn;
    private boolean active;

    public CoreBanEvent(RPlayer bannedPlayer, RPlayer bannedBy, long milliseconds, String banReason) {
        this.bannedPlayer = bannedPlayer;
        this.bannedBy = bannedBy;
        this.banReason = banReason;
        this.bannedOn = System.currentTimeMillis();
        if (milliseconds != -1L) {
            this.banEnd = System.currentTimeMillis() + milliseconds;
        } else {
            this.banEnd = milliseconds;
        }
        this.active = true;
        bannedPlayer.setBannedBy(bannedBy.getName());
        bannedPlayer.setBanEnd(banEnd);
        bannedPlayer.setBanOn(bannedOn);
        bannedPlayer.setBanReason(banReason);
        bannedPlayer.setAmountBans((bannedPlayer.getAmountBans() + 1));
        bannedPlayer.setBanActive(true);
        Core.getInstance().getrPlayerManager().save(bannedPlayer.getName());
    }

    public RPlayer getBannedPlayer() {
        return bannedPlayer;
    }

    public String getBanReason() {
        return this.banReason;
    }

    public RPlayer getBannedBy() {
        return this.bannedBy;
    }

    public long getBanEnd() {
        return this.banEnd;
    }

    public long getBannedOn() {
        return this.bannedOn;
    }

    private boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean isValid() {
        return this.isActive() && (this.banEnd > System.currentTimeMillis() || this.banEnd == -1L);
    }

    public String remainingTime() {
        if (!this.isValid()) {
            return null;
        }
        if (this.banEnd == -1L) {
            return "Навсегда";
        }
        long seconds = (this.banEnd - System.currentTimeMillis()) / 1000L;
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
