package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GongxiangdancheDao;
import com.entity.GongxiangdancheEntity;
import com.service.GongxiangdancheService;
import com.entity.vo.GongxiangdancheVO;
import com.entity.view.GongxiangdancheView;

@Service("gongxiangdancheService")
public class GongxiangdancheServiceImpl extends ServiceImpl<GongxiangdancheDao, GongxiangdancheEntity> implements GongxiangdancheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongxiangdancheEntity> page = this.selectPage(
                new Query<GongxiangdancheEntity>(params).getPage(),
                new EntityWrapper<GongxiangdancheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongxiangdancheEntity> wrapper) {
		  Page<GongxiangdancheView> page =new Query<GongxiangdancheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongxiangdancheVO> selectListVO(Wrapper<GongxiangdancheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongxiangdancheVO selectVO(Wrapper<GongxiangdancheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongxiangdancheView> selectListView(Wrapper<GongxiangdancheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongxiangdancheView selectView(Wrapper<GongxiangdancheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GongxiangdancheEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GongxiangdancheEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GongxiangdancheEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
