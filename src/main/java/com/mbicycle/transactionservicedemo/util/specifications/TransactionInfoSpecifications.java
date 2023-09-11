package com.mbicycle.transactionservicedemo.util.specifications;

import com.mbicycle.transactionservicedemo.model.TransactionInfo;
import org.springframework.data.jpa.domain.Specification;

public class TransactionInfoSpecifications {
    public static Specification<TransactionInfo> hasActor(String actor) {
        return (transactionInfo, cq, cb) -> cb.equal(transactionInfo.get("actor"), actor);
    }

    public static Specification<TransactionInfo> hasType(String type) {
        return (transactionInfo, cq, cb) -> cb.equal(transactionInfo.get("type"), type);
    }

    public static Specification<TransactionInfo> betweenTimestamp(long fromTimestamp, long toTimestamp) {
        return (transactionInfo, cq, cb) -> cb.between(transactionInfo.get("timestamp"), fromTimestamp, toTimestamp);
    }
}
