package com.amsidh.mvc.intf;


import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, UserDto_EmailId_NotNullValidationGroup.class, UserDto_EmailId_NotBlankValidationGroup.class, UserDto_EmailId_SizeValidationGroup.class, UserDto_EmailId_PatternValidationGroup.class})
public interface UserDtoEmailIdValidationSequence {
}
