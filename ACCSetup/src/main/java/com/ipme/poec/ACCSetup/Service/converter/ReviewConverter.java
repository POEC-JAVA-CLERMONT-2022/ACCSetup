package com.ipme.poec.ACCSetup.Service.converter;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Service.dto.review.ReviewDTO;

@Component
public class ReviewConverter implements DTOConverter<Review, ReviewDTO> {
	
	@Override
    public ReviewDTO convertTo(Review review) {
        ReviewDTO dto = new ReviewDTO();

        BeanUtils.copyProperties(review, dto);

        return dto;
    }

    @Override
    public List<ReviewDTO> convertTo(List<Review> reviews) {
        List<ReviewDTO> dtos = new LinkedList<>();

        for (Review review : reviews) {
            dtos.add(this.convertTo(review));
        }

        return dtos;
    }

}
