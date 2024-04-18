package edu.miu.cs.cs489.dentalsurgeryapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name= "users_roles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName="userId")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "roleId")}
    )
    private List<Role> roles;

    public User() {
        this(null,null);
    }

    public User(Integer userId, String username, String password, String firstName, String lastName, String email, boolean enabled, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public User(String username, String password) {
        this(null, username, password, null, null, null, true, true, true, true);
    }
}
