package greg.aggregator.jba.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by greg on 05.06.15.
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;

}
