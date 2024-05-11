package com.evaluation.user.service.impl;

import com.evaluation.api.service.BaseService;
import com.evaluation.enums.UserStatus;
import com.evaluation.pojo.User;
import com.evaluation.pojo.vo.RegionRatioVO;
import com.evaluation.user.mapper.UserMapper;
import com.evaluation.user.service.UserMngService;
import com.evaluation.util.PagedGridResult;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 小亮
 **/
@Service
public class UserMngServiceImpl extends BaseService implements UserMngService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PagedGridResult queryAllUserList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> list = userMapper.selectAll();
        return setterPagedGrid(list, page);
    }

    @Override
    public PagedGridResult queryAllUserList(User user, Integer page, Integer pageSize) {
        Example userExample = new Example(User.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        String mail = user.getMail();
        String id = user.getId();
        String phoneNum = user.getPhoneNum();
        String job = user.getJob();
        Date birthday = user.getBirthday();
        String province = user.getProvince();
        String city = user.getCity();
        String district = user.getDistrict();
        Integer sex = user.getSex();
        Integer status = user.getStatus();
        if (StringUtils.isNotBlank(mail)) {
            userCriteria.andEqualTo("mail", mail);
        }
        if (StringUtils.isNotBlank(id)) {
            userCriteria.andEqualTo("id", id);
        }
        if (StringUtils.isNotBlank(phoneNum)) {
            userCriteria.andEqualTo("phoneNum", phoneNum);
        }
        if (birthday != null) {
            userCriteria.andEqualTo("birthday", birthday);
        }
        if (StringUtils.isNotBlank(job)) {
            userCriteria.andEqualTo("job", job);
        }
        if (StringUtils.isNotBlank(province)) {
            userCriteria.andEqualTo("province", province);
        }
        if (StringUtils.isNotBlank(city)) {
            userCriteria.andEqualTo("city", city);
        }
        if (StringUtils.isNotBlank(district)) {
            userCriteria.andEqualTo("district", district);
        }
        if (sex != null) {
            userCriteria.andEqualTo("sex", sex);
        }
        if (status != null) {
            userCriteria.andEqualTo("status", status);
        }
        PageHelper.startPage(page, pageSize);
        List<User> users = userMapper.selectByExample(userExample);
        return setterPagedGrid(users, page);
    }

    @Override
    public void freezeUserOrNot(String id, Integer status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer getUserCount(User user) {
        return userMapper.selectCount(user);
    }

    public static final String[] regions = {"北京市", "天津市", "上海市", "重庆市",
            "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省",
            "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省", "云南省", "陕西省", "甘肃省", "青海省", "台湾省",
            "内蒙古自治区", "广西壮族自治区", "西藏自治区", "宁夏回族自治区", "新疆维吾尔自治区",
            "香港特别行政区", "澳门特别行政区"};

    @Override
    public List<RegionRatioVO> getRegionRatio() {
        List<RegionRatioVO> result = new ArrayList<RegionRatioVO>();
        User user = new User();
        for (String r : regions) {
            RegionRatioVO regionRatioVO = new RegionRatioVO();
            regionRatioVO.setName(r);
            user.setProvince(r);
            Integer count = userMapper.selectCount(user);
            regionRatioVO.setValue(count);
            result.add(regionRatioVO);
        }
        return result;
    }

}
