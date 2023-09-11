package com.mbicycle.transactionservicedemo.service.impl;

import com.mbicycle.transactionservicedemo.model.TransactionInfo;
import com.mbicycle.transactionservicedemo.repository.TransactionInfoRepository;
import com.mbicycle.transactionservicedemo.service.TransactionInfoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mbicycle.transactionservicedemo.util.specifications.TransactionInfoSpecifications.*;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
@AllArgsConstructor
public class TransactionInfoServiceImpl implements TransactionInfoService {
    private TransactionInfoRepository transactionInfoRepository;


    @Override
    public TransactionInfo findById(long id) {
        return transactionInfoRepository.findById(id).orElse(null);
    }

    @Override
    public List<TransactionInfo> findTransactionInfoWithCriteria(String actor, String type, long fromTimestamp, long toTimestamp, int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Specification<TransactionInfo> transactionInfoSpecification = where(betweenTimestamp(fromTimestamp, toTimestamp));
        if (actor != null) {
            transactionInfoSpecification = transactionInfoSpecification.and(hasActor(actor));
        }

        if (type != null) {
            transactionInfoSpecification = transactionInfoSpecification.and(hasType(type));
        }

        return transactionInfoRepository.findAll(transactionInfoSpecification, paging).toList();
    }

    @Override
    public void saveTransactionInfo(TransactionInfo transactionInfo) {
        transactionInfoRepository.save(transactionInfo);
    }

    @Override
    public void deleteTransactionInfo(long id) {
        transactionInfoRepository.deleteById(id);
    }
}
