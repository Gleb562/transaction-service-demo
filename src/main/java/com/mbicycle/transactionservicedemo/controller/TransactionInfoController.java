package com.mbicycle.transactionservicedemo.controller;

import com.mbicycle.transactionservicedemo.model.TransactionInfo;
import com.mbicycle.transactionservicedemo.service.TransactionInfoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/rest/v1/transactions")
public class TransactionInfoController {
    private final Logger logger = LoggerFactory.getLogger(TransactionInfoController.class);

    private TransactionInfoService transactionInfoService;

    @PostMapping
    public ResponseEntity<Void> storeTransactionInfo(@RequestBody TransactionInfo transactionInfo) {
        logger.info("Received storeTransactionInfo request. TransactionInfo: {}", transactionInfo);
        transactionInfoService.saveTransactionInfo(transactionInfo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionInfo(@PathVariable long id) {
        logger.info("Received deleteTransactionInfo request. Transaction Id: {}", id);
        transactionInfoService.deleteTransactionInfo(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/search/{id}")
    public TransactionInfo getTransactionInfoById(@PathVariable long id) {
        logger.info("Received getTransactionInfoByIdById request. Transaction Id: {}", id);
        return transactionInfoService.findById(id);
    }

    @GetMapping("/search")
    public List<TransactionInfo> getTransactionInfoWithCriteria(@RequestParam(required = false) String actor, @RequestParam(required = false) String type,
                                                                long fromTimestamp, long toTimestamp, int pageNumber, int pageSize) {
        logger.info("Received getTransactionInfo request. Actor : {}, type : {}, fromTimestamp : {}, toTimestamp : {}", actor, type, fromTimestamp, toTimestamp);
        return transactionInfoService.findTransactionInfoWithCriteria(actor, type, fromTimestamp, toTimestamp, pageNumber, pageSize);
    }
}
