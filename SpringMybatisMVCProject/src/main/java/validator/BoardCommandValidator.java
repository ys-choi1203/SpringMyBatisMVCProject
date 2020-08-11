package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// BoardCommandValidator가 validator가 되기 위해 Validator를 상속
public class BoardCommandValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "boardName", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardPass", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardSubject", "required");
	}
}
