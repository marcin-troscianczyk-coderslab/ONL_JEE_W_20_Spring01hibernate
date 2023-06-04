package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@ToString//(exclude = {"rating"})
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{title.not.empty.error}")
    @Size(min = 5, message = "{title.too.short.error}")
    private String title;

    @Range(min = 1, max = 10)
    @ToString.Exclude
    private int rating;

    @Size(max = 600)
    private String description;

    @NotNull
    @ManyToOne//(fetch = FetchType.LAZY)//(cascade = CascadeType.PERSIST)
    private Publisher publisher;

    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Author> authors = new ArrayList<>();

    @Min(1)
    private int pages;

    @ManyToOne
    @NotNull
    private Category category;

}
