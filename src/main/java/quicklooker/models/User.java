package quicklooker.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="username")
    @Size(min=5, max=16, message="{username.size}")
    private String username;

    @Column(name="password")
    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    // TODO think about passwordHash
    private String password;

    @NotNull
    private boolean enabled;

    @Column(name="first_name")
    @NotNull
    @Size(min=2, max=30, message="{firstName.size}")
    private String firstName;

    @Column(name="last_name")
    @NotNull
    @Size(min=2, max=30, message="{lastName.size}")
    private String lastName;

    @Column(name="email")
    @NotNull
    @NotEmpty(message = "Email may not be empty.")
    @Email(message="{email.valid}")
    private String email;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Post> posts = new HashSet<>();

    public User() {
    }

    public User(String username, String password, boolean enabled, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
