package com.mbicycle.transactionservicedemo.repository;

import com.mbicycle.transactionservicedemo.model.TransactionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionInfoRepository extends JpaRepository<TransactionInfo, Long>, JpaSpecificationExecutor<TransactionInfo> {}
