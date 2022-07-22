package com.amsidh.mvc.intf;


import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, NotNullValidationGroup.class, NotBlankValidationGroup.class, SizeValidationGroup.class, PatternValidationGroup.class})
public interface UserDtoValidationSequence {
}
