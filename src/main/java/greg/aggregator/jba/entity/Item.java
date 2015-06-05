package greg.aggregator.jba.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by greg on 05.06.15.
 */
@Entity
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

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
