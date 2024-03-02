package com.example.Project.WatchlistApplication.models.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingValidationLogic implements ConstraintValidator<Rating, Float> {

	@Override
	public boolean isValid(Float rating, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return rating > 0 && rating <= 10;
	}
}
