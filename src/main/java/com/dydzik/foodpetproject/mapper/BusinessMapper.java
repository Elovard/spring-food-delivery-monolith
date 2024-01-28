package com.dydzik.foodpetproject.mapper;

import com.dydzik.foodpetproject.dto.BusinessResponseDto;
import com.dydzik.foodpetproject.dto.CreateBusinessDto;
import com.dydzik.foodpetproject.entity.Business;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
    Business createBusinessFromDto(CreateBusinessDto dto);
    BusinessResponseDto createBusinessResponseDtoFromBusiness(Business business);
}
