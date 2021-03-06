package curupira.logsearch.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curupira.logsearch.Config;


/**
 * rest controller designed to expose the functionality
 * renders response as JSON
 */
@RestController
@CrossOrigin
public class IndexLogRestController {
	

    @RequestMapping("/indexLog")
    public String indexlog(@RequestParam(value="log", defaultValue="") String log,
    		@RequestParam(value="file", defaultValue="default") String file){
        try {
        	
            Config.getIndexer().indexLogLine(log, file);
            
            
        } catch (Exception e) {
            return "{'response':'error'}";
        }

        return "{'response':'ok'}";
    }
}
