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

 private final OperationRopository operationRopository;


@Autowired
    public OperationServiceImpl(OperationRopository operationRopository) {
        this.operationRopository = operationRopository;
    }

    @Override
    public List<Operation> fetchAllOperation(Long userId, Long postId) {
        return operationRopository.findAll(userId,postId);
    }

    @Override
    public Operation fetchAllOperationById(Long  userId, Long  postId, Long  operationId) throws EtResourceNotFoundException {
        return operationRopository.findById(userId,postId,operationId);
    }

    @Override
    public Operation addOperation(Long  userId, Long postId, Long  operationId, Double price, String rate, Long operationDate) throws EtBadRequestException {
       operationId = operationRopository.create(userId,postId,price,rate,operationDate);
        return operationRopository.findById(userId,postId,operationId);
    }

    @Override
    public void updateOperation(Long  userId,Long postId, Long  operationId, Operation operation) throws EtBadRequestException{
    operationRopository.update(userId,postId,operationId,operation);
    }

    @Override
    public void removeOperation(Long  userId, Long  postId, Long  operationId) throws EtResourceNotFoundException {
      operationRopository.removeById(userId,postId,operationId);

    }
}