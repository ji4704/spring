package dw.wholesale_company.service;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    //선생님 코드:) 람다식
    //제품의 재고가 50개 미만인 제품 정보 얻기
    public List<Product> getProductByInventoryUnder(int num) {
        List<Product> productList = productRepository.findAll();
        return productList.stream().filter(p -> p.getInventory() < num)
                .collect(Collectors.toList());
    }

    //제품 중에서 '주스' 제품에 대한 모든 정보를 검색하시오.
    public List<Product> getProductByProductName(String productName) {
        List<Product> productList = productRepository.findAll();
        List<Product> productListByProductName = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().contains(productName)) {
                productListByProductName.add(productList.get(i));
            }
        }
        return productListByProductName;
    }

    //제품 단가가 5,000원 이상 10,000원 이하인 제품에는 무엇이 있는지 검색하시오.
    public List<Product> getProductByUnitPrice(long lowLimit, long highLimit) {
        List<Product> productList = productRepository.findAll();
        List<Product> productByUnitPrice = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            long unitPrice = productList.get(i).getUnitPrice();
            if (unitPrice >= lowLimit && unitPrice <= highLimit) {
                productByUnitPrice.add(productList.get(i));
            }
        }
        return productByUnitPrice;
    }

    //제품의 제품번호가 1,2,4,7,11,20 인 제품의 모든 정보를 보이시오.
    //포스트맨에서 배열 형태로 요청함 -> 본문에 [1,2,4,7,11,20] 형태로 요청
    public List<Product> getProductByIdForList(List<Long> productIds) {
//        List<Product> product = new ArrayList<>();
//        for (int i = 0; i < productIds.size(); i++) {
//            long productId = productIds.get(i);
//            Optional<Product> product1 = productRepository.findById(productId);
//            if (product1.isPresent()) {
//                product.add(product1.get());
//            }
//        }
//        return product;
        return productIds.stream().map(x -> productRepository.findById(x)).filter(Optional::isPresent)
                .map(a -> a.get())
                .collect(Collectors.toList());
    }

    //
    //제품 재고금액이 높은 상위 10개 제품
    public List<Product> getProductByInventoryPrice(int limit) {
        List<Product> productList = productRepository.findAll();
        return productList.stream().sorted(Comparator.comparingLong(
                        (Product p) -> p.getUnitPrice() * p.getInventory()).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}