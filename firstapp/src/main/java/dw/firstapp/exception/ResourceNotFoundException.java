package dw.firstapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE) // 응답해주는 기능
public class ResourceNotFoundException extends RuntimeException { //ResourceNotFoundException 하나의 에외코드 -> 하나의 예외 코드당 하나의 응답코드
    private static final long serialVersionUID = 1L; // serialVersionUID long형으로 랜덤한 번호를 가지고 있다 -> 선택사항
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    // 예외객체를 만들면서 예외처리한다. - 기본생성자 필요없다

    //constructor 들어가서 runtimeException에서 매개변수 없는걸로 생성자 생성

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue)); //직접 추가하는 항목(C언어 스타일) -> 우리가 만든 exception이 super이용해 runtimeexception(부모)을 부른다.
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    //예외처리는 보통 getter만 만들어준다.
    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
