package Model;

public class Mail {

    private final int id;
    private final String mail;

    public Mail(String mail, int id) {
        this.mail = mail;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }
}