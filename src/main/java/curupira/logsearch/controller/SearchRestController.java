package curupira.logsearch.controller;

import com.curupira.document.LogSearchDocument;
import com.curupira.search.LogSearch;
import com.curupira.search.SimpleLogSearch;
import curupira.logsearch.app.Config;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class SearchRestController {

    @RequestMapping("/services/search")
    public List<LogSearchDocument> indexlog(@RequestParam(value="queryString", defaultValue="") String queryString)
            throws IOException, ParseException {

        LogSearch search = Config.getSearcher();

        return search.searchString(queryString);
    }
}
