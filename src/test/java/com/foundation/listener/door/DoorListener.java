package com.foundation.listener.door;

import java.util.EventListener;

/**
 * 事件监听接口
 * @author xxn
 * @date 2016年1月28日  下午6:53:44
 */
public interface DoorListener extends EventListener {
	public void doorEvent(DoorEvent event);
}
