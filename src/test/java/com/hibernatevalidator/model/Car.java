package com.hibernatevalidator.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @ClassName Car
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/25 18:53
 */
@Setter
@Getter
public class Car {
    @NotNull
    private String manufacturer;
    @NotNull(message = "姓名不能为空")
    private String name;
    @UniqueElements
    @NotNull(message = "地址不能为空")
    private String adress;
//
//    @NotNull
//    @Size(min = 2, max = 14)
//    private String licensePlate;
//
//    @Min(2)
//    private int seatCount;

//    @AssertTrue()
//    private boolean flag;

//    public enum FuelConsumption {
//        CITY,
//        HIGHWAY
//    }
//
//    private Optional<@Min(1000) Integer> towingCapacity = Optional.empty();
//
//    public void setTowingCapacity(Integer alias) {
//        towingCapacity = Optional.of( alias );
//    }

//    private GearBox<@Min(100) Gear> gearBox;
//
//    public void setGearBox(GearBox<Gear> gearBox) {
//        this.gearBox = gearBox;
//    }

//    private Map<@NotNull FuelConsumption, @Max(20) Integer> fuelConsumption = new HashMap<>();
//
//    public void setFuelConsumption(FuelConsumption consumption, int value) {
//        fuelConsumption.put( consumption, value );
//    }

    /*private Set<@NotNull String> parts = new HashSet<>();
    public void addPart(String part) {
        parts.add( part );
    }*/
//    public Car(String manufacturer, String licencePlate, int seatCount) {
//        this.manufacturer = manufacturer;
//        this.licensePlate = licencePlate;
//        this.seatCount = seatCount;
//    }

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

//        Car car = new Car( null, "DD-AB-123", 4 );
//        Car car = new Car();
//        car.addPart( null );
//        car.addPart( null );
//        Car car = new Car();
//        car.setFuelConsumption( Car.FuelConsumption.HIGHWAY, 21 );

//        Car car = new Car();
//        car.setTowingCapacity( 100 );
        Car car = new Car();
        car.setManufacturer("ddd");
        ConstraintValidator v;
//        car.setGearBox( new GearBox<>(new Gear.AcmeGear()));
        Set<ConstraintViolation<Car>> constraintViolations = validator.validateProperty(car, "name");

//        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        for (ConstraintViolation<Car> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage() + ":" + ":" + constraintViolation.getMessageTemplate() + ":" + constraintViolation.getPropertyPath().toString());
        }
//        ConstraintViolation<Car> next = constraintViolations.iterator().next();

    }

}
