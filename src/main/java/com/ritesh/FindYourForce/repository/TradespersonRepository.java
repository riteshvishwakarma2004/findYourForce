package com.ritesh.FindYourForce.repository;

import com.ritesh.FindYourForce.entity.Tradesperson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TradespersonRepository extends JpaRepository<Tradesperson,Integer> {

    @Query("SELECT tp FROM Tradesperson tp WHERE tp.availability=:status")
    List<Tradesperson> findAllByAvailability(String status);


    @Query("SELECT tp FROM Tradesperson AS tp where" +
            " (:expertise IS NULL OR tp.expertise LIKE %:expertise%) AND" +
            " (:locality IS NULL OR tp.locality LIKE %:locality%)")
    List<Tradesperson> findAllByFilter(@Param("expertise") String expertise, @Param("locality") String locality);

    @Query("SELECT tp FROM Tradesperson AS tp WHERE phone1=:phone1 AND pin=:pin")
    Optional<Tradesperson> findByPhone1AndPin(String phone1, Integer pin);
}
