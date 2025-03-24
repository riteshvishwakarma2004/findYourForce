package com.ritesh.FindYourForce.controller;

import com.ritesh.FindYourForce.dto.FilterDto;
import com.ritesh.FindYourForce.dto.TradespersonDto;
import com.ritesh.FindYourForce.entity.Tradesperson;
import com.ritesh.FindYourForce.service.TradespersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Tradesperson")
public class ContractorController {

    @Autowired
    TradespersonService service;


    @GetMapping("/")
    public String getAllTP(Model model){
        System.out.println("called");
        List<TradespersonDto> tp = service.getTPByAvailability();
        model.addAttribute("objectList",tp);
        return "index";
    }

    @GetMapping("filter")
    public String getAllAfterFilter(@RequestParam("expertise") String expertise, @RequestParam("locality") String locality, Model model){
        FilterDto filter = new FilterDto(expertise,locality);
        List<TradespersonDto> tp = service.getTPByFilter(filter);
        model.addAttribute("objectList",tp);
        return "index";
    }

    @GetMapping("/addYourself")
    public String addYourself(){
        return "addYourself";
    }

    @PostMapping("register")
    public String register(@RequestParam("name") String name, @RequestParam("phone1") String phone1,
                           @RequestParam("phone2") String phone2, @RequestParam("expertise") String expertise,
                           @RequestParam("locality") String locality,@RequestParam("pin") Integer pin,
                           @RequestParam("availability") String availability){

        Tradesperson tp = new Tradesperson(name,phone1,phone2,expertise,locality,pin,availability);
        boolean result = service.register(tp);
        if(result){
            return "success";
        }
        return "failed";
    }

    @GetMapping("updateYourself1")
    public String updateYourself1(){
        return "updateYourself1";
    }

    @GetMapping("checkDetail")
    public String checkDetail(@RequestParam("phone1") String phone1, @RequestParam("pin") Integer pin, Model model){
        boolean isPresent = service.checkDetail(phone1,pin);
        if(isPresent){
            Tradesperson tp = service.getTP(phone1,pin);
            model.addAttribute("object" , tp);
            return "updateYourself2";
        }
        return "failed";
    }

    @PostMapping("change")
    public String change(@RequestParam("name") String name, @RequestParam("phone1") String phone1,
                         @RequestParam("phone2") String phone2, @RequestParam("expertise") String expertise,
                         @RequestParam("locality") String locality,@RequestParam("pin") Integer pin,
                         @RequestParam("availability") String availability){

        Tradesperson tp = new Tradesperson(name,phone1,phone2,expertise,locality,pin,availability);
        boolean result = service.update(tp);
        if(result){
            return "success";
        }
        return "failed";
    }


//    @GetMapping("/")
//    @ResponseBody
//    public ResponseEntity<List<TradespersonDto>> getAllTP(){
//        List<TradespersonDto> tp = service.getTPByAvailability();
//        return new ResponseEntity<>(tp, HttpStatus.OK);
//    }
//
//    @PostMapping("filter")
//    @ResponseBody
//    public ResponseEntity<List<TradespersonDto>> getAllAfterFilter(@RequestBody FilterDto filter){
//            List<TradespersonDto> tp = service.getTPByFilter(filter);
//            return new ResponseEntity<>(tp, HttpStatus.OK);
//    }




}
