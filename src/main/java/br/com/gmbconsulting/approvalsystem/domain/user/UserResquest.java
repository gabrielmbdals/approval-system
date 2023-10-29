package br.com.gmbconsulting.approvalsystem.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UserResquest {

    @NotBlank
    @NotEmpty
    private String email;
    @NotBlank
    @NotEmpty
    private String name;
    @NotBlank
    @NotEmpty
    private String password;

    public User toEntity() {
        return User.builder()
                .name(this.name)
                .password(this.password)
                .email(this.email)
                .type(UserType.USER)
                .build();
    }
}
