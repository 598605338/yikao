package com.linjia.web.thirdService.eleme.interfaces.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linjia.web.thirdService.eleme.annotation.Service;
import com.linjia.web.thirdService.eleme.interfaces.entity.message.OMessage;
import com.linjia.web.thirdService.eleme.interfaces.exception.ServiceException;
import com.linjia.web.thirdService.eleme.oauth.Token;

@Service("eleme.message")
public class MessageService extends NopService {
    public MessageService(Token token) {
        super(token, MessageService.class);
    }

    public List<OMessage> getNonReachedOMessages(Integer appId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("appId", appId);
        return call(params);
    }

    public List<String> getNonReachedMessages(Integer appId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("appId", appId);
        return call(params);
    }
}
