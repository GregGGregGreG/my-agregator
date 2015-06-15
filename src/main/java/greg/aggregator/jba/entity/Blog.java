package greg.aggregator.jba.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by greg on 05.06.15.
 */
@Entity
@Data
@ToString(exclude = {"user","items"})
public class Blog {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 1, message = "Invalid URL!")
    @URL(message = "Invalid URL!")
    private String url;

    @Size(min = 1, message = "Name must be at least 1 character!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
    private List<Item> items;

}
