package com.training.spring.advanced.customer.data;

import com.training.spring.advanced.customer.services.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerDao extends CrudRepository<Customer, Long> {

    List<Customer> findBySurname(String surname);

    List<Customer> findBySurnameAndHeight(String surname,
                                          Integer height);

    List<Customer> findBySurnameAndHeightBetween(String surname,
                                                 Integer height1,
                                                 Integer height2);

    List<Customer> findBySurnameInOrderBySurname(List<String> surname);

    @Query("select c from Customer c where c.surname=?1")
    List<Customer> searchSurname(String surname);

    @Query("select c from Customer c where c.surname=?1 and c.height=?2")
    List<Customer> searchSurnameAndHeight(String surname,
                                          Integer Height);

    @Query("select c from Customer c where c.surname=:soy and c.height=:hei")
    List<Customer> searchSurnameAndHeight2(@Param("soy") String surname,
                                           @Param("hei") Integer Height);

    @Query(value = "select * from customer c where c.surname=?1",nativeQuery = true)
    List<Customer> searchSurnameN(String surname);

    @Query(value = "select * from musteri c where c.soy=?1",nativeQuery = true)
    List<Customer> searchSurnameN2(String surname);

}
