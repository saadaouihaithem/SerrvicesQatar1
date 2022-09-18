package com.smartTech.services;

import com.smartTech.Domain.Operation;
import com.smartTech.exeception.EtBadRequestException;
import com.smartTech.exeception.EtResourceNotFoundException;

import java.util.List;

public interface OperationService {

    List<Operation> fetchAllOperation(Integer userId, Integer categoryId);
    Operation fetchAllOperationById(Integer userId,Integer categoryId, Integer operationId)throws EtResourceNotFoundException;
    Operation addOperation(Integer userId,Integer CategoryId ,Integer operationId,Double price, String rate, Long operationDate) throws EtBadRequestException;
    void updateOperation(Integer userId, Integer categoryId, Integer operationId, Operation operation) throws EtBadRequestException;
    void removeOperation(Integer userId, Integer categoryId, Integer operationId) throws EtResourceNotFoundException;



}
