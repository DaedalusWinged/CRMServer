package ged.daedaluswin.crmserver.ws;

import ged.daedaluswin.crmserver.db.ConnBroker;

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
        if (address == "") {
            return "No Contact found by the name " + userName;
        } else {
            return "Hello " + userName + " from " + address;
        }

    }

    private String getAddressFromUserName(String userName) {
        String address = "";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnBroker.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("select ContactAddresses.Address from Contacts inner join ContactAddresses on Contacts.ID = ContactAddresses.ContactID where Contacts.FirstName like ?;");
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
        //System.out.println(userOperationService.sayHello("Tsirkos"));
    }
}