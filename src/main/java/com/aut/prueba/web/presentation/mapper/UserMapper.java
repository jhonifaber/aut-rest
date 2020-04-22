package com.aut.prueba.web.presentation.mapper;

import com.aut.prueba.model.User;
import com.aut.prueba.web.presentation.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User convertToUser(UserDto userDto);

    UserDto convertToUserDto(User user);
}
