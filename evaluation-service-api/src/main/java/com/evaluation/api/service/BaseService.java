package com.evaluation.api.service;

import com.evaluation.util.PagedGridResult;
import com.evaluation.util.RedisOperator;
import com.github.pagehelper.PageInfo;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 小亮
 **/
public class BaseService {

    @Autowired
    protected Sid sid;

    @Autowired
    protected RedisOperator redisOperator;

    public PagedGridResult setterPagedGrid(List<?> list,
                                           Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult gridResult = new PagedGridResult();
        gridResult.setRows(list);
        gridResult.setPage(page);
        gridResult.setRecords(pageList.getTotal());
        gridResult.setTotal(pageList.getPages());
        return gridResult;
    }
}
