package EvgeniFomin.sCore.utils;

public enum TimeUnit {
    MILLISECOND(1L, new String[] { "milliseconds", "millisecond", "millis", "milli", "mil", "mils" }), 
    SECOND(1000L, new String[] { "seconds", "second", "secs", "sec", "s" }), 
    MINUTE(60000L, new String[] { "minutes", "minute", "mins", "min", "m" }), 
    HOUR(3600000L, new String[] { "hours", "hour", "h" }), 
    DAY(86400000L, new String[] { "days", "day", "d" }), 
    WEEK(604800000L, new String[] { "weeks", "week", "w" }), 
    MONTH(-1702967296L, new String[] { "months", "month", "mon" }), 
    YEAR(1471228928L, new String[] { "years", "year", "y" });
    
    private long milliseconds;
    private String[] names;
    
    private TimeUnit(long milliseconds, String[] names) {
        this.milliseconds = milliseconds;
        this.names = names;
    }
    
    public long getMilliseconds() {
        return this.milliseconds;
    }
    
    public String[] getNames() {
        return this.names;
    }
    
    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }
    
    public void setNames(String[] names) {
        this.names = names;
    }
    
    public static TimeUnit find(String name) {
        for (TimeUnit tu : values()) {
            for (String n : tu.getNames()) {
                if (n.equalsIgnoreCase(name)) {
                    return tu;
                }
            }
        }
        return null;
    }
}
