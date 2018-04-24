package EvgeniFomin.sCore.console;


import EvgeniFomin.sCore.Core;
import EvgeniFomin.sCore.other.Messages;
import EvgeniFomin.sCore.utils.logger.Logger;

import java.util.Scanner;

import static EvgeniFomin.sCore.Core.исходящих;
import static EvgeniFomin.sCore.Core.принятых;

public class Console {

    private CMemory cMemory = new CMemory();

    public Console() {
        Runnable task = () -> {
            while (true) {
                String scanner = new Scanner(System.in).next();
                if (scanner.equalsIgnoreCase("gc")) {
                    Logger.getLogger().message("Всего памяти: " + this.cMemory.getMaximumMemory() + "мб.");
                    Logger.getLogger().message("Используется памяти: " + this.cMemory.getUsedMemory() + "мб.");
                    Logger.getLogger().message("Свободно памяти: " + this.cMemory.getFreeMemory() + "мб.");
                    Logger.getLogger().message("Принятых пакетов: " + принятых);
                    Logger.getLogger().message("Исходящих пакетов: " + исходящих);
                }
                if (scanner.equalsIgnoreCase("end")) {
                    Core.getInstance().stop();
                } else if (scanner.equalsIgnoreCase("Proxy")) {
                    Logger.getLogger().message("Подключеные прокси к кору: " + Core.getInstance().getProxies());
                } else if (scanner.equalsIgnoreCase("online")) {

                    Logger.getLogger().message("Общий онлайн: " + Core.getInstance().getOnline());
                } else if (scanner.equalsIgnoreCase("server")) {

                    Logger.getLogger().message("Подключеные сервера к кору: " + Core.getInstance().getServers());
                } else if (scanner.equalsIgnoreCase("help")) {
                    Logger.getLogger().message("Список команд:");
                    Logger.getLogger().message("end - Остановить Core.");
                    Logger.getLogger().message("Proxy - Получить список все подключеных Proxy.");
                    Logger.getLogger().message("server - Получить список все подключеных Серверов.");
                    Logger.getLogger().message("online - Получить онлайн со всех серверов.");
                    Logger.getLogger().message("gc - Получить список используемых ресурсов кором.");
                    Logger.getLogger().message("notice - Отправить сообщение на все серера.");
                } else {
                    Logger.getLogger().message("Неизвестная команда: " + scanner);
                }
            }
        };
        Thread ConsoleThread = new Thread(task);
        ConsoleThread.start();
        Logger.getLogger().message(Messages.SUCCESSFULLY_LAUNCHED_CONSOLE_MANAGER);
    }
}

