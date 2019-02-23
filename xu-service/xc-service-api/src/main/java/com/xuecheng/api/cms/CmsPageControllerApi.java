package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CmsPageControllerApi {

     final String API_PRE = "/cms/page";
    /**
     * 分页查询所有cms内容
     */
    @GetMapping(API_PRE+"/list/{page}/{size}")
    public ResponseResult findAll(@PathVariable("page")int page, @PathVariable("size")int size, QueryPageRequest queryPageRequest);
}
