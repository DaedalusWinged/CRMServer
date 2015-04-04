package ged.daedaluswin.crmserver.db.pojos;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Mercutio Donnati on 1/4/2015.
 */
@Entity
@javax.persistence.Table(name = "Contacts", schema = "crm", catalog = "CRM_UAT")
public class ContactsEntity {
    private int id;

    @Id
    @javax.persistence.Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String lastName;

    @Basic
    @javax.persistence.Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;

    @Basic
    @javax.persistence.Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private Short isPerson;

    @Basic
    @javax.persistence.Column(name = "isPerson")
    public Short getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(Short isPerson) {
        this.isPerson = isPerson;
    }

    private Short isAccount;

    @Basic
    @javax.persistence.Column(name = "isAccount")
    public Short getIsAccount() {
        return isAccount;
    }

    public void setIsAccount(Short isAccount) {
        this.isAccount = isAccount;
    }

    private Short isCustomer;

    @Basic
    @javax.persistence.Column(name = "isCustomer")
    public Short getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Short isCustomer) {
        this.isCustomer = isCustomer;
    }

    private Short isLead;

    @Basic
    @javax.persistence.Column(name = "isLead")
    public Short getIsLead() {
        return isLead;
    }

    public void setIsLead(Short isLead) {
        this.isLead = isLead;
    }

    private Short isSupplier;

    @Basic
    @javax.persistence.Column(name = "isSupplier")
    public Short getIsSupplier() {
        return isSupplier;
    }

    public void setIsSupplier(Short isSupplier) {
        this.isSupplier = isSupplier;
    }

    private Short isCompetitor;

    @Basic
    @javax.persistence.Column(name = "isCompetitor")
    public Short getIsCompetitor() {
        return isCompetitor;
    }

    public void setIsCompetitor(Short isCompetitor) {
        this.isCompetitor = isCompetitor;
    }

    private Short isPartner;

    @Basic
    @javax.persistence.Column(name = "isPartner")
    public Short getIsPartner() {
        return isPartner;
    }

    public void setIsPartner(Short isPartner) {
        this.isPartner = isPartner;
    }

    private Short isEmployee;

    @Basic
    @javax.persistence.Column(name = "isEmployee")
    public Short getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Short isEmployee) {
        this.isEmployee = isEmployee;
    }

    private Integer tin;

    @Basic
    @javax.persistence.Column(name = "TIN")
    public Integer getTin() {
        return tin;
    }

    public void setTin(Integer tin) {
        this.tin = tin;
    }

    private Short maritalStatus;

    @Basic
    @javax.persistence.Column(name = "MaritalStatus")
    public Short getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Short maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    private Timestamp birthDate;

    @Basic
    @javax.persistence.Column(name = "BirthDate")
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    private Short isActive;

    @Basic
    @javax.persistence.Column(name = "isActive")
    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    private Timestamp activationDate;

    @Basic
    @javax.persistence.Column(name = "ActivationDate")
    public Timestamp getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Timestamp activationDate) {
        this.activationDate = activationDate;
    }

    private Timestamp deactivationDate;

    @Basic
    @javax.persistence.Column(name = "DeactivationDate")
    public Timestamp getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Timestamp deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    private Short sex;

    @Basic
    @javax.persistence.Column(name = "Sex")
    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    private String notes;

    @Basic
    @javax.persistence.Column(name = "Notes")
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

        ContactsEntity that = (ContactsEntity) o;

        if (id != that.id) return false;
        if (activationDate != null ? !activationDate.equals(that.activationDate) : that.activationDate != null)
            return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (deactivationDate != null ? !deactivationDate.equals(that.deactivationDate) : that.deactivationDate != null)
            return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (isAccount != null ? !isAccount.equals(that.isAccount) : that.isAccount != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (isCompetitor != null ? !isCompetitor.equals(that.isCompetitor) : that.isCompetitor != null) return false;
        if (isCustomer != null ? !isCustomer.equals(that.isCustomer) : that.isCustomer != null) return false;
        if (isEmployee != null ? !isEmployee.equals(that.isEmployee) : that.isEmployee != null) return false;
        if (isLead != null ? !isLead.equals(that.isLead) : that.isLead != null) return false;
        if (isPartner != null ? !isPartner.equals(that.isPartner) : that.isPartner != null) return false;
        if (isPerson != null ? !isPerson.equals(that.isPerson) : that.isPerson != null) return false;
        if (isSupplier != null ? !isSupplier.equals(that.isSupplier) : that.isSupplier != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (maritalStatus != null ? !maritalStatus.equals(that.maritalStatus) : that.maritalStatus != null)
            return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (tin != null ? !tin.equals(that.tin) : that.tin != null) return false;

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
