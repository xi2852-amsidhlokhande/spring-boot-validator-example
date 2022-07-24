package com.amsidh.mvc.controller;

import com.amsidh.mvc.controller.response.GenericResponse;
import com.amsidh.mvc.domain.UserDto;
import com.amsidh.mvc.error.ErrorDetails;
import com.amsidh.mvc.intf.UserDtoValidationSequence;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    @Validated(UserDtoValidationSequence.class)
    public ResponseEntity validateUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.ok(GenericResponse.builder().data(userDto).build());
    }
}
