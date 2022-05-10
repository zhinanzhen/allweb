package com.hibernatevalidator;

import com.hibernatevalidator.model.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName CarTest
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/25 18:54
 */
public class CarTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull() {
        Car car = new Car( );

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
    }
}
