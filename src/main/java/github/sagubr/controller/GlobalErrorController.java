package github.sagubr.controller;

import github.sagubr.exceptions.UserNotFoundException;
import io.micronaut.data.exceptions.EmptyResultException;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Produces;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

import java.util.NoSuchElementException;

@Controller
public class GlobalErrorController {

    @Error(global = true)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<ApiError> handleUserNotFoundException(UserNotFoundException exception) {
        ApiError apiError = new ApiError("UserNotFoundException", exception.getMessage());
        return HttpResponse.badRequest(apiError);
    }

    @Error(global = true)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<ApiError> handleNoSuchElementException(NoSuchElementException exception) {
        ApiError apiError = new ApiError("NoSuchElementException", exception.getMessage());
        return HttpResponse.badRequest(apiError);
    }

    @Error(global = true)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<ApiError> handleEntityNotFoundException(EntityNotFoundException exception) {
        ApiError apiError = new ApiError("EntityNotFoundException", exception.getMessage());
        return HttpResponse.badRequest(apiError);
    }

    @Error(global = true)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<ApiError> handleEmptyResultException(EmptyResultException exception) {
        ApiError apiError = new ApiError("EmptyResultException", exception.getMessage());
        return HttpResponse.badRequest(apiError);
    }

    @Error(global = true)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<ApiError> handleIllegalStateException(IllegalStateException exception) {
        ApiError apiError = new ApiError("IllegalStateException", exception.getMessage());
        return HttpResponse.badRequest(apiError);
    }

    @Error(global = true)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<ApiError> handleIllegalArgumentException(IllegalArgumentException exception) {
        ApiError apiError = new ApiError("IllegalArgumentException", exception.getMessage());
        return HttpResponse.badRequest(apiError);
    }

    @Error(global = true)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<ApiError> handleConstraintViolationException(ConstraintViolationException exception) {
        ApiError apiError = new ApiError("ConstraintViolationException", exception.getMessage());
        return HttpResponse.badRequest(apiError);
    }

}
