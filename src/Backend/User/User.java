package Backend.User;

import Backend.Util.Classes.Entity;

public class User extends Entity {
    private Boolean isAdmin;
    private Boolean isStudent;

    public User(String name, Boolean isAdmin, Boolean isStudent, Boolean isParent) {
        super(name);
        this.isAdmin = isAdmin;
        this.isStudent = isStudent;
    }

    public String getID() { return super.getID(); }
    public String getName(){
        return super.getName();
    }
    public Boolean isAdmin() { return isAdmin; }
    public Boolean isStudent() { return isStudent; }
}
