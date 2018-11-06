package sut.sa.g09.Repository;

import sut.sa.g09.Entity.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CreditTypeRepository extends JpaRepository <CreditType,Long> {


    CreditType findByCreditTypeDI(Long typeName);
}

