package curupira.logsearch.app;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static junit.framework.Assert.assertEquals;

public class ClientIntegrationTest {

    private final String USER_AGENT = "Mozilla/5.0";

    @Before
    public void setup(){
        //Application.main(new String[0]);
    }
    @Test
    public void doPostTest() throws Exception {
        URL obj = new URL("http://localhost:8080/services/indexlog");
        StringBuffer response = postString(obj, "SEVERE: Servlet.service() for servlet jsp threw exception");
        assertEquals("ack", response.toString());

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
