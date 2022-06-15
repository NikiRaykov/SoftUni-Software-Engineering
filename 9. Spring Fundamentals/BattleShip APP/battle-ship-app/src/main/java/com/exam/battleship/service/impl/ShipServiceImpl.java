package com.exam.battleship.service.impl;

import com.exam.battleship.model.entity.Ship;
import com.exam.battleship.model.entity.service.ShipServiceModel;
import com.exam.battleship.repository.ShipRepository;
import com.exam.battleship.service.CategoryService;
import com.exam.battleship.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;


    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public void add(ShipServiceModel shipServiceModel) {
        Ship ship = this.modelMapper.map(shipServiceModel, Ship.class);

        ship.setCategory(categoryService.findByName(shipServiceModel.getCategory()));

        shipRepository.save(ship);
    }
}
