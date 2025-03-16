package com.trade.stockanalyzer.controller.dto;

import com.upstox.api.GetHistoricalCandleResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("HistoricalData_api_response")
public class GetHistoricalCandleResponseInherited extends GetHistoricalCandleResponse {
    @Id
    private String id;
    public GetHistoricalCandleResponseInherited(GetHistoricalCandleResponse result) {
        super();
        setData(result.getData());
        setStatus(result.getStatus());
    }
}
