package com.risingcamp.grittest.repository.admin.user.entity;

import com.risingcamp.grittest.repository.user.entity.UserStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nickname;
    private UserStatus beforeStatus;
    private UserStatus afterStatus;
    private String reason;
    private String adminLoginId; // 조치한 관리자id
    private LocalDateTime createdAt;

    public static UserHistory create(String nickname, UserStatus beforeStatus,
                                     UserStatus afterStatus, String reason, String adminLoginId){
        return new UserHistory(
                null,
                nickname,
                beforeStatus,
                afterStatus,
                reason,
                adminLoginId,
                LocalDateTime.now()
        );
    }
}
