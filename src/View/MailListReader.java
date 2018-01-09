package View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Model.Mail;

public class MailListReader {

    public static List<Mail> read(String file) throws FileNotFoundException, IOException {
        List<Mail> mailList = new ArrayList<>();
        Integer id=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String mail;
            while ((mail = reader.readLine()) != null) {
                if (mail.contains("@")) mailList.add(new Mail(mail, id++));
            }
        }
        return mailList;
    }
}