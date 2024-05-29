package dw.wholesale_company.controller;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.repository.ProductRepository;
import dw.wholesale_company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("product")
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
    //선생님 코드:) 제품의 재고가 50개 미만인 제품 정보 얻기
    @GetMapping("/products/inventory/under/{num}")
    public ResponseEntity<List<Product>> getProductByInventoryUnder(@PathVariable int num) {
        return new ResponseEntity<>(productService.getProductByInventoryUnder(num),
                HttpStatus.OK);
    }

    //제품 중에서 '주스' 제품에 대한 모든 정보를 검색하시오.
    @GetMapping("products/findby/product/{productName}")
    public ResponseEntity<List<Product>> getProductByProductName(@PathVariable String productName) {
        return new ResponseEntity<>(productService.getProductByProductName(productName),HttpStatus.OK);
    }

    //제품 단가가 5,000원 이상 10,000원 이하인 제품에는 무엇이 있는지 검색하시오.
    @GetMapping("products/findby/unit/{lowLimit},{highLimit}")
    public ResponseEntity<List<Product>> getProductByUnitPrice(@PathVariable long lowLimit, @PathVariable long highLimit){
        return new ResponseEntity<>(productService.getProductByUnitPrice(lowLimit,highLimit),HttpStatus.OK);
    }
//    @GetMapping("products/findby/unit/price")
//    public ResponseEntity<List<Product>> getProductByUnitPrice(@RequestParam long lowLimit, @RequestParam long highLimit){
//        return new ResponseEntity<>(productService.getProductByUnitPrice(lowLimit,highLimit),HttpStatus.OK);
//    }
    //제품의 제품번호가 1,2,4,7,11,20 인 제품의 모든 정보를 보이시오.
    //포스트맨에서 배열 형태로 요청함 -> 본문에 [1,2,4,7,11,20] 형태로 요청
    @GetMapping("products/number/byid/list")
    public ResponseEntity<List<Product>> getProductByIdForList(@RequestBody List<Long> productIds) {
        return new ResponseEntity<>(productService.getProductByIdForList(productIds),HttpStatus.OK);
    }
    @GetMapping("/products/inventoryprice/{limit}")
    public ResponseEntity<List<Product>> getProductByInventoryPrice(@PathVariable int limit) {
        return new ResponseEntity<>(productService.getProductByInventoryPrice(limit),
                HttpStatus.OK);
    }
}
