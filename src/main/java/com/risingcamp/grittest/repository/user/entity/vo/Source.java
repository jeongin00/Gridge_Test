package com.risingcamp.grittest.repository.user.entity.vo;

import java.util.Arrays;

public enum Source {
    HOMEPAGE,
    KAKAO;

    public static Source findByName(String name) {
        return Arrays.stream(Source.values())
                .filter((each) -> each.name().equals(name.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Source 검색 : " + name.toUpperCase()));
    }
}

