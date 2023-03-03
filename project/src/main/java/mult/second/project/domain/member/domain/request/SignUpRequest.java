package mult.second.project.domain.member.domain.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpRequest {
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Email
	private String email;
	
	
}
