package sachin.comp.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class MposPaymentRequest implements Serializable {
    private String orderId;

    private String merchantId;

    private BigDecimal transactionAmount;

    private String currency;

}
