package com.smartTech.services;
import com.smartTech.Domain.Operation;
import com.smartTech.exeception.EtBadRequestException;
import com.smartTech.exeception.EtResourceNotFoundException;
import com.smartTech.repositories.OperationRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {
 @Autowired
 OperationRopository operationRopository;
    @Override
    public List<Operation> fetchAllOperation(Integer userId, Integer categoryId) {
        return operationRopository.findAll(userId,categoryId);
    }

    @Override
    public Operation fetchAllOperationById(Integer userId, Integer categoryId, Integer operationId) throws EtResourceNotFoundException {
        return operationRopository.findById(userId,categoryId,operationId);
    }

    @Override
    public Operation addOperation(Integer userId, Integer categoryId, Integer operationId, Double price, String rate, Long operationDate) throws EtBadRequestException {
       operationId = operationRopository.create(userId,categoryId,price,rate,operationDate);
        return operationRopository.findById(userId,categoryId,operationId);
    }

    @Override
    public void updateOperation(Integer userId, Integer categoryId, Integer operationId, Operation operation) throws EtBadRequestException{
    operationRopository.update(userId,categoryId,operationId,operation);
    }

    @Override
    public void removeOperation(Integer userId, Integer categoryId, Integer operationId) throws EtResourceNotFoundException {
      operationRopository.removeById(userId,categoryId,operationId);

    }
}