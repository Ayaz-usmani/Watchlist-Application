package com.example.Project.WatchlistApplication.models.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityValidationLogic implements ConstraintValidator<Priority, String>{

	@Override
	public boolean isValid(String priority, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		
		priority = priority.trim();
		
		if(priority.length()!=1 && priority.equalsIgnoreCase("L") || priority.equalsIgnoreCase("M") || priority.equalsIgnoreCase("H"))
			return true;
		else 
			return false;
	}

}
