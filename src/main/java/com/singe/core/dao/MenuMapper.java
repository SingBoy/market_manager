package com.singe.core.dao;

import com.singe.core.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    public Integer selectCount(Menu queryBean);

    public List<Menu> selectList(Menu queryBean);

    int insertSelective(Menu menu);

    int updateByPrimaryKeySelective(Menu menu);

    Menu selectByPrimaryKey(Integer id);

    public List<Menu> selectNoPageList(@Param("parentId") Integer parentId);
}