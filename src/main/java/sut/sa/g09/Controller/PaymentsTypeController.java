package sut.sa.g09.Controller;

import sut.sa.g09.Entity.PaymentsType;
import sut.sa.g09.Repository.PaymentsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PaymentsTypeController {

    @Autowired
    private final PaymentsTypeRepository paymentsTypeRepository;

    public PaymentsTypeController(PaymentsTypeRepository paymentsTypeRepository) {
        this.paymentsTypeRepository = paymentsTypeRepository;
    }
    @GetMapping("/PaymentsType")
    public Collection<PaymentsType> PaymentsType() {

        return paymentsTypeRepository.findAll().stream().collect(Collectors.toList());
    }
}