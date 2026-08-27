package sachin.comp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sachin.comp.dto.request.MposPaymentRequest;
import sachin.comp.dto.request.MposPaymentResponse;
import sachin.comp.service.MposPaymentService;

import java.util.Map;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private MposPaymentService mposPaymentService;

    @PostMapping("/savePayment")
    public ResponseEntity<Object> saveMposPayment(@RequestBody MposPaymentRequest mposPaymentRequest) {
        MposPaymentResponse mposPaymentResponse = mposPaymentService.processPayment(mposPaymentRequest);
        return  ResponseEntity.ok(mposPaymentResponse);
    }
    @GetMapping("/fetchPayments")
    public ResponseEntity<Object> fetchPayments() {
       return  ResponseEntity.ok(Map.of("message", "Test Successfull"));
    }


}
