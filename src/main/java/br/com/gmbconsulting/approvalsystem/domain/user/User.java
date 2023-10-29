package br.com.gmbconsulting.approvalsystem.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
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
    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dtCreated;
    @LastModifiedDate
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dtUpdate;
}
