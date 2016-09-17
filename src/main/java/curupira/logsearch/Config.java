package curupira.logsearch;

import com.curupira.index.FSLogIndexer;
import com.curupira.index.LogIndexer;
import com.curupira.search.LogSearch;
import com.curupira.search.SimpleLogSearch;

import java.io.IOException;

public class Config {

    public static final String LOGSEARCH_INDEX_PATH = "LOGSEARCH_INDEX_PATH";

    private static final String DEFAULT_INDEX_PATH="luceneIndex.index";

    private static LogIndexer indexer;

    private static LogSearch searcher;

    public static String getFileIndexPath(){
        
        String path = System.getenv(LOGSEARCH_INDEX_PATH);
        if(path==null || "".equals(path)){
            path = DEFAULT_INDEX_PATH;
        }

        return path;
    }

    public static LogIndexer getIndexer() {
        if(indexer==null){
            indexer=createIndexer();
        }
        return indexer;
    }

    public static LogSearch getSearcher() throws IOException {
        if(searcher==null){
            searcher=createSearcher();
        }

        return searcher;
    }

    private static LogSearch createSearcher() throws IOException {

        LogSearch searcher = new SimpleLogSearch(getIndexer().getDirectory());

        return searcher;
    }

    private static LogIndexer createIndexer() {
        return new FSLogIndexer(Config.getFileIndexPath());
    }
}
