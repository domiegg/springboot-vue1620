package com.dao;

import com.entity.GongxiangdancheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongxiangdancheVO;
import com.entity.view.GongxiangdancheView;


/**
 * 共享单车
 * 
 * @author 
 * @email 
 * @date 2023-04-21 22:32:52
 */
public interface GongxiangdancheDao extends BaseMapper<GongxiangdancheEntity> {
	
	List<GongxiangdancheVO> selectListVO(@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);
	
	GongxiangdancheVO selectVO(@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);
	
	List<GongxiangdancheView> selectListView(@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);

	List<GongxiangdancheView> selectListView(Pagination page,@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);
	
	GongxiangdancheView selectView(@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);



}
