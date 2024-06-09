package com.rai.ExpenseTracker.service.stats;

import com.rai.ExpenseTracker.payloads.GraphDTO;
import com.rai.ExpenseTracker.payloads.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();
    StatsDTO getStats();

}
