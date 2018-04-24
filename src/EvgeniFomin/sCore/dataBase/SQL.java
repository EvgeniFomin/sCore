package EvgeniFomin.sCore.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL
{
    private DriverType driver;
    private Connection connection;
    private String filename;
    private String hostname;
    private int port;
    private String username;
    private String password;
    private String database;

    public SQL(final String filename) {
        this.connection = null;
        this.filename = filename;
        this.driver = DriverType.SQLITE;
    }

    public SQL(final String hostname, final int port, final String username, final String password, final String database) {
        this.connection = null;
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
        this.driver = DriverType.MYSQL;
    }

    public boolean isConnected() {
        return this.connection != null;
    }

    public void openConnection() {
        if (!this.isConnected()) {
            try {
                if (this.driver == DriverType.MYSQL) {
                    Class.forName("com.mysql.jdbc.Driver");
                    this.connection = DriverManager.getConnection("jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database + "?autoReconnect=true", this.username, this.password);
                }
                else if (this.driver == DriverType.SQLITE) {
                    Class.forName("org.sqlite.JDBC");
                    this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.filename);
                }
            }
            catch (SQLException | ClassNotFoundException ex2) {
                final Exception ex;
                final Exception e = ex2;
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() {
        if (this.isConnected()) {
            try {
                this.connection.close();
                this.connection = null;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(final String query) {
        if (this.isConnected()) {
            try {
                this.connection.prepareStatement(query).executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet getResult(final String query) {
        if (this.isConnected()) {
            try {
                return this.connection.prepareStatement(query).executeQuery();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public DriverType getDriver() {
        return this.driver;
    }

    public int getPort() {
        return this.port;
    }

    public String getDatabase() {
        return this.database;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getHostname() {
        return this.hostname;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    public void setDatabase(final String database) {
        this.database = database;
    }

    public void setDriver(final DriverType driver) {
        this.driver = driver;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    public void setHostname(final String hostname) {
        this.hostname = hostname;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setPort(final int port) {
        this.port = port;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public enum DriverType
    {
        MYSQL,
        SQLITE;
    }
}
