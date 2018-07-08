package com.xjtu.iqa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjtu.iqa.po.Equipments;
import com.xjtu.iqa.po.EquipmentsExample;

public interface EquipmentsMapper {
    int deleteByPrimaryKey(Integer EQUIPMENT_ID);

    int insert(Equipments record);

    int insertSelective(Equipments record);

    List<Equipments> selectByExample(EquipmentsExample example);

    Equipments selectByPrimaryKey(Integer EQUIPMENT_ID);

    int updateByPrimaryKeySelective(Equipments record);

    int updateByPrimaryKey(Equipments record);
    
  //通过用户名及部门查找tbl_equipments表中是否已存在该设备
  	boolean isExist(@Param(value="name")String user, @Param(value="department")String department);

  	//添加用户设备
  	void addUserEquipment(@Param(value="brand")String brand, @Param(value="configure_time")String configure_time,@Param(value="department") String department, @Param(value="user")String user, @Param(value="cPU")String cPU,@Param(value="rAM") String rAM,
  			@Param(value="rOM")String rOM, @Param(value="os")String os, @Param(value="browser")String browser,@Param(value="office_software") String office_software, @Param(value="used_for")String used_for, @Param(value="iP")String iP,@Param(value="mAC") String mAC,
  			@Param(value="region")String region);

  	//获取所有用户设备信息 -- tbl_equipments表
  	List<Equipments> getAllEquipments();

  	//根据用户名和部门名获取信息
  	List<Equipments> getEquipmentsInfo(@Param(value="user")String user, @Param(value="department")String department);

  	//更改用户设备信息
  	void updateEquipment(@Param(value="equipmentId")String equipmentId, @Param(value="brand")String brand, @Param(value="cfg_time")String cfg_time, @Param(value="department")String department, @Param(value="user")String user, @Param(value="cPU")String cPU,
  			@Param(value="rAM")String rAM, @Param(value="rOM")String rOM, @Param(value="os")String os, @Param(value="browser")String browser, @Param(value="office_software")String office_software, @Param(value="used_for")String used_for, @Param(value="iP")String iP,
  			@Param(value="mAC")String mAC, @Param(value="region")String region);

  	//删除用户设备信息
  	void deleteEquipment(String equipmentId);

  	//获取地区信息
  	List<Equipments> getRegions();

  	//各地区配置数
  	int getEquipmentCountsByRegion(String region);
}