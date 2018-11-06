package sut.sa.g09.Controller;

import sut.sa.g09.Entity.CreditCard;
import sut.sa.g09.Entity.CreditType;
import sut.sa.g09.Repository.CreditCardRepository;
import sut.sa.g09.Repository.CreditTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

class CreditCardController {

    @Autowired
    private final CreditCardRepository creditCardRepository;
    @Autowired
    private CreditTypeRepository creditTypeRepository;

    public CreditCardController(CreditCardRepository creditCardRepository) {

        this.creditCardRepository = creditCardRepository;
    }

    @GetMapping("/CreditCard")
    public Collection<CreditCard> CreditCard() {
        return creditCardRepository.findAll().stream()
                .collect(Collectors.toList());
    }



//    @PostMapping("/CreditCard")
//    public void newCreditCard(@RequestBody String textCredit)
//            throws JsonParseException, IOException {
//
//        final String decoded = URLDecoder.decode(textCredit, "UTF-8"); // DECODE UTF8
//        textCredit = decoded; // .substring(0, decoded.length() - 1); // Remove last Char at String
//
//        CreditCard newCreditCard = new CreditCard();
//
//        if (textCredit.charAt(0) == '{') { // Check Json
//
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode actualObj = mapper.readTree(textCredit);
//
//            newCreditCard.setCreditNumber((Integer)actualObj.get("creditNumber").numberValue());
//            newCreditCard.setCsc((Integer)actualObj.get("csc").numberValue());
//            newCreditCard.setExpiredDate((Integer) actualObj.get("expiredDate").numberValue());
//
//            creditCardRepository.save(newCreditCard); // บันทึก Objcet ชื่อ newCreditCard
//        }
//    }

    @PostMapping("/CreditCard/{creditNumber}/{csc}/{exp}/{typeName}")                                                  //{typeName}


    public CreditCard newCreditCard2(@PathVariable String creditNumber, @PathVariable int csc, @PathVariable Date exp, @PathVariable Long typeName) {                                                                           // , @PathVariable Long typeName

        CreditCard newCreditCard2 = new CreditCard();

        CreditType cType = creditTypeRepository.findByCreditTypeDI(typeName);

        newCreditCard2.setCreditNumber(creditNumber);
        newCreditCard2.setCsc(csc);
        newCreditCard2.setExpiredDate(exp);
       newCreditCard2.setCreditType(cType);

        return creditCardRepository.save(newCreditCard2);

    }

//    @PostMapping("/CreditCard/addCreditCard/{idCreditCard}/{creditNumber}/{csc}/{exp}/{typeName}")                                                  //{typeName}
//
//
//    public CreditCard newCreditCard3(@PathVariable String creditNumber, @PathVariable int csc,@PathVariable int exp,@PathVariable Long typeName) {                                                                           // , @PathVariable Long typeName
//
//        CreditCard newCreditCard3 = new CreditCard();
//        CreditType cType = creditTypeRepository.findByCreditTypeDI(typeName);
//
//        newCreditCard3.setCreditNumber(creditNumber);
//        newCreditCard3.setCsc(csc);
//        newCreditCard3.setExpiredDate(exp);
//        newCreditCard3.setCreditType(cType);
//
//        return creditCardRepository.save(newCreditCard3);
//
//    }





}