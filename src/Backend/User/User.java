package Backend.User;

import Backend.Util.Classes.Entity;

public class User extends Entity {
    private Boolean isAdmin;
    private Boolean isStudent;

    public User(String ID, String name, Boolean isAdmin, Boolean isStudent) {
        super(ID, name);
        this.isAdmin = isAdmin;
        this.isStudent = isStudent;
    }
}
