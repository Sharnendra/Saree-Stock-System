package com.shopsaree.stock.bean.response;

import org.springframework.stereotype.Component;

import com.shopsaree.stock.exception.HrAppException;

@Component
public class RestResponse implements Response{

	private String requestId;
	private ResponseData data;
	private HrAppException error;
	
	public RestResponse() {
		super();
	}

	public RestResponse(String requestId) {
		this.requestId = requestId;
	}
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public ResponseData getData() {
		return data;
	}
	public void setData(ResponseData data) {
		this.data = data;
	}
	public HrAppException getError() {
		return error;
	}
	public void setError(HrAppException error) {
		this.error = error;
	}
}
