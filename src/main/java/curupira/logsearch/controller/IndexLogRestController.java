package curupira.logsearch.controller;

import curupira.logsearch.app.Config;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * rest controller designed to expose the functionality
 * renders response as JSON
 */
@org.springframework.web.bind.annotation.RestController
public class IndexLogRestController {

    @RequestMapping("/services/indexlog")
    public String indexlog(@RequestParam(value="log", defaultValue="") String log){
        try {
            Config.getIndexer().indexLogLine(log, "default");
        } catch (Exception e) {
            return "nack";
        }

        return "ack";
    }
}
