package com.kodilla;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.Period;

public class PersonProcessor implements ItemProcessor<PersonInput, PersonOutput> {
    @Override
    public PersonOutput process(PersonInput personInput) {
        return new PersonOutput(personInput.getName(), personInput.getSurname(), calculateAge(personInput.getBirthDate()));
    }

    private int calculateAge(String birthDate){
        LocalDate birthLocalDate= LocalDate.parse(birthDate);
        return Period.between(birthLocalDate, LocalDate.now()).getYears();
    }

}
