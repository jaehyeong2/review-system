package jjfactory.common.user.domain;

import jakarta.persistence.*;

@Table(name = "users")
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;


}
