package ged.daedaluswin.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Romanos Trechlis on 15/3/2015.
 */
public class ConnBroker {

    public final Logger logger = Logger.getLogger(this.getClass().getName());

    private static final String SQLiteDriver = "org.sqlite.JDBC";
    private static final String SQLiteUrl = "jdbc:sqlite:C:/Users/Mercutio Donnati/IdeaProjects/CRMServer/INIT_VARIABLE.db"; // it requires full pathafter ':'!
    private static final String selectQuery = "SELECT VALUE FROM VARIABLE WHERE NAME = ?";

    private static final String[] paramList = {"JDBC_URL", "JDBC_USERNAME", "JDBC_PASSWORD", "JDBC_DRIVER"};
    private static String[] valueList = new String[paramList.length];

    private static ConnBroker INSTANCE;

    public static ConnBroker getInstance(){
        if (INSTANCE == null)
            INSTANCE = new ConnBroker();
        return INSTANCE;
    }

    public Connection getConnection() throws Exception {
        Connection connection = null;
        try {
            Class.forName(valueList[3]);
            connection = DriverManager.getConnection(valueList[0], valueList[1], valueList[2]);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "##### Unable to create connection to: " + valueList[0]);
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

    private ConnBroker() {
        try {
            getConstantVariables();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "##### Error: " + e);
        }
    }

    private void getConstantVariables() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(SQLiteDriver);
            connection = DriverManager.getConnection(SQLiteUrl);
            logger.log(Level.INFO, "##### Retrieving constants from SQLite db!");
            for (int i = 0; i < paramList.length; i++) {
                preparedStatement = connection.prepareStatement(selectQuery);
                preparedStatement.setString(1, paramList[i]);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                    valueList[i] = resultSet.getString("VALUE");
            }
            logger.log(Level.INFO, "##### Constants retrieved!");
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "##### Retrieval failed!");
            throw e;
        }catch (SQLException e) {
            logger.log(Level.SEVERE, "##### SeQueL Exception!");
            throw e;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "##### Generic Exception!");
            throw e;
        } finally {
            try {
                logger.log(Level.INFO, "##### Closing connection...");
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
                if (!connection.isClosed()) connection.close();
                logger.log(Level.INFO, "##### Connection closed!");
            } catch (SQLException e) {
                logger.log(Level.WARNING, "##### Failed to close connection!");
            }
        }
    }
}
