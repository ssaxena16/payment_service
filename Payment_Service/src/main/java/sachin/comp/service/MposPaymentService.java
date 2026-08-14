package sachin.comp.service;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sachin.comp.dao.MposPaymentDao;
import sachin.comp.dto.request.MposPaymentRequest;
import sachin.comp.dto.request.MposPaymentResponse;
import sachin.comp.entity.MposPayment;
import sachin.comp.kafka.Producer;
import sachin.comp.kafka.events.PaymentEvent;
import sachin.comp.utils.CommonUtil;

import java.time.LocalDateTime;

@Service
public class MposPaymentService {
    private final MposPaymentDao mposPaymentDao;
    private final Producer producer;
    public MposPaymentService(MposPaymentDao mposPaymentDao, Producer producer) {
        this.mposPaymentDao = mposPaymentDao;
        this.producer = producer;

    }
    public MposPaymentResponse processPayment(MposPaymentRequest mposPaymentRequest) {

         MposPayment mposPayment = MposPayment.builder().paymentId(CommonUtil.generateUniqueId("PC-"))
                 .orderId(mposPaymentRequest.getOrderId())
                 .merchantId(mposPaymentRequest.getMerchantId())
                 .transactionAmount(mposPaymentRequest.getTransactionAmount())
                 .currency(mposPaymentRequest.getCurrency())
                 .transactionStatus("SUCCESS")
                 .responseCode("0000")
                 .responseMessage("Payment Successful")
                 .createdOn(LocalDateTime.now())
                 .updatedOn(LocalDateTime.now())
                 .build();
          mposPaymentDao.save(mposPayment);
          publishPaymentEvent(mposPayment);
          return  MposPaymentResponse.builder() .paymentId(mposPayment.getPaymentId())
                 .orderId(mposPayment.getOrderId())
                 .merchantId(mposPayment.getMerchantId())
                 .transactionAmount(mposPayment.getTransactionAmount())
                 .currency(mposPayment.getCurrency())
                 .transactionStatus(mposPayment.getTransactionStatus())
                 .responseCode(mposPayment.getResponseCode())
                 .responseMessage(mposPayment.getResponseMessage())
                 .build();

    }

    private void publishPaymentEvent(MposPayment mposPayment) {
        PaymentEvent paymentEvent = new PaymentEvent();
        BeanUtils.copyProperties(mposPayment, paymentEvent);
        producer.publishEvent("SavePayment", mposPayment.getPaymentId(), "payment-topic", paymentEvent);

    }
}
