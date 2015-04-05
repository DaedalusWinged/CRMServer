package ged.daedaluswin.crmserver.helper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
public class DaedalusXmlUtil {

    /**
     * Helper method that turns a pojo to an xml that contains only
     * filled fields.
     *
     * @param obj
     * @return
     */
    public static String toXML(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, stringWriter);
        } catch (JAXBException e) {e.printStackTrace();}
        return stringWriter.toString();
    }

/*
    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        contacts.setFirstName("Romanos");
        contacts.setLastName("Trechlis");
        System.out.println(DaedalusXmlUtil.toXML(contacts));
    }
*/
}
