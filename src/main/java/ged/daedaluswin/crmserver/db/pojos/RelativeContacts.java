package ged.daedaluswin.crmserver.db.pojos;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
public class RelativeContacts {
    private int id;
    private Contacts contactsByParentContactId;
    private Contacts contactsByChildContactId;

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

        RelativeContacts that = (RelativeContacts) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Contacts getContactsByParentContactId() {
        return contactsByParentContactId;
    }

    public void setContactsByParentContactId(Contacts contactsByParentContactId) {
        this.contactsByParentContactId = contactsByParentContactId;
    }

    public Contacts getContactsByChildContactId() {
        return contactsByChildContactId;
    }

    public void setContactsByChildContactId(Contacts contactsByChildContactId) {
        this.contactsByChildContactId = contactsByChildContactId;
    }
}
