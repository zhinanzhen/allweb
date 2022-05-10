package com.hibernatevalidator.model;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;

/**
 * @ClassName GearBoxValueExtractor
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/26 10:00
 */
public class GearBoxValueExtractor implements ValueExtractor<GearBox<@ExtractedValue ?>> {
    @Override
    public void extractValues(GearBox<?> gearBox, ValueReceiver valueReceiver) {
        valueReceiver.value( null, gearBox.getGear() );
    }
}
