package ged.daedaluswin.ws;

import ged.daedaluswin.db.ConnBroker;

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

    @WebMethod(operationName = "AuthenticateUser")
    public Boolean AuthenticateUser(@WebParam(name = "userName") String userName,
                                   @WebParam(name = "password") String password) throws SQLException{

        return AuthenticateUserDBreq(userName, password);
    }

    private Boolean AuthenticateUserDBreq(String userName, String password) throws SQLException{
        Boolean UserAuthenticated = false;
        Integer count;
        Connection connection = null;
        PreparedStatement preparedStatement;

        String sqlQuery = "SELECT count(Users.ID) as 'count' FROM Users WHERE Users.Username = ? and Users.Password = ?";

        try {
            connection = ConnBroker.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
                if (count == 1) {
                    UserAuthenticated = true;
                }
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (!connection.isClosed()) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return UserAuthenticated;
    }

    public void main(String[] args) {
        AuthenticationWS authenticationWS = new AuthenticationWS();

    }
}