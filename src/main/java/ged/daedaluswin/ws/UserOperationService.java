package ged.daedaluswin.ws;

import ged.daedaluswin.db.ConnBroker;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.*;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class UserOperationService {

    @WebMethod(operationName = "sayHello")
    public String sayHello(@WebParam(name = "userName") String userName) {
        String address = getAddressFromUserName(userName);
        return "Hello " + userName + " from " + address;
    }

    private String getAddressFromUserName(String userName) {
        String address = "";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnBroker.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT ADDRESS FROM TESTING_ENV WHERE NAME = ?");
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) address = resultSet.getString("ADDRESS");

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
        return address;
    }

    public void main(String[] args) {
        UserOperationService userOperationService = new UserOperationService();
        System.out.println(userOperationService.sayHello("Romanos"));
    }
}