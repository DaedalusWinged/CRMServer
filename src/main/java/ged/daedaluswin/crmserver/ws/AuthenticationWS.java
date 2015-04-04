package ged.daedaluswin.crmserver.ws;

import ged.daedaluswin.crmserver.db.ConnBroker;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TeoGia on 02 April 2015.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class AuthenticationWS {

    private static final String sqlQuery = "SELECT count(Users.ID) as 'count' FROM Users WHERE Users.Username = ? and Users.Password = ?";

    @WebMethod(operationName = "authenticateUser")
    public Boolean authenticateUser(@WebParam(name = "userName") String userName,
                                    @WebParam(name = "password") String password) {

        return authenticateUserDBreq(userName, password);
    }

    private Boolean authenticateUserDBreq(String userName, String password) {
        Boolean userAuthenticated = false;
        Integer count;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnBroker.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
                if (count == 1) {
                    userAuthenticated = true;
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (!connection.isClosed()) connection.close();
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
            }
        }
        return userAuthenticated;
    }
}