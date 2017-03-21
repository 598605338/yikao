package com.linjia.web.thirdService.eleme.interfaces.service;

import com.linjia.web.thirdService.eleme.annotation.Service;
import com.linjia.web.thirdService.eleme.interfaces.exception.ServiceException;
import com.linjia.web.thirdService.eleme.oauth.Token;

import java.util.HashMap;
import java.util.Map;

@Service("eleme.file")
public class UploadService extends NopService {

    public UploadService(Token token) {
        super(token, UploadService.class);
    }

    public String uploadImage(String image) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("image", image);
        return call(params);
    }

    public String uploadImageWithRemoteUrl(String url) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("url", url);
        return call(params);
    }

    public String getUploadedUrl(String hash) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("hash", hash);
        return call(params);
    }
}
