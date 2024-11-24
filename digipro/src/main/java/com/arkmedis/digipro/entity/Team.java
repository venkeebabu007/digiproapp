package com.arkmedis.digipro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    @Column(nullable = false, length = 255)
    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "FK_manager_id"))
    private User manager;

}
