package com.taro.vo.dto;import java.util.List;import com.alibaba.fastjson.JSON;import com.alibaba.fastjson.serializer.PropertyPreFilter;import com.alibaba.fastjson.serializer.SerializeConfig;import com.alibaba.fastjson.serializer.SerializerFeature;public class ResultsDTO {		protected boolean success;	protected String msg;		protected Object data;	public ResultsDTO() {}		public ResultsDTO(String msg) {		this.success = true;		this.msg = msg;	}		public ResultsDTO(boolean success, String msg) {		this.success = success;		this.msg = msg;	}	public ResultsDTO(Object data) {		this.success = true;		this.data = data;	}	public ResultsDTO(boolean success, Object data) {		this.success = true;		this.data = data;	}	public ResultsDTO(List<?> list) {		this.success = true;		this.data = list;	}	public boolean isSuccess() {		return success;	}	public void setSuccess(boolean success) {		this.success = success;	}	public String getMsg() {		return msg;	}	public void setMsg(String msg) {		this.msg = msg;	}	public Object getData() {		return data;	}	public void setData(Object data) {		this.data = data;	}	public String toJson(){		String json = JSON.toJSONString(this,new SerializeConfig(),SerializerFeature.DisableCircularReferenceDetect);		return json;	}		public String toJson(PropertyPreFilter filter){		if (filter==null){			return toJson();		}		String json = JSON.toJSONString(this,new SerializeConfig(),filter);		return json;	}	@Override	public String toString() {		return toJson();	}	}