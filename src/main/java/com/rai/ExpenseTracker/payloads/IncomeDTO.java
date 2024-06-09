package com.rai.ExpenseTracker.payloads;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDTO {

    private Integer id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Integer amount;
}
