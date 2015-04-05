package ged.daedaluswin.crmserver.db.pojos;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
public class Users {
    private int id;
    private String username;
    private String password;
    private Contacts contactsByContactId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Contacts getContactsByContactId() {
        return contactsByContactId;
    }

    public void setContactsByContactId(Contacts contactsByContactId) {
        this.contactsByContactId = contactsByContactId;
    }
}
