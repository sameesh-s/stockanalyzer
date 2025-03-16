package com.trade.stockanalyzer.controller;

import com.trade.stockanalyzer.controller.dto.GetHistoricalCandleResponseInherited;
import com.upstox.ApiException;
import com.upstox.api.GetHistoricalCandleResponse;
import io.swagger.client.api.HistoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoricalController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get1min")
    public String get1MinHistoricalData(){
        System.out.println("hit the controller");
        inss();
        return "success";
    }

    private void inss(){
        HistoryApi apiInstance = new HistoryApi();
        String apiVersion = "2.0";
        String instrumentKey = "NSE_EQ|INE669E01016";
        String interval = "30minute";
        interval = "1minute";
        String toDate = "2025-01-13";
        String fromDate = "2025-01-12";
        try {
            GetHistoricalCandleResponse result = apiInstance.getHistoricalCandleData1(instrumentKey, interval, toDate, fromDate, apiVersion);
            GetHistoricalCandleResponseInherited out = new GetHistoricalCandleResponseInherited(result);
            mongoTemplate.save(out);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling HistoryApi#getHistoricalCandleData1");
            e.printStackTrace();
        }
    }

}

