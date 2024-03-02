package com.example.Project.WatchlistApplication.models.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingValidationLogic.class)
public @interface Rating {

	String message() default "Values must be between 0 and 10";
	
	Class<?>[]groups() default {};
	Class<? extends Payload>[] payload() default {}; 
}
	