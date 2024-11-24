package com.arkmedis.digipro.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = " userstwo")
@Data // Lombok annotation for getters, setters, toString, etc.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "FK_team_id"))
    private Team team;

    public enum Role {
        EMPLOYEE,
        MANAGER,
        ADMIN,
        CLIENT
    }


}
