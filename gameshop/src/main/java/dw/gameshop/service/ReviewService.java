package dw.gameshop.service;

import dw.gameshop.dto.ReviewDto;
import dw.gameshop.model.Review;
import dw.gameshop.respositroy.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
//위치에 따라 가능 단위가 다르다. -> Service 밑에 쓰면 모든것에 다 적용 된다. -> 각각 필드에 넣으면 그 필드만 Transactional이 적용된다.
@Transactional
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    public Review saveReview(Review review) {
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }
    public List<Review> getReviewALL() {
        return reviewRepository.findAll();
    }

    public List<ReviewDto> getReviewAllDto() {
        List<Review> reviewList = reviewRepository.findAll();
        List<ReviewDto> reviewDtoList = new ArrayList<>();
         /*(서비스쪽이 너무 길어지기 때문에 ReviewDto에서 생성)
        //리뷰의 리스트 안에서 for문으로 리뷰객체 중  reviewDtod에 넣을 객체들을 하나씩 꺼내서 reviewDto를 채운다.
        for (int i = 0; i < reviewList.size(); i++) {
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setReviewPoint(reviewList.get(i).getPoint());
            reviewDto.setReviewText(reviewList.get(i).getReviewText());
            reviewDto.setUserId(reviewList.get(i).getUser().getUserId());
            reviewDto.setGameId(reviewList.get(i).getGame().getId());
            reviewDto.setGameName(reviewList.get(i).getGame().getTitle());
            reviewDtoList.add(reviewDto);
        }
        return reviewDtoList;*/
        for (int i = 0; i < reviewList.size(); i++) {
            ReviewDto reviewDto = new ReviewDto();
            reviewDtoList.add(reviewDto.toReviewDtoFromReview(reviewList.get(i)));
        }
        return reviewDtoList;
    }
}
