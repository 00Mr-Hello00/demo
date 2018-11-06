package sut.sa.g09.Repository;

import sut.sa.g09.Entity.PaymentsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaymentsTypeRepository extends JpaRepository <PaymentsType,Long> {


    PaymentsType findBypaymentsTypeDI(Long paymentsTypeDI);
}