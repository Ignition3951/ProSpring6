package com.utk.validator;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.utk.record.Blogger;

@Component(value = "complexBloggerValidator")
public class ComplexBloggerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Blogger.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Blogger blogger = (Blogger) target;
		if (StringUtils.isEmpty(blogger.firstName()) && StringUtils.isEmpty(blogger.lastName())) {
			errors.rejectValue("firstName", "firstNameOrLastName.required");
			errors.rejectValue("lastName", "firstNameOrLastName.required");
		}
		if (blogger.birthDate().isBefore(LocalDate.of(1983, 01, 01))) {
			errors.rejectValue("birthDate", "birthDate.greaterThan1983");
		}
	}

}
