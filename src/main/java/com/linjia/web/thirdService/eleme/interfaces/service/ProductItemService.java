package com.linjia.web.thirdService.eleme.interfaces.service;

import com.linjia.web.thirdService.eleme.annotation.Service;
import com.linjia.web.thirdService.eleme.interfaces.entity.item.OItem;
import com.linjia.web.thirdService.eleme.interfaces.entity.item.OItemIdWithSpecIds;
import com.linjia.web.thirdService.eleme.interfaces.enumeration.item.OItemCreateProperty;
import com.linjia.web.thirdService.eleme.interfaces.exception.ServiceException;
import com.linjia.web.thirdService.eleme.oauth.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.product.item")
public class ProductItemService extends NopService {

    public ProductItemService(Token token) {
        super(token, ProductItemService.class);
    }

    public Map<Long, OItem> getItemsByCategoryId(Long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("categoryId", categoryId);
        return call(params);
    }

    public OItem getItem(Long itemId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("itemId", itemId);
        return call(params);
    }

    public Map<Long, OItem> batchGetItems(List<Long> itemIds) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("itemIds", itemIds);
        return call(params);
    }

    public OItem createItem(Long categoryId, Map<OItemCreateProperty, Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("categoryId", categoryId);
        params.put("properties", properties);
        return call(params);
    }

    public Map<Long, OItem> batchCreateItems(Long categoryId, List<Map<OItemCreateProperty, Object>> items) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("categoryId", categoryId);
        params.put("items", items);
        return call(params);
    }

    public OItem updateItem(Long itemId, Long categoryId, Map<OItemCreateProperty, Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("itemId", itemId);
        params.put("categoryId", categoryId);
        params.put("properties", properties);
        return call(params);
    }

    public void batchFillStock(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("specIds", specIds);
        call(params);

    }

    public void batchClearStock(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("specIds", specIds);
        call(params);

    }

    public void batchOnShelf(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("specIds", specIds);
        call(params);
    }

    public void batchOffShelf(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("specIds", specIds);
        call(params);
    }

    public OItem removeItem(Long itemId) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("itemId", itemId);
        return call(params);
    }

    public Map<Long, OItem> batchRemoveItems(List<Long> itemIds) throws ServiceException {
        Map<String, Object> params = new HashMap();
        params.put("itemIds", itemIds);
        return call(params);
    }
}
