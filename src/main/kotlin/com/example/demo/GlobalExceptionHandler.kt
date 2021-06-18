package com.example.demo

import com.example.demo.model.ResponseModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.ResourceAccessException
import org.springframework.web.context.request.ServletWebRequest
import java.io.IOException
import javax.validation.ConstraintViolationException


@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ResourceAccessException::class, HttpServerErrorException::class, HttpServerErrorException.GatewayTimeout::class)
    fun resourceRequestHandler(ex: Exception): ResponseEntity<ResponseModel<Any>> {
        return ResponseEntity(ResponseModel(2001), HttpStatus.SERVICE_UNAVAILABLE)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<ResponseModel<Any>> {
        return ResponseEntity(ResponseModel(1999), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}