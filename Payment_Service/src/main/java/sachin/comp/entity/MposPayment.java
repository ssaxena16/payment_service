package sachin.comp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(schema = "businesstxn", name = "mpos_payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MposPayment {
    @Id
    @Column(name = "payment_id")
    private String paymentId;

    @Column(nullable = false)
    private String orderId;

    @Column(nullable = false)
    private String merchantId;

    @Column(nullable = false)
    private BigDecimal transactionAmount;

    private String currency;

    @Column(nullable = false)
    private String transactionStatus;

    private String responseCode;

    private String responseMessage;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

}
