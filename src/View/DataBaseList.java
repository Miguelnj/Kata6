package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Person;

public class DataBaseList {

    public static List<Person> read() throws ClassNotFoundException, SQLException {
        List<Person> personList = new ArrayList<>();

        Class.forName("org.sqlite.JDBC");
        Connection connect = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");

        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PEOPLE;");

        while (rs.next()) {
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            Character gender = rs.getString(3).charAt(0);
            String birthDate = rs.getString(4);
            Float weight = rs.getFloat(5);
            String mail = rs.getString(6);
            personList.add(new Person(id, name, gender, birthDate, weight, mail));
        }
        return personList;
    }



}