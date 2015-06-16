package greg.aggregator.jba.annotation;

import greg.aggregator.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by greg on 15.06.15.
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository == null || userRepository.findByName(username) == null;
    }
}
