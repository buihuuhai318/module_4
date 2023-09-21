package com.example.channuoiheo.dto;

import com.example.channuoiheo.model.Origin;
import com.example.channuoiheo.model.Pig;
import com.example.channuoiheo.service.IPigService;
import com.example.channuoiheo.service.imp.PigService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
public class PigDto implements Validator {
    private int id;

    private String code;

    private String dateIn;

    private String dateOut;

    private int weightIn;

    private int weightOut;

    private int paymentStatus;

    private int deleteStatus;

    private Origin origin;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

        PigDto pigDto = (PigDto) target;


        if (!pigDto.code.matches("^MH-[0-9]{1,3}")) {
            errors.rejectValue("code", "invalid", "Code Regex: MH-XXX (X: 0-9)");
        }
        if (pigDto.weightIn <= 10) {
            errors.rejectValue("weightIn", "invalid", "Weight Must More Than 10");
        }
    }
}
