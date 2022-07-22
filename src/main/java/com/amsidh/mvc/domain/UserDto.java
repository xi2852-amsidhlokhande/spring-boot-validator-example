package com.amsidh.mvc.domain;

import com.amsidh.mvc.intf.SizeValidationGroup;
import com.amsidh.mvc.intf.PatternValidationGroup;
import com.amsidh.mvc.intf.NotNullValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull(message = "emailId must be required", groups = {NotNullValidationGroup.class})
    @Size(min = 10, max = 15, message = "emailId length must be between 10 to 15", groups = {SizeValidationGroup.class})
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "emailId invalid pattern", groups = {PatternValidationGroup.class})
    private String emailId;

    @NotBlank(message = "userId must be blank", groups = {NotNullValidationGroup.class})
    @NotNull(message = "userId must be required", groups = {NotNullValidationGroup.class})
    @Size(min = 3, max = 15, message = "userId length must be between 3 to 15", groups = {SizeValidationGroup.class})
    @Pattern(regexp = "^[a-zA-Z]*$", message = "userId invalid pattern", groups = {PatternValidationGroup.class})
    private String userId;

}
