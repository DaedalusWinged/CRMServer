package ged.daedaluswin.crmserver.db.pojos;

import javax.persistence.*;

/**
 * Created by Mercutio Donnati on 1/4/2015.
 */
@Entity
@Table(name = "TaxOffices", schema = "crm", catalog = "CRM_UAT")
public class TaxOfficesEntity {
    private int id;
    private int code;
    private String description;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxOfficesEntity that = (TaxOfficesEntity) o;

        if (code != that.code) return false;
        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + code;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
