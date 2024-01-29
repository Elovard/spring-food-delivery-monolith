package com.dydzik.foodpetproject.mapper;

import com.dydzik.foodpetproject.dto.CourierResponseDto;
import com.dydzik.foodpetproject.dto.CreateCourierDto;
import com.dydzik.foodpetproject.entity.Courier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier createCourierFromDto(CreateCourierDto dto);
    CourierResponseDto courierResponseDtoFromCourier(Courier courier);
}
