package com.yishan.javaplus.service;

import com.yishan.javaplus.domain.Car;
import com.yishan.javaplus.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    @Transactional
    public Car createNewCar(Car newCar) {
        String code = UUID.randomUUID().toString();
        save(newCar);
        return newCar;
    }

    public String carId = UUID.randomUUID().toString();

    public Car addCar(){
        return new Car();
    }


    public CarService() {

    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long Id) {
        return carRepository.findById(Id).get();
    }

    public Car findByVin(String Vin) {
        return carRepository.findByVin(Vin);
    }

    public Car findByModel(String Model) {
        return carRepository.findByModel(Model);
    }

    public Car findByBodyType(String BodyType) {
        return carRepository.findByBodyType(BodyType);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void deleteById(Long aLong) {
        carRepository.deleteById(aLong);
    }
}