package com.risingcamp.grittest.controller.admin.AdminUser.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.risingcamp.grittest.repository.user.entity.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SearchUserRequestDto {

    @NotNull(message = "pageIndex가 필요합니다.")
    @Schema(description = "페이지 수" , example = "0")
    private Integer pageIndex;
    @NotNull(message = "size가 필요합니다.")
    @Schema(description = "게시글 수" , example = "1")
    @Min(value = 1, message = "최소 게시글은 1개 이상입니다.")
    private Integer size;
    @Schema(description = "닉네임", example = "고추냉이")
    @Nullable
    private String nickname;
    @Schema(description = "아이디", example = "qwe123")
    @Nullable
    private String loginId;
    @Schema(description = "상태")
    @Nullable
    private UserStatus userStatus;
    @Schema(description = "회원 가입 일자",example = "2000-10-01 03:10:40")
    @Nullable
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

}
