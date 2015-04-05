package ged.daedaluswin.crmserver.db.pojos;

import java.sql.Timestamp;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
public class ActivityHistory {
    private int id;
    private Timestamp ownerTimeStamp;
    private Activities activitiesByActivityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

        ActivityHistory that = (ActivityHistory) o;

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

    public Activities getActivitiesByActivityId() {
        return activitiesByActivityId;
    }

    public void setActivitiesByActivityId(Activities activitiesByActivityId) {
        this.activitiesByActivityId = activitiesByActivityId;
    }
}
