package com.ncTestService.converters;


import com.ncTestService.DTO.ECTFDTO;
import com.ncTestService.models.EnrollmentCityTestFormat;

public interface ECTFConverter {

    ECTFDTO convertToDTO(EnrollmentCityTestFormat ectf);

    EnrollmentCityTestFormat convertFromDTO(ECTFDTO ectfdto);

}
