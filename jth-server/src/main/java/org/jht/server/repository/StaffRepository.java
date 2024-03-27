package org.jht.server.repository;

import org.jht.server.entity.Staff;
import org.jht.server.support.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    List<Staff> findAllByRole(Role role);
}