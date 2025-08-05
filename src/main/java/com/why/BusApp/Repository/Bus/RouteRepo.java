package com.why.BusApp.Repository.Bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.why.BusApp.Entity.Bus.Route;

@Repository
public interface RouteRepo extends JpaRepository<Route,Integer> {

}
