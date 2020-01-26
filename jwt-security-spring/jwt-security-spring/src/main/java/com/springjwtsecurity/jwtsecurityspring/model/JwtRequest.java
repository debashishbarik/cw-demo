package com.springjwtsecurity.jwtsecurityspring.model;

import lombok.*;

import java.io.Serializable;

/**
 * Storing the username and password we recieve from the client.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
}
