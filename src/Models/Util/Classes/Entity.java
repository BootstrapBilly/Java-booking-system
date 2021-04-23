package Models.Util.Classes;

import java.util.UUID;

public class Entity {
    /* Most models extend this class as a child or grand child, inheriting a unique id and a name */
    private String ID;
    private String name;

    public Entity(String name) {
        UUID ID = UUID.randomUUID(); // set the unique id
        this.ID = ID.toString();
        this.name = name;
    }

    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

}
