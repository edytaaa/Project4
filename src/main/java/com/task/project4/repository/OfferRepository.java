package com.task.project4.repository;

import com.task.project4.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query(value = "select * from Offer where promoted=true", nativeQuery = true)
    List<Offer> findPromoted();

    @Query(value = "select * from Offer where investment_id=:id", nativeQuery = true)
    List<Offer> findByInvestment(@Param("id") Long id);

//    //LUB 2:
//    List<Offer> findByInvestment(Investment investment);

//    //LUB 3:
//    List<Offer> findByInvestmentId(Long id);



    @Query(value = "select * from Offer, Investment where" +
            " Investment.id = Offer.investment_id and" +
            " meterage>=:meterage1 and meterage<=:meterage2 and " +
            " price>=:price1 and price<=:price2 and " +
            " city like :city% order by price asc", nativeQuery = true)
    List<Offer> findPriceAsc(@Param("meterage1") double meterage1, @Param("meterage2") double meterage2,
                             @Param("price1") double price1, @Param("price2") double price2,
                             @Param("city") String city);


    @Query(value = "select * from Offer, Investment where" +
            " Investment.id = Offer.investment_id and" +
            " meterage>=:meterage1 and meterage<=:meterage2 and " +
            " price>=:price1 and price<=:price2 and " +
            " city like :city% order by price desc", nativeQuery = true)
    List<Offer> findPriceDesc(@Param("meterage1") double meterage1, @Param("meterage2") double meterage2,
                              @Param("price1") double price1, @Param("price2") double price2,
                              @Param("city") String city);


    @Query(value = "select * from Offer, Investment where" +
            " Investment.id = Offer.investment_id and" +
            " meterage>=:meterage1 and meterage<=:meterage2 and " +
            " price>=:price1 and price<=:price2 and " +
            " city like :city% order by meterage asc", nativeQuery = true)
    List<Offer> findMetAsc(@Param("meterage1") double meterage1, @Param("meterage2") double meterage2,
                           @Param("price1") double price1, @Param("price2") double price2,
                           @Param("city") String city);


    @Query(value = "select * from Offer, Investment where" +
            " Investment.id = Offer.investment_id and" +
            " meterage>=:meterage1 and meterage<=:meterage2 and " +
            " price>=:price1 and price<=:price2 and " +
            " city like :city% order by meterage desc", nativeQuery = true)
    List<Offer> findMetDesc(@Param("meterage1") double meterage1, @Param("meterage2") double meterage2,
                            @Param("price1") double price1, @Param("price2") double price2,
                            @Param("city") String city);
}