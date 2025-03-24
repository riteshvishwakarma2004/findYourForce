package com.ritesh.FindYourForce.service;

import com.ritesh.FindYourForce.dto.FilterDto;
import com.ritesh.FindYourForce.dto.TradespersonDto;
import com.ritesh.FindYourForce.entity.Tradesperson;
import com.ritesh.FindYourForce.mapper.TradespersonMapper;
import com.ritesh.FindYourForce.repository.TradespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TradespersonService {

    @Autowired
    TradespersonRepository repo;

    public List<TradespersonDto> getTPByAvailability(){
        List<TradespersonDto> result = new ArrayList<>();
        List<Tradesperson> tp  = repo.findAllByAvailability("yes");
        for(Tradesperson person : tp){
            result.add(TradespersonMapper.mapToTradesPersonDto(person));
        }

        return result;
    }

    public List<TradespersonDto> getTPByFilter(FilterDto filter) {
        String expertise = (filter.getExpertise().isEmpty()?null:filter.getExpertise().toLowerCase());
        String location = (filter.getLocality().isEmpty()?null:filter.getLocality().toLowerCase());
        List<Tradesperson> tp = repo.findAllByFilter(expertise, location);
        List<TradespersonDto> result = new ArrayList<>();
        for(Tradesperson person : tp){
            result.add(TradespersonMapper.mapToTradesPersonDto(person));
        }

        return result;
    }

    public boolean register(Tradesperson tp) {

        try{
            repo.save(tp);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean checkDetail(String phone1, Integer pin) {
        Optional<Tradesperson> tp =repo.findByPhone1AndPin(phone1, pin);
        return tp.isPresent();

    }

    public Tradesperson getTP(String phone1, Integer pin) {
        Optional<Tradesperson> tp = repo.findByPhone1AndPin(phone1,pin);


        return tp.get();
    }


    public boolean update(Tradesperson tp) {
        try{
            repo.save(tp);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
