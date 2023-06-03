package pl.coderslab.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "authors")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @PESEL
    private String pesel;

    @Email
    private String email;
    public Author(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
