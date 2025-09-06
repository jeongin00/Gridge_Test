package com.risingcamp.grittest.controller.user.dto;



import com.risingcamp.grittest.repository.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponseDto {
    private String phone;
    private String name;

    public static UserResponseDto from (User entity){
        return new UserResponseDto(
                entity.getPhone(),
                entity.getName()
        );
    }
}
