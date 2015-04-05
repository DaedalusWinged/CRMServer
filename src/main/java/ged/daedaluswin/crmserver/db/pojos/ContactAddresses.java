package ged.daedaluswin.crmserver.db.pojos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
@XmlRootElement
public class ContactAddresses implements java.io.Serializable {
    private int id;
    private Contacts contacts;
    private String address;
    private Integer streetNo;
    private Integer postalCode;
    private String city;

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public Contacts getContacts() {return contacts;}
    @XmlTransient
    public void setContacts(Contacts contacts) {this.contacts = contacts;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactAddresses that = (ContactAddresses) o;

        if (id != that.id) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        if (streetNo != null ? !streetNo.equals(that.streetNo) : that.streetNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (streetNo != null ? streetNo.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
