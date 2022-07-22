package com.amsidh.mvc.controller;

import com.amsidh.mvc.controller.response.GenericResponse;
import com.amsidh.mvc.domain.UserDto;
import com.amsidh.mvc.intf.ValidationSequence;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity validateUser(@RequestBody @Validated(ValidationSequence.class) UserDto userDto) {
        return ResponseEntity.ok(GenericResponse.builder().data(userDto).build());
    }
}
