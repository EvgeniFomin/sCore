package EvgeniFomin.sCore.utils.configManager;

import EvgeniFomin.sCore.utils.configuration.Configuration;
import EvgeniFomin.sCore.utils.configuration.file.YamlConfiguration;

import java.io.*;

public class Config {
    private String filename;
    private String defaultConfig;
    private Configuration configuration;
    private YamlConfiguration yamlConfiguration;

    public Config(String filename) {
        this.filename = filename;
    }

    Config(String filename, String defaultConfig) {
        this.filename = filename;
        this.defaultConfig = defaultConfig;
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(getConfigurationFile());
    }

    public void initialize() {
        File file = this.getConfigurationFile();
        if (!file.exists()) {
            try {
                file.createNewFile();
                if (this.defaultConfig != null) {
                    copy(getClass().getClassLoader().getResourceAsStream(getFilename()), getConfigurationFile());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.reload();
    }

    private void reload() {
        this.configuration = YamlConfiguration.loadConfiguration(getConfigurationFile());
    }

    public void save() {
        try {
            this.yamlConfiguration.save(getConfigurationFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];

            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private File getConfigurationFile() {
        return new File(this.filename);
    }

    public String getFilename() {
        return this.filename;
    }

    public Configuration c() {
        return this.configuration;
    }
}

