package com.mbicycle.transactionservicedemo.model;

import com.mbicycle.transactionservicedemo.util.HashMapConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Id is mandatory")
    private Long id;
    @NotNull(message = "Timestamp is mandatory")
    private Long timestamp;
    @NotBlank(message = "Type is mandatory")
    private String type;
    @NotBlank(message = "Actor is mandatory")
    private String actor;

    @Convert(converter = HashMapConverter.class)
    private Map<String, String> transactionData;

}
