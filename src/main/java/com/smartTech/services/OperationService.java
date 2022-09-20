package com.smartTech.services;

import com.smartTech.Domain.Operation;
import com.smartTech.exeception.EtBadRequestException;
import com.smartTech.exeception.EtResourceNotFoundException;

import java.util.List;

public interface OperationService {

    List<Operation> fetchAllOperation(Long userId, Long categoryId);
    Operation fetchAllOperationById(Long userId, Long postId, Long operationId)throws EtResourceNotFoundException;
    Operation addOperation(Long userId,Long CategoryId ,Long operationId,Double price, String rate, Long operationDate) throws EtBadRequestException;
    void updateOperation(Long  userId, Long  postId, Long  operationId, Operation operation) throws EtBadRequestException;
    void removeOperation(Long userId, Long categoryId, Long  operationId) throws EtResourceNotFoundException;



}
