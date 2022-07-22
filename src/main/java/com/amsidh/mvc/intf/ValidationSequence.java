package com.amsidh.mvc.intf;


import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, EmailValidGroup.class, EmailSizeGroup.class})
public interface ValidationSequence {
}
