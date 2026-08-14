package sachin.comp.kafka.events;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class PaymentEvent {

        private String paymentId;

        private String orderId;

        private String merchantId;

        private BigDecimal transactionAmount;

        private String currency;

        private String transactionStatus;

        private String responseCode;

        private String responseMessage;

        private LocalDateTime createdOn;

        private LocalDateTime updatedOn;

}
