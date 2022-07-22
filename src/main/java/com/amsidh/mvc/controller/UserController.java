package com.amsidh.mvc.controller;

import com.amsidh.mvc.controller.response.GenericResponse;
import com.amsidh.mvc.domain.UserDto;
import com.amsidh.mvc.error.ErrorDetails;
import com.amsidh.mvc.intf.UserDtoEmailIdValidationSequence;
import com.amsidh.mvc.intf.UserDtoUserIdValidationSequence;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity validateUser(@RequestBody @Validated({UserDtoEmailIdValidationSequence.class, UserDtoUserIdValidationSequence.class}) UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorDetails> errorDetailsList = bindingResult.getFieldErrors().stream().map(fieldError -> {
                return ErrorDetails.builder().fieldName(fieldError.getField()).code("1002").message(fieldError.getDefaultMessage()).build();
            }).collect(Collectors.toList());
            return ResponseEntity.ok(GenericResponse.builder().errorDetails(errorDetailsList).build());
        }
        return ResponseEntity.ok(GenericResponse.builder().data(userDto).build());
    }
}
