package com.ipartek.formacion.dbms.persistence.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented //documentado
@Constraint(validatedBy = PhoneValidator.class)//con que
@Target({ElementType.METHOD, ElementType.FIELD})//donde
@Retention(RetentionPolicy.RUNTIME)//cuando
public @interface Phone {
	//Phone lo ponenomos porque es de donde va a tomar el mensaje aunque se puede poner el apquete 
	String message() default "{Phone}";
	//Las 2 siguienes tienen que ser tal cueal
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
