package ged.daedaluswin.crmserver.ws;

import ged.daedaluswin.crmserver.helper.DaedalusXmlUtil;
import ged.daedaluswin.crmserver.helper.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import java.util.Iterator;
import java.util.List;

/**
 * Created by TeoGia on 04 April 2015.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ContactManagementWS {

    @WebMethod(operationName = "getContactList")
    public String getContactList() {
       return contactList();
    }

    private String contactList() {
        String contactList = "";

        /* Method to  READ all the Contacts */
//        Contacts objectList =(Contacts) HibernateUtil.executeSelect("from Contacts where firstName = 'tsirkos'").get(0);
//        contactList = DaedalusXmlUtil.toXML(objectList);

        List<Object> objectList = HibernateUtil.executeSelect("from Contacts");
        for (Iterator iterator = objectList.iterator(); iterator.hasNext();){
            contactList = contactList + DaedalusXmlUtil.toXML(iterator.next());
        }

        return contactList;
    }
//        public void main(String[] args) {
//        ContactManagementWS contactManagementWS = new ContactManagementWS();
//        contactList();
//    }
}
//find one contact by id
//ContactsEntity contact= (ContactsEntity) session.get(ContactsEntity.class, new Integer(1000000));