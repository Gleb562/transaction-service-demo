package com.mbicycle.transactionservicedemo.service;

import com.mbicycle.transactionservicedemo.model.TransactionInfo;

import java.util.List;

public interface TransactionInfoService {
    TransactionInfo findById(long id);

    List<TransactionInfo> findTransactionInfoWithCriteria(String actor, String type, long fromTimestamp, long toTimestamp, int pageNumber, int pageSize);

    void saveTransactionInfo(TransactionInfo transactionInfo);

    void deleteTransactionInfo(long id);
}
