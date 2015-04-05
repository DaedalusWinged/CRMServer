package ged.daedaluswin.crmserver.db.pojos;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
public class ContactWebSites {
    private int id;
    private String webSite;
    private Contacts contactsByContactId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactWebSites that = (ContactWebSites) o;

        if (id != that.id) return false;
        if (webSite != null ? !webSite.equals(that.webSite) : that.webSite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (webSite != null ? webSite.hashCode() : 0);
        return result;
    }

    public Contacts getContactsByContactId() {
        return contactsByContactId;
    }

    public void setContactsByContactId(Contacts contactsByContactId) {
        this.contactsByContactId = contactsByContactId;
    }
}
