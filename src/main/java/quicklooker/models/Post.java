package quicklooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @Lob
    @NotNull
    private String body;

    @NotNull
    private Date date;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;

}
