package com.app.common.sync.service;


public interface ISyncNotifyService {
	void syncBaseResult(final String src, final String sign, final String tradeId, final String type, final String notifyUrl, final String maxSendNum);
}
