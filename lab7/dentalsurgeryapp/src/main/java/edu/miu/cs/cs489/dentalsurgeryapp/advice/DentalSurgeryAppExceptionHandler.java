package edu.miu.cs.cs489.dentalsurgeryapp.advice;

import edu.miu.cs.cs489.dentalsurgeryapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DentalSurgeryAppExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePatientNotFoundException(PatientNotFoundException patientNotFoundException) {
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("errorMessage", patientNotFoundException.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePatientNotFoundException(AppointmentNotFoundException appointmentNotFoundException) {
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("errorMessage", appointmentNotFoundException.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleDataValidationError(MethodArgumentNotValidException methodArgumentNotValidException) {
        var errorMap = new HashMap<String, String>();
        methodArgumentNotValidException.getBindingResult()
                .getFieldErrors()
                .forEach(
                        error -> errorMap.put(error.getField(), error.getDefaultMessage())
                );
        return errorMap;
    }
}