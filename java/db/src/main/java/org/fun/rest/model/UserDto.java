package org.fun.rest.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * Created by tim on 03.06.2017.
 */
@Getter
@Builder
public class UserDto {
    private UUID id;
    private String login;
    private String firstName;
    private String lastName;
    private Boolean active;
}
