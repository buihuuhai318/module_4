package com.example.channuoiheo.dto;

import com.example.channuoiheo.model.FixMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PctDto implements Validator {
    private int id;

    private String code;

    private String leader;

    private String employee;

    private String note;

    private String dateStart;

    private String dateEnd;

    private FixMethod fixMethod;

    private int available;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PctDto pctDto = (PctDto) target;

        LocalDate localDateNow = LocalDate.now();

        if (pctDto.dateEnd.equals("") || pctDto.dateStart.equals("")) {
            if (pctDto.dateEnd.equals("")) {
                errors.rejectValue("dateEnd", "invalid", "not null");
            }
            if (pctDto.dateStart.equals("")) {
                errors.rejectValue("dateStart", "invalid", "not null");
            }
        } else {
            LocalDate start = LocalDate.parse(pctDto.dateStart);
            LocalDate end = LocalDate.parse(pctDto.dateEnd);
            if (start.isBefore(localDateNow)) {
                errors.rejectValue("dateStart", "invalid", "date start must be or after today");
            }
            if (end.isBefore(start)) {
                errors.rejectValue("dateEnd", "invalid", "date end must be or after date start");
            }
        }


        if (pctDto.code.equals("")) {
            errors.rejectValue("code", "invalid", "not null");
        }
        if (pctDto.leader.equals("")) {
            errors.rejectValue("leader", "invalid", "not null");
        }
        if (pctDto.employee.equals("")) {
            errors.rejectValue("employee", "invalid", "not null");
        }
        if (pctDto.note.equals("")) {
            errors.rejectValue("note", "invalid", "not null");
        }
    }
}
