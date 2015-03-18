package ged.daedaluswin.ws;

import ged.daedaluswin.db.ConnBroker;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.*;

@WebService()
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public class UserOperationService {

    @WebMethod(operationName = "sayHello")
    public String sayHelloToTheUser(@WebParam(name = "name") String userName) {
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

        return "Hello " + userName + " from " + address;
    }

    public static void main(String[] args) {
        UserOperationService userOperationService = new UserOperationService();
        System.out.println(userOperationService.sayHelloToTheUser("Romanos"));
    }
}