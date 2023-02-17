package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
@Entity
@Table(name = "employee")
public class Employee {

        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "gender")
        private String gender;
        @Column(name = "age")
        private int age;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        @Column(name = "city_id")
        private int city;

        public Employee(String firstName, String lastName, String gender, int age, int city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.age = age;
            this.city = city;
        }


        @Override
        public String toString() {
            return " " + firstName + '\'' +
                    " " + lastName + '\'' +
                    ", " + gender + '\'' +
                    ", age: " + age
                    + ", " + city;
        }
    }

