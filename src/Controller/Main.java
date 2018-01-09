package Controller;

import View.HistogramBuilder;
import View.HistogramDisplay;
import View.MailListReader;
import java.io.IOException;
import java.sql.SQLException;
import Model.Histogram;
import Model.Mail;
import Model.Person;
import View.DataBaseList;

public class Main {

    private final String fileName = "emails.txt";

    private HistogramBuilder<Mail> mailBuilder;
    private HistogramBuilder<Person> personBuilder;

    private Histogram<String> domains;
    private Histogram<Character> letters;
    private Histogram<Character> gender;
    private Histogram<Float> weight;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Main main = new Main();
        main.execute();
    }

    private void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }

    private void input() throws IOException, ClassNotFoundException, SQLException {
        mailBuilder = new HistogramBuilder<>(MailListReader.read(fileName));
        personBuilder = new HistogramBuilder<>(DataBaseList.read());

    }

    private void process() {
        domains = mailBuilder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });

        letters = mailBuilder.build(new Attribute<Mail, Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });

        gender = personBuilder.build(new Attribute<Person, Character>() {
            @Override
            public Character get(Person item) {
                return item.getGender();
            }
        });

        weight = personBuilder.build(new Attribute<Person, Float>() {
            @Override
            public Float get(Person item) {
                return item.getWeight();
            }
        });
    }

    private void output() {
        new HistogramDisplay<>(domains, "Domains", "Number of emails").execute();
        new HistogramDisplay<>(letters, "First character", "Number of emails").execute();
        new HistogramDisplay<>(gender, "Gender", "Number of persons").execute();
        new HistogramDisplay<>(weight, "Weight", "Number of persons").execute();
    }
}