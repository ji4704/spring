package dw.gameshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "요청하신 페이지를 찾을 수 없습니다.")
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID= 1L;
    private String resourceName;
    private String filedName;
    private Object filedValue;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resourceName, String filedName, Object filedValue) {
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.filedValue = filedValue;


    }
}























