package greg.aggregator.jba.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by greg on 05.06.15.
 */
@Entity
@Data
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

    @Column(name = "published_date")
    private Date publishedDate;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    private String link;

}
