package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void mongdbTest(){
        /*CmsPage one = cmsPageRepository.findOne("5ae1979f0e6618644cd7a6fd");
        System.out.println(one);*/

        //创建条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        CmsPage cmsPage = new CmsPage();
        Example<CmsPage> example = Example.of(cmsPage,exampleMatcher);

        //创建pageable对象
        int page = 0;
        int size = 10;
        Pageable pageable = new PageRequest(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        List<CmsPage> content = all.getContent();

        System.out.println(content);

    }
}
