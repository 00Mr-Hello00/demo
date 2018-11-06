package sut.sa.g09.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g09.Entity.CreditCard;
import sut.sa.g09.Entity.Payee;
import sut.sa.g09.Entity.Payments;
import sut.sa.g09.Entity.PaymentsType;
import sut.sa.g09.Repository.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class PaymentsController {

    @Autowired
        private final PaymentsRepository paymentsRepository;
    @Autowired
        private PayeeRepository payeeRepository;
    @Autowired
        private CreditCardRepository creditCardRepository;
    @Autowired
        private PaymentsTypeRepository paymentsTypeRepository;
    @Autowired
        private RecordRopository recordRopository;

  PaymentsController( PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
  }
  @GetMapping("/Payments")
    public Collection<Payments> Payment(){
        return paymentsRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/Payments/{pType}/{payName}/{price}/{payeeName}")
    public Payments newPayment( @PathVariable Long pType,@PathVariable Long payeeName
                                ,@PathVariable String payName,@PathVariable float price) {
        Payments newPayment = new Payments();
        PaymentsType pType0 = paymentsTypeRepository.findBypaymentsTypeDI(pType);
//      CreditCard creditNum = creditCardRepository.findByCreditID(CreditNumber);
        Payee pName = payeeRepository.findByPayeeID(payeeName);

        newPayment.setPrice(price);
        newPayment.setPaymentsType(pType0);
        newPayment.setNamePay(payName);
//      newPayment.setCredit(creditNum);
        newPayment.setDatePayments(new Date());
        newPayment.setPayee(pName);

        return paymentsRepository.save(newPayment);
    }

    @PostMapping("/Payments/{pType}/{payName}/{price}/{CreditNumber}/{payeeName}")
    public Payments newPayment( @PathVariable Long pType,@PathVariable Long payeeName,
                                @PathVariable Long CreditNumber,@PathVariable String payName,@PathVariable float price) {

        Payments newPayment = new Payments();
        PaymentsType pType0 = paymentsTypeRepository.findBypaymentsTypeDI(pType);

        CreditCard creditNum = creditCardRepository.findByCreditID(CreditNumber);
        Payee pName = payeeRepository.findByPayeeID(payeeName);


        newPayment.setPrice(price);
        newPayment.setPaymentsType(pType0);
        newPayment.setNamePay(payName);
        newPayment.setCredit(creditNum);
        newPayment.setDatePayments(new Date());
        newPayment.setPayee(pName);

        return paymentsRepository.save(newPayment);
    }

}