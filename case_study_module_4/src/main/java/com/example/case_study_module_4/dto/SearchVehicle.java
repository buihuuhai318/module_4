package com.example.case_study_module_4.dto;


import com.example.case_study_module_4.model.product.VehicleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SearchVehicle {

    private int id;

    private VehicleType vehicleType;

    private String start;

    private String end;
}
