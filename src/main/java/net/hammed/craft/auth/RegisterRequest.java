package net.hammed.craft.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.hammed.craft.user.Role;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RegisterRequest {
private String firstname;
private String lastname;
private String email;
private String password;
private Role role;
}
