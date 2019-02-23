package com.xuecheng.manage_cms.service.impl;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsPageServiceImpl implements CmsPageService {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Override
    public ResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {

        if(page <= 0){
            page = 1;
        }
        page = page -1;

        if(size <= 0){
            size = 20;
        }

        //创建条件匹配器
        //ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        ExampleMatcher matching = ExampleMatcher.matching();
        CmsPage cmsPage = new CmsPage();
        Example<CmsPage> example = Example.of(cmsPage,matching);

        //创建pageable对象

        Pageable pageable = new PageRequest(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        List<CmsPage> content = all.getContent();
        long totalElements = all.getTotalElements();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(content);
        queryResult.setTotal(totalElements);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
