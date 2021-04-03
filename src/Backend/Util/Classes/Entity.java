package Backend.Util.Classes;

public class Entity {
    private String ID;
    private String name;

    public Entity(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
