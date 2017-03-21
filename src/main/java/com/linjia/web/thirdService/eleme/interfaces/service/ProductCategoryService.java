package com.linjia.web.thirdService.eleme.interfaces.service;

import com.linjia.web.thirdService.eleme.annotation.Service;
import com.linjia.web.thirdService.eleme.interfaces.entity.category.OCategory;
import com.linjia.web.thirdService.eleme.interfaces.exception.ServiceException;
import com.linjia.web.thirdService.eleme.oauth.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.product.category")
public class ProductCategoryService extends NopService {
    public ProductCategoryService(Token token) {
        super(token, ProductCategoryService.class);
    }

    public List<OCategory> getShopCategories(Long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("shopId", shopId);
        return call(params);
    }

    public OCategory getCategory(Long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("categoryId", categoryId);
        return call(params);
    }

    public OCategory createCategory(Long shopId, String name, String description) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("shopId", shopId);
        params.put("name", name);
        params.put("description", description);
        return call(params);
    }

    public OCategory updateCategory(Long categoryId, String name, String description) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("categoryId", categoryId);
        params.put("name", name);
        params.put("description", description);
        return call(params);
    }

    public void removeCategory(Long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("categoryId", categoryId);
        call(params);
    }
}
