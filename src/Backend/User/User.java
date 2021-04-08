package Backend.User;

import Backend.Util.Classes.Entity;

public class User extends Entity {
    private Boolean isAdmin;
    private Boolean isStudent;
    private Boolean isParent;

    public User(String ID, String name, Boolean isAdmin, Boolean isStudent, Boolean isParent) {
        super(ID, name);
        this.isAdmin = isAdmin;
        this.isStudent = isStudent;
        this.isParent = isParent;
    }

    public String getName(){
        return super.getName();
    }
    public Boolean isAdmin() { return isAdmin; }
    public Boolean isStudent() { return isStudent; }
}
