package fr.unice.polytech.apprenticeship.test.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public class User {
    @Id
    public ObjectId _id;

    @NotNull
    public String name;

    @NotNull
    public int age;

    @NotNull
    public String country;

    public String job;

    public User() {}

    public User(ObjectId _id, String name, int age, String country, String job) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.job = job;
    }

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Optional<String> getJob() {
        return Optional.ofNullable(job);
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString(){
        return "ID: " + this._id + ", NAME : " + name + ", AGE : " + age + ", FROM :" + country
                + job == null ? ", JOB :" + job + "\n" : "\n";
    }
}
