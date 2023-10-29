package br.com.gmbconsulting.approvalsystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private String email;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_user")
    private UserType type;

    @CreationTimestamp
    private LocalDateTime dtCreated;
    @UpdateTimestamp
    private LocalDateTime dtUpdate;
}
