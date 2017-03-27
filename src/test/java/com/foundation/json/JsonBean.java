package com.foundation.json;

import net.sf.json.JSONObject;

public class JsonBean {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String makeReturn(){
	    String jsonStr = "";
        try {
            jsonStr = JSONObject.fromObject(this).toString();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return jsonStr;
	}
}
