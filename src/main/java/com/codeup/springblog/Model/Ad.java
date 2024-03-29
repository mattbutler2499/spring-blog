package com.codeup.springblog.Model;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue
    private long id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false, length = 10000)
    private String description;

    @OneToOne
    private Post seller;

    public Ad(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
