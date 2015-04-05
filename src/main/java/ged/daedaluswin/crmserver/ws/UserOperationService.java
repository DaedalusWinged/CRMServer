package ged.daedaluswin.crmserver.ws;

import ged.daedaluswin.crmserver.helper.ConnBroker;
import ged.daedaluswin.crmserver.helper.HibernateUtil;
import ged.daedaluswin.crmserver.db.pojos.ContactAddresses;
import ged.daedaluswin.crmserver.db.pojos.Contacts;
import ged.daedaluswin.crmserver.helper.DaedalusXmlUtil;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class UserOperationService {

    @WebMethod(operationName = "sayHello")
    public String sayHello(@WebParam(name = "userName") String userName) {
        //String address = getAddressFromUserName(userName);
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

    public static void main(String[] args) {

        // run first
/*
        Contacts contacts = (Contacts)HibernateUtil.executeSelect("from Contacts where firstName = 'Romanos'").get(0);
        ContactAddresses ca1 = new ContactAddresses();
        ContactAddresses ca2 = new ContactAddresses();
        ca1.setAddress("Martinegkou");
        ca1.setContacts(contacts);
        ca2.setAddress("Valimitika");
        ca2.setContacts(contacts);
        Set<ContactAddresses> addressesList = new HashSet<ContactAddresses>();
        addressesList.add(ca1);
        addressesList.add(ca2);
        contacts.setAddress(addressesList);

        //System.out.println(DaedalusXmlUtil.toXML(contacts));
        String my = DaedalusXmlUtil.toXML(contacts);
        System.out.println(my);
        //Contacts newContacts = (Contacts)DaedalusXmlUtil.toPojo(my, contacts.getClass());
        //System.out.println(newContacts.getFirstName() + " " + newContacts.getLastName());

        HibernateUtil.saveOrUpdate(contacts);
*/
        //run 2. comment above
        Contacts contacts = (Contacts)HibernateUtil.executeSelect("from Contacts where firstName = 'Romanos'").get(0);
        String my = DaedalusXmlUtil.toXML(contacts);
        System.out.println(my);
/* Result
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<contacts id="1000019">
    <activationDate>
        <nanos>3000000</nanos>
    </activationDate>
    <address id="1">
        <address>Martinegkou</address>
    </address>
    <address id="2">
        <address>Valimitika</address>
    </address>
    <firstName>Romanos</firstName>
    <lastName>Trechlis</lastName>
</contacts>
*/
        Contacts newContacts = (Contacts)DaedalusXmlUtil.toPojo(my, contacts.getClass());
        System.out.println(newContacts.getFirstName() + " " + newContacts.getLastName());
    }
}