package curupira.logsearch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curupira.document.LogSearchDocument;
import com.curupira.search.LogSearch;

import curupira.logsearch.Config;

@RestController
@CrossOrigin
public class SearchRestController {

    @RequestMapping("/search")
    public List<LogSearchDocument> indexlog(@RequestParam(value="query", defaultValue="") String query)
            throws IOException, ParseException {

        if("".equals(query) || query==null)
            return new ArrayList<>();

        LogSearch search = Config.getSearcher();

        return search.searchString(query);
    }
}
