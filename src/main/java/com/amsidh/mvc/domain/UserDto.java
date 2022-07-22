package com.amsidh.mvc.domain;

import com.amsidh.mvc.intf.MatchGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull(message = "UserId must not be null")
    private String userId;

    @NotNull(groups = MatchGroup.class, message = "Password must not be null")
    private String password;

    @NotNull(groups = MatchGroup.class, message = "ConfirmPassword must not be null")
    private String confirmPassword;

}
