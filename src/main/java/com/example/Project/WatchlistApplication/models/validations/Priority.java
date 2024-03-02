package com.example.Project.WatchlistApplication.models.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityValidationLogic.class)
public @interface Priority {
	
	String message() default "Must be L or M or H";
	
	Class<?>[]groups() default {};
	Class<? extends Payload>[] payload() default {};
}
