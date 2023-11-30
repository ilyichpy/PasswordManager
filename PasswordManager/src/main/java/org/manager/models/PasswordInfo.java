package org.manager.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordInfo {
    private Long id;
    private String email;
    private String password;
    public PasswordInfo() {}

}
