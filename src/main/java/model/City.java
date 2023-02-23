package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "city")
@Entity
@Data
@NonNull
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private long id;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city",
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;

    public City(long id) {
        this.id = id;
    }

    public City(String cityName) {
        if (Objects.isNull(cityName)) {
            this.cityName = "default";
        } else {
            this.cityName = cityName;
        }
    }

    @Override
    public String toString() {
        return "City: " + cityName;
    }
}
