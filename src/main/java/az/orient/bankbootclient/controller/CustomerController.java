package az.orient.bankbootclient.controller;

import az.orient.bankbootclient.api.request.ReqToken;
import az.orient.bankbootclient.api.response.RespCustomerList;
import az.orient.bankbootclient.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final Utility utility;

    ObjectMapper objectMapper=new ObjectMapper();
    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.userId}")
    private Long apiUserId;

    @Value("${api.token}")
    private String apiToken;

    @GetMapping("/GetCustomerById/{id}")
    public @ResponseBody
    String getCustomerById(@PathVariable("id") Long customerId) {
        String url = apiUrl+"customer/GetCustomerById/1";
        String result = utility.sendGet(url);
        System.out.println(result);
        return "success";
    }

    @GetMapping("/GetCustomerList")
    public @ResponseBody
    String getCustomerList() {
        try{
            String url=apiUrl+"customer/GetCustomerList";

            ReqToken reqToken=new ReqToken();
            reqToken.setUserId(apiUserId);
            reqToken.setToken(apiToken);

            String reqTokenJson=objectMapper.writeValueAsString(reqToken);

           String result= utility.sendPost(url,reqTokenJson);
            RespCustomerList respCustomerList=objectMapper.readValue(result,RespCustomerList.class);

            if(respCustomerList.getStatus().getCode()==1){
                System.out.println(respCustomerList.getResponse());
            }else{
                System.out.println(respCustomerList.getStatus().getMessage());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }



       return "success";
    }

}
