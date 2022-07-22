package com.amsidh.mvc.domain;

import com.amsidh.mvc.intf.EmailSizeGroup;
import com.amsidh.mvc.intf.EmailValidGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull(message = "emailId must be required")
    @Size(min = 10, max = 15, message = "emailId length must be between 10 to 15", groups = {EmailSizeGroup.class})
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "emailId invalid pattern", groups = {EmailValidGroup.class})
    private String emailId;

}
