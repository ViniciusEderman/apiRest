package apiRest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_department")

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //Constructor:
    public Department() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
