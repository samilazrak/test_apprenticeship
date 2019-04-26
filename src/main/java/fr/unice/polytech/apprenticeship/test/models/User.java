package fr.unice.polytech.apprenticeship.test.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {
    @Id
    public ObjectId _id;

    public String name;
    public int age;
    public String country;

    public User() {}

    public User(ObjectId _id, String name, int age, String country) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Override
    public String toString(){
        return "id: " + this._id + "  " + name + ", " + age + " years old   "  + country;
    }
}
