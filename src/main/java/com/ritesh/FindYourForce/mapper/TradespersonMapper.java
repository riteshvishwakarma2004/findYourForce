package com.ritesh.FindYourForce.mapper;

import com.ritesh.FindYourForce.dto.TradespersonDto;
import com.ritesh.FindYourForce.entity.Tradesperson;

public class TradespersonMapper {

//    public static Tradesperson mapToTradesperson(TradespersonDto dto){
//        Tradesperson tp = new Tradesperson(
//                                            dto.getName(),
//                                            dto.getPhone1(),
//                                            dto.getPhone2(),
//                                            dto.getExpertise(),
//                                            dto.getLocality(),
//                                            dto.getAvailability());
//
//        return tp;
//    }

    public static TradespersonDto mapToTradesPersonDto(Tradesperson tp){

        TradespersonDto dto = new TradespersonDto(
                                                    tp.getName(),
                                                    tp.getPhone1(),
                                                    tp.getPhone2(),
                                                    tp.getExpertise(),
                                                    tp.getLocality(),
                tp.getAvailability());

        return dto;
    }
}
