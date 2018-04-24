package EvgeniFomin.sCore.utils.logger;

import EvgeniFomin.sCore.other.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logger;
    private String dateFormat = new SimpleDateFormat("HH:mm:ss").format(new Date());
    private String time = "[" + dateFormat + "]" + Messages.PREFIX;

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void message(String msg) {
        System.out.println(time + msg);
    }
}
