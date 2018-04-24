package EvgeniFomin.sCore;

import EvgeniFomin.sCore.console.Console;
import EvgeniFomin.sCore.other.Messages;
import EvgeniFomin.sCore.rListener.*;
import EvgeniFomin.sCore.dataBase.SQL;
import EvgeniFomin.sCore.utils.configManager.ConfigManager;
import EvgeniFomin.sCore.other.Error;
import EvgeniFomin.sCore.utils.logger.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            Logger.getLogger().message(Messages.PREPARATION_FOR_STARTING);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Logger.getLogger().message(Error.ERROR_4);
        }
        Logger.getLogger().message(Messages.INIT_EVENTS);
        new RPlayerListener().onEnable();
        Logger.getLogger().message(Messages.INIT_CONFIG);
        ConfigManager.init();
        Logger.getLogger().message(Messages.PREPARATION_NETTY_SERVER);
        Core.getInstance().initNettyServer();
        Logger.getLogger().message(Messages.LOADING_DATA_MYSQL);
        Core.setSql(new SQL(ConfigManager.config().c().getString("mysql.hostname"), Integer.parseInt(ConfigManager.config().c().getString("mysql.port")), ConfigManager.config().c().getString("mysql.username"), ConfigManager.config().c().getString("mysql.password"), ConfigManager.config().c().getString("mysql.database")));
        Logger.getLogger().message(Messages.INIT_SQL);
        Core.getInstance().initSQL();
        Logger.getLogger().message(Messages.LOADING_CONSOLE_MANAGER);
        new Console();
        Logger.getLogger().message(Messages.LOADING_SUCCESSFULLY);
        Logger.getLogger().message(Messages.CONSOLE_HELP);

//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(() -> System.out.println("1"), 1, 1, TimeUnit.SECONDS);
    }
}