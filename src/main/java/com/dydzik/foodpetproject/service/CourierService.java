package com.dydzik.foodpetproject.service;

import com.dydzik.foodpetproject.dto.CourierResponseDto;
import com.dydzik.foodpetproject.dto.CreateCourierDto;
import com.dydzik.foodpetproject.entity.Business;
import com.dydzik.foodpetproject.entity.Courier;
import com.dydzik.foodpetproject.exception.ClientNotFoundException;
import com.dydzik.foodpetproject.mapper.CourierMapper;
import com.dydzik.foodpetproject.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    public CourierResponseDto create(CreateCourierDto dto) {
        Courier courier = courierMapper.createCourierFromDto(dto);
        courierRepository.save(courier);
        return courierMapper.courierResponseDtoFromCourier(courier);
    }

    @Transactional(readOnly = true)
    public List<Courier> findAll(int page) {
        return courierRepository.findAll(PageRequest.of(page, 10)).getContent();
    }

    @Transactional(readOnly = true)
    public Courier findById(Long id) {
        return courierRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public Courier findByUsername(String username) {
        return courierRepository.findByUsername(username).orElseThrow(ClientNotFoundException::new);
    }

    public void deleteById(Long id) {
        Courier toDelete = courierRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        courierRepository.delete(toDelete);
    }

    public Courier updateCourierUsernameById(Long id, String username) {
        Courier courierToUpdate = courierRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        courierToUpdate.setUsername(username);
        courierRepository.save(courierToUpdate);
        return courierToUpdate;
    }

}
