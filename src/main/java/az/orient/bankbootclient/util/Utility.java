package az.orient.bankbootclient.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Utility {

    public HttpHeaders getHeaders() {
         HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Content-type","application/json");
        httpHeaders.add("Accept","application/json");
        return httpHeaders;
    }

    public String sendGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
        return res.getBody();
    }

    public String sendPost(String url,String data) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.postForEntity(url,new HttpEntity<>(data,getHeaders()),String.class);
        return res.getBody();
    }
}
