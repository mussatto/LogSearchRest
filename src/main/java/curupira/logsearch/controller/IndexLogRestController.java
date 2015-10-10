package curupira.logsearch.controller;

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

        return "ack";
    }
}
