package com.smartTech.repositories;

import com.smartTech.Domain.Operation;
import com.smartTech.exeception.EtBadRequestException;
import com.smartTech.exeception.EtResourceNotFoundException;

import java.util.List;

public interface OperationRopository {

    List<Operation> findAll(Integer userId, Integer categoryId);

    Operation findById(Integer userId, Integer categoryId, Integer operationId) throws EtResourceNotFoundException;

    Integer create(Integer userId, Integer categoryId, Double price, String rate, Long operationDate) throws EtBadRequestException;

    void update(Integer userId, Integer categoryId, Integer transactionId, Operation  transaction) throws EtBadRequestException;

    void removeById(Integer userId, Integer categoryId, Integer operationId) throws EtResourceNotFoundException;

}


