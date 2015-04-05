package ged.daedaluswin.crmserver.db.pojos;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
public class ContactActivityHistory {
    private int id;
    private Activities activitiesByActivityId;

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

        ContactActivityHistory that = (ContactActivityHistory) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Activities getActivitiesByActivityId() {
        return activitiesByActivityId;
    }

    public void setActivitiesByActivityId(Activities activitiesByActivityId) {
        this.activitiesByActivityId = activitiesByActivityId;
    }
}
