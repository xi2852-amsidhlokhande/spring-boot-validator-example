package com.amsidh.mvc.intf;


import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, UserDto_EmailId_NotNullValidationGroup.class, UserDto_EmailId_NotBlankValidationGroup.class, UserDto_EmailId_SizeValidationGroup.class, UserDto_EmailId_PatternValidationGroup.class, UserDto_UserId_NotNullValidationGroup.class, UserDto_UserId_NotBlankValidationGroup.class, UserDto_UserId_SizeValidationGroup.class, UserDto_UserId_PatternValidationGroup.class})
public interface UserDtoValidationSequence {
}
