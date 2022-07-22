package com.amsidh.mvc.intf;


import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, MatchGroup.class})
public interface ValidationSequence {
}
