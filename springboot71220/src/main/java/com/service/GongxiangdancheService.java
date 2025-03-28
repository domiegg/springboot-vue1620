package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongxiangdancheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongxiangdancheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongxiangdancheView;


/**
 * 共享单车
 *
 * @author 
 * @email 
 * @date 2023-04-21 22:32:52
 */
public interface GongxiangdancheService extends IService<GongxiangdancheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongxiangdancheVO> selectListVO(Wrapper<GongxiangdancheEntity> wrapper);
   	
   	GongxiangdancheVO selectVO(@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);
   	
   	List<GongxiangdancheView> selectListView(Wrapper<GongxiangdancheEntity> wrapper);
   	
   	GongxiangdancheView selectView(@Param("ew") Wrapper<GongxiangdancheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongxiangdancheEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GongxiangdancheEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GongxiangdancheEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GongxiangdancheEntity> wrapper);



}

