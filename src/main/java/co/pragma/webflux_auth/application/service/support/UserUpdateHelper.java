package co.pragma.webflux_auth.application.service.support;

import co.pragma.webflux_auth.application.dto.user.SaveUserDto;
import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.domain.user.valueObjects.*;

import java.util.function.Supplier;

public class UserUpdateHelper {

    public User updateFields (User user, SaveUserDto userDto, Role role) {
        return new User(
                user.id(),
                userUpdateFieldNullValueCheck(
                        userDto.name(),
                        user.name(),
                        () -> new UserName(userDto.name())
                ),
                userUpdateFieldNullValueCheck(
                        userDto.lastname(),
                        user.lastname(),
                        () -> new UserLastname(userDto.lastname())
                ),
                userUpdateFieldNullValueCheck(
                        userDto.dateBirth(),
                        user.dateBirth(),
                        () -> new UserDateBirth(userDto.dateBirth())
                ),
                userUpdateFieldNullValueCheck(
                        userDto.address(),
                        user.address(),
                        () -> new UserAddress(userDto.address())
                ),
                userUpdateFieldNullValueCheck(
                        userDto.phoneNumber(),
                        user.phoneNumber(),
                        () -> new UserPhoneNumber(userDto.phoneNumber())
                ),
                userUpdateFieldNullValueCheck(
                        userDto.email(),
                        user.email(),
                        () -> new UserEmail(userDto.email())
                ),
                userUpdateFieldNullValueCheck(
                        userDto.salary(),
                        user.salary(),
                        () -> new UserSalary(userDto.salary())
                ),
                role
        );
    }

    private <T extends UserField<K>, K> T userUpdateFieldNullValueCheck(K value, T userCurrentFieldValue, Supplier<T> newFieldInstance) {
        return value != null ? newFieldInstance.get() : userCurrentFieldValue;
    }
}
