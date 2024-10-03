package api.members.members_api.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {
    
    @NotBlank
    private String username;
    @NotBlank
    private String password;    
}
