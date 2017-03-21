package com.linjia.web.thirdService.eleme.interfaces.service;

import com.linjia.web.thirdService.eleme.annotation.Service;
import com.linjia.web.thirdService.eleme.interfaces.entity.user.OUser;
import com.linjia.web.thirdService.eleme.interfaces.exception.ServiceException;
import com.linjia.web.thirdService.eleme.oauth.Token;

import java.util.HashMap;
import java.util.Map;

@Service("eleme.user")
public class UserService extends NopService {

    public UserService(Token token) {
        super(token, UserService.class);
    }

    public OUser getUser() throws ServiceException {
        Map<String, Object> params = new HashMap();
        return call(params);
    }
}
