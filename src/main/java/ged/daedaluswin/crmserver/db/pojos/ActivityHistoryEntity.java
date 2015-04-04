package ged.daedaluswin.crmserver.db.pojos;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Mercutio Donnati on 1/4/2015.
 */
@Entity
@Table(name = "ActivityHistory", schema = "crm", catalog = "CRM_UAT")
public class ActivityHistoryEntity {
    private int id;
    private Timestamp ownerTimeStamp;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OwnerTimeStamp")
    public Timestamp getOwnerTimeStamp() {
        return ownerTimeStamp;
    }

    public void setOwnerTimeStamp(Timestamp ownerTimeStamp) {
        this.ownerTimeStamp = ownerTimeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityHistoryEntity that = (ActivityHistoryEntity) o;

        if (id != that.id) return false;
        if (ownerTimeStamp != null ? !ownerTimeStamp.equals(that.ownerTimeStamp) : that.ownerTimeStamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ownerTimeStamp != null ? ownerTimeStamp.hashCode() : 0);
        return result;
    }
}
