package com.amsidh.mvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @NotNull(message = "personId must be required")
    @Min(value = 5, message = "personId min length must be 5")
    @Max(value = 8, message = "personId max length must be 8")
    private Integer personId;

    @NotNull(message = "mobileNumber must be required")
    @Pattern(regexp = "^([+]\\d{2}[ ])?\\d{10}$", message = "mobileNumber invalid pattern")  //+91 0123456789
    private String mobileNumber;

    @NotNull(message = "emailId must be required")
    @Size(min = 10, max = 15, message = "emailId length must be between 10 to 15")

    /*
    1) A-Z characters allowed
    2) a-z characters allowed
    3) 0-9 numbers allowed
    4) Additionally email may contain only dot(.), dash(-) and underscore(_)
    5) Rest all characters are not allowed*/
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "emailId invalid pattern")
    private String emailId;


    @NotNull(message = "aadhaarNumber must be required")
    @Pattern(regexp = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$", message = "aadhaarNumber invalid pattern")
    private String aadhaarNumber;

    @NotNull(message = "panNumber must be required")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "panNumber invalid pattern")
    private String panNumber;
}
