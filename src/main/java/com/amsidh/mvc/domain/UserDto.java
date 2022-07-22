package com.amsidh.mvc.domain;

import com.amsidh.mvc.intf.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    @NotNull(message = "emailId must be required", groups = {UserDto_EmailId_NotNullValidationGroup.class})
    @NotBlank(message = "emailId must not be blank", groups = {UserDto_EmailId_NotBlankValidationGroup.class})
    @Size(min = 10, max = 15, message = "emailId length must be between 10 to 15", groups = {UserDto_EmailId_SizeValidationGroup.class})
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "emailId invalid pattern", groups = {UserDto_EmailId_PatternValidationGroup.class})
    private String emailId;

    @NotNull(message = "userId must be required", groups = {UserDto_UserId_NotNullValidationGroup.class})
    @NotBlank(message = "userId must not be blank", groups = {UserDto_UserId_NotBlankValidationGroup.class})
    @Size(min = 3, max = 15, message = "userId length must be between 3 to 15", groups = {UserDto_UserId_SizeValidationGroup.class})
    @Pattern(regexp = "^[a-zA-Z]*$", message = "userId invalid pattern", groups = {UserDto_UserId_PatternValidationGroup.class})
    private String userId;

}
