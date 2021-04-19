package Models.Util.Classes;

import java.util.UUID;

public class Entity {
    private String ID;
    private String name;

    public Entity(String name) {
        UUID ID = UUID.randomUUID();
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
