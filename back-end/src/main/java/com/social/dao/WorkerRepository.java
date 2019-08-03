package com.social.dao;

import com.social.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {


    Worker findById(Long id);
    Worker findByPhone(String phone);
//    @Query(value = "select fields.id, fields.input from field_user,fields\n" +
//            "  where field_user.fields_id=fields .id AND\n" +
//            "  customer_id= ?1",nativeQuery = true)
//    Iterable<Worker> findFieldByUserId(Long id);
}
