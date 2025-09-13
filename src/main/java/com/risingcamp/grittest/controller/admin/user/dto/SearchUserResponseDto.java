package com.risingcamp.grittest.controller.admin.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.repository.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SearchUserResponseDto {
    @Schema(description = "닉네임", example = "고추냉이")
    private String nickname;
    @Schema(description = "유저아이디", example = "h2222q")
    private String loginId;
    @Schema(description = "회원 가입 일자", example = "2000-10-01 03:10:40")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public static SearchUserResponseDto from(User entity) {
        return new SearchUserResponseDto(
                entity.getNickname(),
                entity.getLoginId(),
                entity.getCreatedAt()
        );
    }
}
