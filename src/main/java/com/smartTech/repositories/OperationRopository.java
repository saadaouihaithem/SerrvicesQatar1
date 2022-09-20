package com.smartTech.repositories;

import com.smartTech.Domain.Operation;
import com.smartTech.exeception.EtBadRequestException;
import com.smartTech.exeception.EtResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface OperationRopository  extends JpaRepository<Operation,Long> {

    List<Operation> findAll(Long userId, Long postId);

    Operation findById(Long userId,Long postId, Long operationId) throws EtResourceNotFoundException;

Long create(Long userId, Long categoryId, Double price, String rate, Long operationDate) throws EtBadRequestException;

    void update(Long userId, Long postId, Long  operationId, Operation  operation) throws EtBadRequestException;

    void removeById(Long userId, Long postId, Long  operationId) throws EtResourceNotFoundException;

    Optional<Operation> findByName(String Name);

}


