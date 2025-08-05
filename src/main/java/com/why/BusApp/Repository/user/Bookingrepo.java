package com.why.BusApp.Repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.why.BusApp.Entity.User.Bookings;

@Repository
public interface Bookingrepo extends JpaRepository<Bookings, Long> {

}
