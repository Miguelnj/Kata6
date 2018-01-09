package Model;

public class Person {
    private final int id;
    private final String name, birthday, mail;
    private final Character gender;
    private final Float weight;

    public Person(int id, String name, Character gender, String birthday, Float weight, String mail) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.weight = weight;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMail() {
        return mail;
    }

    public Character getGender() {
        return gender;
    }

    public Float getWeight() {
        return weight;
    }
}