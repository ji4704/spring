package dw.wholesale_company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String failedName;
    private String failedValue;


    public ResourceNotFoundException(String resourceName, String failedName, String failedValue) {
        super(resourceName + "Not found with us " + failedName + " : " + failedValue);
        this.resourceName = resourceName;
        this.failedName = failedName;
        this.failedValue = failedValue;
    }
}
