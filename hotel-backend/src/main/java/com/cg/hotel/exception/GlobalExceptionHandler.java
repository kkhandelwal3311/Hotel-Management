package com.cg.hotel.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	// Exception for handling user not found exception
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleException(UserNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	// Exception for handling Hotel not found exception
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<Object> handleException(HotelNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	// Exception for handling Room not found exception
	@ExceptionHandler(RoomNotFoundException.class)
	public ResponseEntity<Object> handleException(RoomNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	// Exception for handling BookingDetails not found exception
	@ExceptionHandler(BookingDetailsNotFoundException.class)
	public ResponseEntity<Object> handleException(BookingDetailsNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	// Exception for handling Transaction not found exception
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<Object> handleException(TransactionNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	
	// Exception for handling Payment not found exception
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<Object> handleException(PaymentNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	
	// Exception for handling Admin not found exception
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<Object> handleException(AdminNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	// Exception for handling input validation
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		logger.error(ex.getMessage());
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		ResponseEntity<Object> entity = new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		return entity;
	}

}
