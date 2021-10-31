package com.ismael.homework.main.Entity;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import javax.persistence.*;
import java.util.List;




@Table(name = "author")
@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    private boolean deleted = Boolean.FALSE;
}
