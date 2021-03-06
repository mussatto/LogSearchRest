package curupira.logsearch.app;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static junit.framework.Assert.assertEquals;

public class ClientIntegrationTest {

    private final String USER_AGENT = "Mozilla/5.0";
    public static final String SAMPLE_LOG = "/sample.log";

    @Before
    public void setup(){
        //Application.main(new String[0]);
    }
    @Test
    public void doPostTest() throws Exception {
        URL urlLocal = new URL("http://localhost:8080/index");
        StringBuffer response = postString(urlLocal, "SEVERE: Servlet.service() for servlet jsp threw exception");
        assertEquals("{'response':'ok'}", response.toString());

    }

    @Test
    public void doPostFullFileTest() throws Exception{
        URL urlLocal = new URL("http://localhost:8080/index");
        InputStream is = getClass().getResourceAsStream(SAMPLE_LOG);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuffer response = postString(urlLocal, line);
                assertEquals("{'response':'ok'}", response.toString());
            }
        }
    }

    public StringBuffer postString(URL obj, String log) throws Exception{
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");

        con.setRequestProperty("User-Agent", USER_AGENT);

        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "log="+log;

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);

        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();

        assertEquals(200, responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        return response;

    }
}
