package com.github.openkengboy.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.openkengboy.validation.model.BodyRequest;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port );
    }

    @Test
    public void simpleTestHello() {
        String url = base.toString() + "/hello-test";
        ResponseEntity<String> response = template.getForEntity(url, String.class);

        assertEquals("Hello World!", response.getBody());
    }
    
    @Test
    public void simpleTestHelloWithBody() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
    	  
        String url = base.toString() + "/hello";
        ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, 
        		new HttpEntity<BodyRequest>(new BodyRequest(null, "keng"), headers), String.class);

        assertEquals(400, response.getStatusCodeValue());
      
    }
}
