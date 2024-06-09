package com.rai.ExpenseTracker.controller;

import com.rai.ExpenseTracker.payloads.GraphDTO;
import com.rai.ExpenseTracker.payloads.StatsDTO;
import com.rai.ExpenseTracker.service.stats.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/chart")
    public ResponseEntity<GraphDTO> getChartDetails(){
        return ResponseEntity.ok(statsService.getChartData());
    }

    @GetMapping("/")
    public ResponseEntity<StatsDTO> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }

}
