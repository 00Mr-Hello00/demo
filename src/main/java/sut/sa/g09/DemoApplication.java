package sut.sa.g09;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import sut.sa.g09.Entity.*;
import sut.sa.g09.Repository.*;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init(CreditTypeRepository creditTypeRepository, PaymentsTypeRepository paymentsTypeRepository, RecordRopository recordRopository) {

		return args -> {

			Stream.of("Visa", "Mastercard", "Discover", "American Express").forEach(typeName -> {

				{
					CreditType newType = new CreditType();
					newType.setTypeName(typeName);
					creditTypeRepository.save(newType);

				}

			});

			Stream.of("Cash", "Credit").forEach(typeName-> {

				{
					PaymentsType pmt = new PaymentsType();
					pmt.setTypeName(typeName);
					paymentsTypeRepository.save(pmt);

				}

			});

			// Test....................................................................................................
			Stream.of("Mr.Theerapol.S", "Mr.Yeen.S","Mr.Kondee.S").forEach(typeName->

			{

				{
					Record rec = new Record();
					rec.setHealthcheckerinfo(typeName);

					if(typeName == "Mr.Theerapol.S"){
						rec.setProgram("A");
						rec.setPayment(800);

						recordRopository.save(rec);
					}else if(typeName == "Mr.Yeen.S")
					{
						rec.setProgram("B");
						rec.setPayment(1800);
						recordRopository.save(rec);

					}else if(typeName == "Mr.Kondee.S")
					{
					rec.setProgram("C");
					rec.setPayment(560);
					recordRopository.save(rec);
					}


				}

			});



		};


	}
}


