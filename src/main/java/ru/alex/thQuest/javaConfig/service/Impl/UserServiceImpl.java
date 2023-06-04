package ru.alex.thQuest.javaConfig.service.Impl;

import org.springframework.stereotype.Component;
import ru.alex.thQuest.dto.UserDto;
import ru.alex.thQuest.javaConfig.service.UserService;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public UserDto createUser(UserDto userDto) {
        return new UserDto(userDto.getName(), userDto.getPassword());
    }
}
