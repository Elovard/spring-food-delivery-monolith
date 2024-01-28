package com.dydzik.foodpetproject.service;

import com.dydzik.foodpetproject.dto.BusinessResponseDto;
import com.dydzik.foodpetproject.dto.CreateBusinessDto;
import com.dydzik.foodpetproject.entity.Business;
import com.dydzik.foodpetproject.exception.ClientNotFoundException;
import com.dydzik.foodpetproject.mapper.BusinessMapper;
import com.dydzik.foodpetproject.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BusinessService {
    private final BusinessRepository businessRepository;
    private final BusinessMapper businessMapper;

    public BusinessResponseDto create(CreateBusinessDto dto) {
        Business business = businessMapper.createBusinessFromDto(dto);
        businessRepository.save(business);
        return businessMapper.createBusinessResponseDtoFromBusiness(business);
    }

    @Transactional(readOnly = true)
    public List<Business> findAll(int page) {
        return businessRepository.findAll(PageRequest.of(page, 10)).getContent();
    }

    @Transactional(readOnly = true)
    public Business findById(Long id) {
        return businessRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public Business findByUsername(String username) {
        return businessRepository.findByUsername(username).orElseThrow(ClientNotFoundException::new);
    }

    public void deleteById(Long id) {
        Business toDelete = businessRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        businessRepository.delete(toDelete);
    }

    public Business updateBusinessUsernameById(Long id, String username) {
        Business businessToUpdate = businessRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        businessToUpdate.setUsername(username);
        businessRepository.save(businessToUpdate);
        return businessToUpdate;
    }
}
