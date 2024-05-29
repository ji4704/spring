package dw.gameshop.expection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class ResourceNotFoundException extends RuntimeException{

    //ResourceNotFoundException 예외 클래스에 포함된 필드는 예외 메시지의 상세한 정보 제공을 위해 사용됩니다. 각 필드의 역할을 살펴보면 다음과 같습니다.
    //resourceName: 이 필드는 요청 중에 찾을 수 없었던 자원의 이름을 저장합니다. 이 정보는 예외를 처리할 때 개발자가 어떤 자원에 문제가 있는지 파악하는 데 도움이 됩니다.
    //fieldName: 이 필드는 요청 중에 문제가 된 특정 필드의 이름을 저장합니다. 예를 들어, 데이터베이스에서 특정 테이블의 열을 찾을 수 없을 때, 이 필드는 그 열의 이름을 저장할 수 있습니다.
    //fieldValue: 이 필드는 문제를 일으킨 값이나 요청 중에 사용된 값을 저장합니다. 예를 들어, 사용자 ID나 주문 번호와 같은 값이 요청 중에 문제가 되었을 때, 이 값을 저장할 수 있습니다.
    //이러한 필드들은 예외를 처리할 때 어떤 자원, 필드, 값에 문제가 있었는지 상세한 정보를 제공하여 문제를 더 쉽게 진단하고 해결할 수 있도록 도와줍니다.
    // 또한, 이 예외를 발생시킬 때 예외 메시지에 이러한 필드를 포함하면, 오류 메시지를 더 구체적이고 이해하기 쉽게 만들어 줍니다.
    private static final long serialVersionUID= 1L;
    private String resourceName;
    private String filedName;
    private Object filedValue;

    public ResourceNotFoundException(String resourceName, String filedName, Object filedValue) {
//        super(String.format("%s not found with us %s : %s", resourceName, filedName,filedValue));
        super(resourceName + " not found with us " + filedName + " : " + filedValue);
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.filedValue = filedValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFiledName() {
        return filedName;
    }

    public Object getFiledValue() {
        return filedValue;
    }
}
