package de.muenchen.service.controller;

import de.muenchen.service.FaqServiceApplication;
import de.muenchen.service.search.FaqSearch;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by dennis_huning on 05.01.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(FaqServiceApplication.class)
@WebIntegrationTest(randomPort = true)
public class SearchControllerTest {

    RestTemplate restTemplate = new TestRestTemplate();
    @Value("${local.server.port}")
    int port;
    @Autowired
    WebApplicationContext wac;
    String authorizationHeaderValue = buildAuthorizationHeaderValue();
    private MockMvc mockMvc;
    @Autowired
    private FaqSearch faqSearchMock;

    public static String buildAuthorizationHeaderValue() {
        String plainCreds = "user:password";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        return "Basic " + base64Creds;
    }

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void searchTest2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/search?q=test")
                .header("Authorization", authorizationHeaderValue)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void searchTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", authorizationHeaderValue);

        String url = "http://localhost:" + port + "/search?q=test";

        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        Object entities = response.getBody();
        assertNotNull(entities);
        //assertFalse(entities.isEmpty());
        //assertNotNull(entities.get(0));
    }
}
