package sut.sa.g09.Repository;

import sut.sa.g09.Entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CreditCardRepository extends JpaRepository <CreditCard, Long> {

    CreditCard findByCreditID(Long creditNumber);
}