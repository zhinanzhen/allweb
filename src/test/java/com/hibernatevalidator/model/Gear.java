package com.hibernatevalidator.model;

/**
 * @ClassName Gear
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/26 9:53
 */
public class Gear {
    private final Integer torque;

    public Gear(Integer torque) {
        this.torque = torque;
    }

    public Integer getTorque() {
        return torque;
    }

    public static class AcmeGear extends Gear {
        public AcmeGear() {
            super( 100 );
        }
    }
}
