package ged.daedaluswin.crmserver.db.pojos;

import javax.persistence.*;

/**
 * Created by Mercutio Donnati on 1/4/2015.
 */
@Entity
@Table(name = "ContactPhones", schema = "crm", catalog = "CRM_UAT")
public class ContactPhonesEntity {
    private int id;
    private String phone;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactPhonesEntity that = (ContactPhonesEntity) o;

        if (id != that.id) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
