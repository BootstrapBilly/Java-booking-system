package Backend.User;

import Backend.Util.Classes.Entity;

public class Person extends Entity {
    private String address;
    private String phone;

    public Person(String ID, String name, String address, String phone) {
        super(ID, name);
        this.address = address;
        this.phone = phone;
    }
}
