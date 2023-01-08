package az.orient.bankbootclient.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespCustomer {
    private Long customerId;

    private String name;
    private String phone;
    private String cif;
}
