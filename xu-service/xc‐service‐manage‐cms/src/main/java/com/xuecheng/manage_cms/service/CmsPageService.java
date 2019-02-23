package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.ResponseResult;

public interface CmsPageService {

    ResponseResult findList(int page,int size,QueryPageRequest queryPageRequest);
}
