package com.rai.ExpenseTracker.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private Integer id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Integer amount;

}
