package ged.daedaluswin.crmserver.db.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Mercutio Donnati on 1/4/2015.
 */
@Entity
@Table(name = "ContactActivityHistory", schema = "crm", catalog = "CRM_UAT")
public class ContactActivityHistoryEntity {
    private int id;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactActivityHistoryEntity that = (ContactActivityHistoryEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
