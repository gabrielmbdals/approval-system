package br.com.gmbconsulting.approvalsystem.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
public class UserResponse extends RepresentationModel<UserResponse> {

    private String email;
    private String name;
    @JsonProperty("user_type")
    private UserType type;
    @JsonProperty("dt_created")
    private LocalDateTime dtCreated;
    @JsonProperty("dt_update")
    private LocalDateTime dtUpdate;

    public UserResponse(User entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.type = entity.getType();
        this.dtCreated = entity.getDtCreated();
        this.dtUpdate = entity.getDtUpdate();
    }
}
