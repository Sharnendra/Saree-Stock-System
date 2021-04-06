package com.shopsaree.stock.bean.response;

import com.shopsaree.stock.exception.HrAppException;

public interface Response {
	String getRequestId();
	ResponseData getData();
	HrAppException getError();
}
