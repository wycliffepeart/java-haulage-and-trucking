package org.jht.server.repository;

import org.jht.server.entity.OrderEntity;
import org.jht.server.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    /**
     * Finds OrderEntities created between the given start and end dates.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return a list of OrderEntities created between the start and end dates
     */
    List<OrderEntity> findByDriverAndCreatedAtBetween(Staff driver, Date startDate, Date endDate);
}
