package com.smartTech.Controller;

import com.smartTech.Domain.Operation;

import com.smartTech.services.OperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/post/{postId}/operation")

public class OperationResource{

   private final OperationService operationService;
  @Autowired
    public OperationResource(OperationService operationService) {
        this.operationService = operationService;
    }


    @GetMapping
    public ResponseEntity<List<Operation>> getAllOperation(HttpServletRequest request,
                                                           @PathVariable("postId") Long  postId) {
      Long userId = (Long) request.getAttribute("userId");
        List<Operation> operation =operationService.fetchAllOperation(userId,postId);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @GetMapping("{operationId}")
    public ResponseEntity<Operation> getoperationById(HttpServletRequest request,
                                                      @PathVariable("postId") Long postId,
                                                      @PathVariable("operationId") Long  operationId) {
        Long userId = (Long) request.getAttribute("userId");
        Operation  operation = operationService.fetchAllOperationById(userId,postId,operationId);
        System.out.println("println hello Test ");
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Operation> addOperation(HttpServletRequest request,
                                                  @PathVariable("postId") Long postId, Long  operationId,
                                                  @RequestBody  Map<String,Object> operationMap){

        Long userId = (Long) request.getAttribute("userId");
        Double price = Double.valueOf(operationMap.get("price").toString());
        String rate = (String) operationMap.get("rate");
        Long operationDate = (Long) operationMap.get("operationDate");
        Operation operation  = operationService.addOperation(userId, postId, operationId, price,rate,operationDate);
        System.out.println("println hello Test ");
        return new ResponseEntity<>(operation, HttpStatus.CREATED);
    }

    @PutMapping("{operationId}")
    public ResponseEntity<Map<String, Boolean>> updateOperation(HttpServletRequest request,
                                                                @PathVariable("postId") Long postId,
                                                                @PathVariable("operationId") Long operationId,
                                                                @RequestBody  Operation operation) {
      Long userId = (Long) request.getAttribute("userId");
        operationService.updateOperation(userId, postId, operationId,operation);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("{operationId}")
    public ResponseEntity<Map<String, Boolean>> deleteOperation(HttpServletRequest request,
                                                                @PathVariable("postId") Long postId,
                                                                @PathVariable("operationId") Long operationId) {
        Long userId = (Long) request.getAttribute("userId");
        operationService.removeOperation(userId, postId, operationId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}