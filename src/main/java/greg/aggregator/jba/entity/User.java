package greg.aggregator.jba.entity;

import greg.aggregator.jba.annotation.UniqueUsername;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * Created by greg on 05.06.15.
 */
@Entity
@Data
@ToString(exclude = {"roles","blogs"})
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3, message = "Name must be at 3 characters!")
    @Column(unique = true)
    @UniqueUsername(message = "Such username already exist!")
    private String name;

    @Size(min = 1, message = "Invalid email address!")
    @Email(message = "Invalid email address!")
    private String email;

    @Size(min = 5, message = "Password must be at 5 characters!")
    private String password;

    @ManyToMany
    @JoinTable
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Blog> blogs;

    private Boolean enabled;

}
