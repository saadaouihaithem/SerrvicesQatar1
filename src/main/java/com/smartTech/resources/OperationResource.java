package com.smartTech.resources;

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
@RequestMapping("/api/categorie/{categoryId}/operation")
public class OperationResource{

    @Autowired
    OperationService operationService;

    @GetMapping("")
    public ResponseEntity<List<Operation>> getAllOperation(HttpServletRequest request,
                                                           @PathVariable("categoryId") Integer categoryId) {
        int userId = (Integer) request.getAttribute("userId");
        List<Operation> operation =operationService.fetchAllOperation(userId,categoryId);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @GetMapping("/{operationId}")
    public ResponseEntity<Operation> getoperationById(HttpServletRequest request,
                                                      @PathVariable("categoryId") Integer categoryId,
                                                      @PathVariable("operationId") Integer operationId) {
        int userId = (Integer) request.getAttribute("userId");
        Operation  operation = operationService.fetchAllOperationById(userId,categoryId,operationId);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Operation> addOperation(HttpServletRequest request,
                                                  @PathVariable("categoryId") Integer categoryId, int  operationId,
                                                  @RequestBody  Map<String,Object> operationMap){

        int userId = (Integer) request.getAttribute("userId");
        Double price = Double.valueOf(operationMap.get("price").toString());
        String rate = (String) operationMap.get("rate");
        Long operationDate = (Long) operationMap.get("operationDate");
        Operation operation  = operationService.addOperation(userId, categoryId,operationId, price,rate,operationDate);
        return new ResponseEntity<>(operation, HttpStatus.CREATED);
    }

    @PutMapping("/{ operationId}")
    public ResponseEntity<Map<String, Boolean>> updateOperation(HttpServletRequest request,
                                                                @PathVariable("categoryId") Integer categoryId,
                                                                @PathVariable("operationId") Integer  operationId,
                                                                @RequestBody  Operation  operation) {
        int userId = (Integer) request.getAttribute("userId");
        operationService.updateOperation(userId, categoryId, operationId,operation);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/{operationId}")
    public ResponseEntity<Map<String, Boolean>> deleteOperation(HttpServletRequest request,
                                                                @PathVariable("categoryId") Integer categoryId,
                                                                @PathVariable("operationId") Integer operationId) {
        int userId = (Integer) request.getAttribute("userId");
        operationService.removeOperation(userId, categoryId, operationId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}