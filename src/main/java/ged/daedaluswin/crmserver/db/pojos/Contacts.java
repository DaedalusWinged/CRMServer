package ged.daedaluswin.crmserver.db.pojos;

import ged.daedaluswin.crmserver.helper.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
@XmlRootElement
public class Contacts implements java.io.Serializable {

    private int id;
    private Set<ContactAddresses> address = new HashSet<ContactAddresses>(0);
    private String lastName;
    private String firstName;
    private Short isPerson;
    private Short isAccount;
    private Short isCustomer;
    private Short isLead;
    private Short isSupplier;
    private Short isCompetitor;
    private Short isPartner;
    private Short isEmployee;
    private Integer tin;
    private Short maritalStatus;
    private Timestamp birthDate;
    private Short isActive;
    private Timestamp activationDate;
    private Timestamp deactivationDate;
    private Short sex;
    private String notes;
    
    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public Set<ContactAddresses> getAddress() {
        return address;
    }
    @XmlElement
    public void setAddress(Set<ContactAddresses> address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Short getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(Short isPerson) {
        this.isPerson = isPerson;
    }

    public Short getIsAccount() {
        return isAccount;
    }

    public void setIsAccount(Short isAccount) {
        this.isAccount = isAccount;
    }

    public Short getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Short isCustomer) {
        this.isCustomer = isCustomer;
    }

    public Short getIsLead() {
        return isLead;
    }

    public void setIsLead(Short isLead) {
        this.isLead = isLead;
    }

    public Short getIsSupplier() {
        return isSupplier;
    }

    public void setIsSupplier(Short isSupplier) {
        this.isSupplier = isSupplier;
    }

    public Short getIsCompetitor() {
        return isCompetitor;
    }

    public void setIsCompetitor(Short isCompetitor) {
        this.isCompetitor = isCompetitor;
    }

    public Short getIsPartner() {
        return isPartner;
    }

    public void setIsPartner(Short isPartner) {
        this.isPartner = isPartner;
    }

    public Short getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Short isEmployee) {
        this.isEmployee = isEmployee;
    }

    public Integer getTin() {
        return tin;
    }

    public void setTin(Integer tin) {
        this.tin = tin;
    }

    public Short getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Short maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public Timestamp getActivationDate() {
        return activationDate;
    }
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setActivationDate(Timestamp activationDate) {
        this.activationDate = activationDate;
    }

    public Timestamp getDeactivationDate() {
        return deactivationDate;
    }
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDeactivationDate(Timestamp deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts = (Contacts) o;

        if (id != contacts.id) return false;
        if (activationDate != null ? !activationDate.equals(contacts.activationDate) : contacts.activationDate != null)
            return false;
        if (birthDate != null ? !birthDate.equals(contacts.birthDate) : contacts.birthDate != null) return false;
        if (deactivationDate != null ? !deactivationDate.equals(contacts.deactivationDate) : contacts.deactivationDate != null)
            return false;
        if (firstName != null ? !firstName.equals(contacts.firstName) : contacts.firstName != null) return false;
        if (isAccount != null ? !isAccount.equals(contacts.isAccount) : contacts.isAccount != null) return false;
        if (isActive != null ? !isActive.equals(contacts.isActive) : contacts.isActive != null) return false;
        if (isCompetitor != null ? !isCompetitor.equals(contacts.isCompetitor) : contacts.isCompetitor != null)
            return false;
        if (isCustomer != null ? !isCustomer.equals(contacts.isCustomer) : contacts.isCustomer != null) return false;
        if (isEmployee != null ? !isEmployee.equals(contacts.isEmployee) : contacts.isEmployee != null) return false;
        if (isLead != null ? !isLead.equals(contacts.isLead) : contacts.isLead != null) return false;
        if (isPartner != null ? !isPartner.equals(contacts.isPartner) : contacts.isPartner != null) return false;
        if (isPerson != null ? !isPerson.equals(contacts.isPerson) : contacts.isPerson != null) return false;
        if (isSupplier != null ? !isSupplier.equals(contacts.isSupplier) : contacts.isSupplier != null) return false;
        if (lastName != null ? !lastName.equals(contacts.lastName) : contacts.lastName != null) return false;
        if (maritalStatus != null ? !maritalStatus.equals(contacts.maritalStatus) : contacts.maritalStatus != null)
            return false;
        if (notes != null ? !notes.equals(contacts.notes) : contacts.notes != null) return false;
        if (sex != null ? !sex.equals(contacts.sex) : contacts.sex != null) return false;
        if (tin != null ? !tin.equals(contacts.tin) : contacts.tin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (isPerson != null ? isPerson.hashCode() : 0);
        result = 31 * result + (isAccount != null ? isAccount.hashCode() : 0);
        result = 31 * result + (isCustomer != null ? isCustomer.hashCode() : 0);
        result = 31 * result + (isLead != null ? isLead.hashCode() : 0);
        result = 31 * result + (isSupplier != null ? isSupplier.hashCode() : 0);
        result = 31 * result + (isCompetitor != null ? isCompetitor.hashCode() : 0);
        result = 31 * result + (isPartner != null ? isPartner.hashCode() : 0);
        result = 31 * result + (isEmployee != null ? isEmployee.hashCode() : 0);
        result = 31 * result + (tin != null ? tin.hashCode() : 0);
        result = 31 * result + (maritalStatus != null ? maritalStatus.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (activationDate != null ? activationDate.hashCode() : 0);
        result = 31 * result + (deactivationDate != null ? deactivationDate.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
