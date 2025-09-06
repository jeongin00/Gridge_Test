package com.risingcamp.grittest.security.vo;


import com.risingcamp.grittest.repository.user.entity.vo.Source;

import java.util.Map;

public interface OAuth2Resource {
    Source getProvider();
    Long getProviderId();
    Map<String, Object> getAttributes();
    Map<String, Object> getAccount();
    Map<String, Object> getProfile();
    String getEmail();
}