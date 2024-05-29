package dw.wholesale_company.service;

import dw.wholesale_company.exception.ResourceNotFoundException;
import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Mileage;
import dw.wholesale_company.repository.CustomerRepository;
import dw.wholesale_company.repository.MileageRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MileageRepository mileageRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    //선생님 코드:)
    //고객 전체의 평균마일리지보다 평균마일리지가 큰 고객 정보
    public List<Customer> getCustomerWithHighMileThanAvg() {
        List<Customer> customers = customerRepository.findAll();
        long sum = 0;
        for (int i = 0; i < customers.size(); i++) {
            sum = sum + customers.get(i).getMileage();
        }
        Double avg = (double) sum / (double) customers.size();
        // 평균 구할때 float보다 실수형 자료형의 기본데이터 타입인 Double 을 사용하는 것이 효율적이다.
        return customers.stream().filter(c -> c.getMileage() > avg)
                .collect(Collectors.toList());
    }

    //마일리지 등급명별로 고객수를 보이시오
    //자바로 표현하기
    public int getCustomerByMileageGrade(String grade) {
/*        List<Customer> customerList = customerRepository.findAll();
        List<Mileage> mileageList = mileageRepository.findAll();
        int count = 0;
        Mileage selectedMileage = null;
        for (int i = 0; i < mileageList.size(); i++) {
            Mileage mileage = mileageList.get(i);
            if (mileage.getMileageGrade().equalsIgnoreCase(grade)) {
                selectedMileage = mileage;
                break;
            }
        }
        if (selectedMileage != null) {
            long lowLimit = selectedMileage.getLowLimit();
            long highLimit = selectedMileage.getHighLimit();
            for (int i = 0; i < customerList.size();i++) {
                Customer customer = customerList.get(i);
                long customerMileage = customer.getMileage();
                if (customerMileage > lowLimit && customerMileage < highLimit) {
                    count++;
                }
            }
        }
        return count;
    }*/
        //람다식으로 표현하기
    /*    List<Customer> customerList = customerRepository.findAll();
        List<Mileage> mileageList = mileageRepository.findAll();

        // 선택된 Mileage 객체 찾기
        Mileage selectedMileage = mileageList.stream()
                .filter(mileage -> mileage.getMileageGrade().equalsIgnoreCase(grade))
                .findFirst()
                .orElse(null);

        // 선택된 Mileage가 있는 경우 고객 목록에서 범위 내의 고객 수를 계산
        if (selectedMileage != null) {
            long lowLimit = selectedMileage.getLowLimit();
            long highLimit = selectedMileage.getHighLimit();

            // 스트림을 사용하여 조건을 충족하는 고객 수를 계산
            return (int) customerList.stream()
                    .filter(customer -> {
                        long customerMileage = customer.getMileage();
                        return customerMileage > lowLimit && customerMileage < highLimit;
                    })
                    .count();
        }

        // 선택된 Mileage가 없는 경우 0을 반환
        return 0;
    }
    */
        // 람다식 압축
        return mileageRepository.findAll().stream()
                .filter(mileage -> mileage.getMileageGrade().equalsIgnoreCase(grade))
                .findFirst()
                .map(mileage -> customerRepository.findAll().stream()
                        .filter(customer -> {
                            long customerMileage = customer.getMileage();
                            long lowLimit = mileage.getLowLimit();
                            long highLimit = mileage.getHighLimit();
                            return customerMileage > lowLimit && customerMileage < highLimit;
                        })
                        .count())
                .orElse(0L).intValue();
    }
    //마일리지 등급명별로 고객수를 보이시오
    //선생님 코드
    public List<Customer> getCustomerByMileageGradeT(String grade){
        Optional<Mileage> mileageOptional = mileageRepository.findById(grade);
        if(mileageOptional.isEmpty()) {
            throw new ResourceNotFoundException("Mileage","Grade", grade);
        }
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().filter(customer -> customer.getMileage() >= mileageOptional.get().getLowLimit()
                && customer.getMileage() <= mileageOptional.get().getHighLimit()).collect(Collectors.toList());
    }
}