package com.happen.happen_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_username")
    private String username;


    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;



    @Column(name = "user_firstname")
    private String firstname;



    @Column(name = "user_lastname")
    private String lastname;


    @Column(name = "user_phone")
    private String phone;


    @Column(name = "user_profileUrl")
    private String profileUrl;

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isActive = false;


    @Column(name = "is_email_verified", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isEmailVerified = false;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public String  getFullName() {
        return firstname + lastname;
    }



    public boolean hasRole(String roleName) {
        if (roles == null || roles.isEmpty()) {
            return false;
        }
        return roles.stream()
                .anyMatch(role -> role.getName().equalsIgnoreCase(roleName));
    }

    public boolean isEventManager() {
        return hasRole("EVENT_MANAGER");
    }

    public boolean isVenueManager() {
        return hasRole("VENUE_MANAGER");
    }


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}