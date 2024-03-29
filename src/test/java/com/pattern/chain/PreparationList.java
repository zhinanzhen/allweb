package com.pattern.chain;

/**
 * @ClassName PreparationList
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:13
 */
public class PreparationList {
    private boolean washFace;
    private boolean washHair;
    private boolean haveBreakfast;

    public boolean isWashFace() {
        return washFace;
    }

    public void setWashFace(boolean washFace) {
        this.washFace = washFace;
    }

    public boolean isWashHair() {
        return washHair;
    }

    public void setWashHair(boolean washHair) {
        this.washHair = washHair;
    }

    public boolean isHaveBreakfast() {
        return haveBreakfast;
    }

    public void setHaveBreakfast(boolean haveBreakfast) {
        this.haveBreakfast = haveBreakfast;
    }
}
