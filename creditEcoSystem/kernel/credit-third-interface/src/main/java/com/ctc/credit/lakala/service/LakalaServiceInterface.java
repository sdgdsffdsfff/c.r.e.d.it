package com.ctc.credit.lakala.service;

public interface LakalaServiceInterface<T,K> {
	T doRequest(K requestParam) throws Exception ;

}
