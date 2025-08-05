package com.why.BusApp.Repository.Bus;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.why.BusApp.Entity.Bus.Availability;
import com.why.BusApp.Entity.Bus.Bus;
@Repository
public interface BusRepo extends JpaRepository<Bus, Long>{
	
	@Query(value="SELECT * FROM Bus  WHERE LOWER(name) =lower(:name)",nativeQuery =true)
	List<Bus> getmatchedbus(@Param("name") String name);
	
	@Query(
		    value = "SELECT a.* FROM bus b JOIN availability a ON a.bus_id = b.id WHERE b.name = :name AND a.available_date = :date",nativeQuery = true
		)
	List<Availability> findBusesByNameAndDate(@Param("name") String name, @Param("date") LocalDate date);
	
	
	@Query(value = """
		    SELECT b.* 
		    FROM bus b
		    JOIN route r ON b.route_id = r.id
		    WHERE EXISTS (
		        SELECT 1 
		        FROM stops s 
		        WHERE s.route_id = r.id AND LOWER(s.stop_name) = LOWER(:boarding)
		    )
		    AND EXISTS (
		        SELECT 1 
		        FROM stops s 
		        WHERE s.route_id = r.id AND LOWER(s.stop_name) = LOWER(:destination)
		    )
		""", nativeQuery = true)
	List<Bus> getBusByRoute(@Param("boarding") String boarding,@Param("destination") String destination);


}
