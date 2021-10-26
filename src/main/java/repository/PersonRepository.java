package repository;

import entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository  implements CrudDao<Person> {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";


    @Override
    public Person save(Person entity) {
        return null;
    }

    @Override
    public Person findById(int id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM school;"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Person> persons = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                persons.add(new Person(id, firstname, lastname, age));
            }
            return persons;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
        return null;
    }

    @Override
    public Person update(Person entity) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
