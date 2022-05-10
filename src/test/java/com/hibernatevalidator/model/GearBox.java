package com.hibernatevalidator.model;

/**
 * @ClassName GearBox
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/26 9:53
 */
public class GearBox <T extends Gear> {
    private final T gear;

    public GearBox(T gear) {
        this.gear = gear;
    }

    public Gear getGear() {
        return this.gear;
    }
}
