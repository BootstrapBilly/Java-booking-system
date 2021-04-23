package Data.Managers.Session;

public class SessionManager<A> {

    // instance variables
    private String userType;
    private A user; // the user can be a student, or an entity, hence the usage of generics

    public SessionManager() {}


    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void login(A user){
        this.user = user;
    }

    public void logout(){
        this.user = null;
    }

    public A getSession(){
        return this.user;
    }

}
