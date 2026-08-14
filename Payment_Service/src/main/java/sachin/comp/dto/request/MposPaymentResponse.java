package sachin.comp.dto.request;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MposPaymentResponse implements Serializable {
    private String paymentId;

    private String orderId;

    private String merchantId;

    private BigDecimal transactionAmount;

    private String currency;

    private String transactionStatus;

    private String responseCode;

    private String responseMessage;
}
