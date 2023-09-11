package com.mbicycle.transactionservicedemo.controller;

import com.mbicycle.transactionservicedemo.model.TransactionInfo;
import com.mbicycle.transactionservicedemo.service.TransactionInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/rest/v1/transactions")
public class TransactionInfoController {
    private TransactionInfoService transactionInfoService;

    @PostMapping
    public void storeTransactionInfo(@RequestBody TransactionInfo transactionInfo) {
        log.info("Received storeTransactionInfo request. TransactionInfo: {}", transactionInfo);
        transactionInfoService.saveTransactionInfo(transactionInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteTransactionInfo(@PathVariable long id) {
        log.info("Received deleteTransactionInfo request. Transaction Id: {}", id);
        transactionInfoService.deleteTransactionInfo(id);
    }

    @GetMapping("/{id}")
    public TransactionInfo getTransactionInfoById(@PathVariable long id) {
        log.info("Received getTransactionInfoByIdById request. Transaction Id: {}", id);
        return transactionInfoService.findById(id);
    }

    @GetMapping("/search")
    public List<TransactionInfo> getTransactionInfoWithCriteria(@RequestParam(required = false) String actor, @RequestParam(required = false) String type,
                                                                long fromTimestamp, long toTimestamp, int pageNumber, int pageSize) {
        log.info("Received getTransactionInfo request. Actor : {}, type : {}, fromTimestamp : {}, toTimestamp : {}", actor, type, fromTimestamp, toTimestamp);
        return transactionInfoService.findTransactionInfoWithCriteria(actor, type, fromTimestamp, toTimestamp, pageNumber, pageSize);
    }
}
