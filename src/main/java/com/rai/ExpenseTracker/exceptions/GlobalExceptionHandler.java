//package com.rai.ExpenseTracker.exceptions;
//
//import com.rai.payloads.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiResponse> responseResponseEntityHandle(ResourceNotFoundException exception){
//        String message = exception.getMessage();
//        ApiResponse apiResponse = new ApiResponse(message,false);
//        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException exception){
//
//        Map<String,String> res = new HashMap<>();
//        exception.getBindingResult().getAllErrors().forEach((error)-> {
//            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            res.put(fieldName,message);
//        });
//
//        return new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
//    }
//}
