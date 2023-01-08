package az.orient.bankbootclient.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class RespCustomerList {

    private List<RespCustomer> response;

    private RespStatus status;
}
