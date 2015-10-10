package curupira.logsearch.app;

import curupira.logsearch.app.WebMvcConfig;
import org.junit.Test;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import static junit.framework.TestCase.assertNotNull;

public class WebMvcConfigTest {

    @Test
    public void viewResolverTest(){
        WebMvcConfig webMvcConfig = new WebMvcConfig();
        InternalResourceViewResolver resolver =  webMvcConfig.viewResolver();
        assertNotNull(resolver);
    }
}
