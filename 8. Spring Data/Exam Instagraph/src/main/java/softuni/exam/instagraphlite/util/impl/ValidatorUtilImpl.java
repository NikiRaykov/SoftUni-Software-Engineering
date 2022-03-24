package softuni.exam.instagraphlite.util.impl;

import org.springframework.stereotype.Component;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidatorUtilImpl implements ValidatorUtil {
    @Override
    public <E> boolean isValid(E entity) {
        Validator validator =
                Validation.buildDefaultValidatorFactory().getValidator();

        return validator.validate(entity).isEmpty();
    }
}
