package com.foundation.listener.door;

import java.util.EventObject;

/**
 * 事件状态对象
 * @author xxn
 * @date 2016年1月28日  下午6:53:09
 */
@SuppressWarnings("serial")
public class DoorEvent extends EventObject {
	private String doorState = "";// 表示门的状态，有“开”和“关”两种

    public DoorEvent(Object source, String doorState) {
        super(source);
        this.doorState = doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    public String getDoorState() {
        return this.doorState;
    }
}
