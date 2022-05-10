package com.hibernatevalidator.group;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * @ClassName Teat
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/26 14:30
 */
public class Test {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        // create a car and check that everything is ok with it.
        Car car = new Car( "Morris", "DD-AB-123", 2 );
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
        System.out.println(constraintViolations.size());

        // but has it passed the vehicle inspection?
        constraintViolations = validator.validate( car, CarChecks.class );
        System.out.println(constraintViolations.size());
        System.out.println(constraintViolations.iterator().next().getMessage());


        // let's go to the vehicle inspection
        car.setPassedVehicleInspection( true );
        System.out.println(validator.validate( car, CarChecks.class ).size());

        // now let's add a driver. He is 18, but has not passed the driving test yet
        Driver john = new Driver( "John Doe" );
        john.setAge( 18 );
        car.setDriver( john );
        constraintViolations = validator.validate( car, DriverChecks.class );
        System.out.println(constraintViolations.size());
        System.out.println(constraintViolations.iterator().next().getMessage());


        // ok, John passes the test
        john.passedDrivingTest( true );
        System.out.println(validator.validate( car, DriverChecks.class ).size());

        // just checking that everything is in order now
        System.out.println(validator.validate(
                car,
                Default.class,
                CarChecks.class,
                DriverChecks.class
        ).size());
    }
}
