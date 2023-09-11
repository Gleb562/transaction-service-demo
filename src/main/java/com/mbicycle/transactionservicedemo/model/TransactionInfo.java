package com.mbicycle.transactionservicedemo.model;

import com.mbicycle.transactionservicedemo.util.HashMapConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Table(name = "transaction_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInfo {
    @Id
    private Long id;
    private Long timestamp;
    private String type;
    private String actor;

    @Convert(converter = HashMapConverter.class)
    private Map<String, String> transaction_data;

}
