package pl.infoshare.junit5._2_exercise;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrafficController {

    private final TrafficReportService trafficReportService;

    public TrafficController(TrafficReportService trafficReportService) {
        this.trafficReportService = trafficReportService;
    }

    @PostMapping("/reports/traffic")
    public void reportTraffic(@RequestBody List<TrafficEntry> trafficEntries) {
        trafficReportService.report(trafficEntries);
    }
}
