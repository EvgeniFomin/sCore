package EvgeniFomin.sCore.utils.configManager;

import EvgeniFomin.sCore.other.Messages;
import EvgeniFomin.sCore.utils.logger.Logger;

import java.util.ArrayList;

public class ConfigManager {
    private static Config config;
    private static Config messages;

    public static void init() {
        ConfigManager.config = new Config("config.yml", "config.yml");
        ConfigManager.messages = new Config("messages.yml", "messages.yml");
        Logger.getLogger().message("Загрузка config.yml");
        ConfigManager.config.initialize();
        Logger.getLogger().message("Загрузка messages.yml");
        ConfigManager.messages.initialize();
        Logger.getLogger().message(Messages.FILES_SUCCESSFULLY_DOWNLOADED);
    }

    public static Config config() {
        return ConfigManager.config;
    }

    public static Config messages() {
        return ConfigManager.messages;
    }

    public static String cv(String path) {
        return ConfigManager.config.c().getString(path);
    }

    public static String txt(String path) {
        return ConfigManager.config.c().getString(path);
    }

    public static String txt2(String path) {
        String str = "";
        for (final String line : ConfigManager.config.c().getStringList(path)) {
            str = str + line + "\n";
        }
        return str;
    }

    public static ArrayList<String> txt3(String path) {
        ArrayList<String> lines = new ArrayList<String>();
        for (String line : ConfigManager.config.c().getStringList(path)) {
            lines.add(line);
        }
        return lines;
    }
}