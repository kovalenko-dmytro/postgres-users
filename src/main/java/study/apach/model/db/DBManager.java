package study.apach.model.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private static Properties dbProperties;

    static {

        dbProperties = new Properties();

        try {
            BufferedReader reader = new BufferedReader(
                                    new FileReader("src\\main\\resources\\local\\db.properties"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] propertyLine = line.split("=");
                dbProperties.setProperty(propertyLine[0], propertyLine[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private DBManager(){};

    public static Connection createConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbProperties.getProperty("host"),
                                                        dbProperties.getProperty("user"),
                                                        dbProperties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
