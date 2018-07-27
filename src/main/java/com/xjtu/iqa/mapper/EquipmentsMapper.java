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
  	boolean isExist(@Param(value="user")String user, @Param(value="department")String department);

  	//添加用户设备
  	void addUserEquipment(String brand, String configure_time, String department, String user, String cPU, String rAM,
  			String rOM, String os, String browser, String office_software, String used_for, String iP, String mAC,
  			String region);

  	//获取所有用户设备信息 -- tbl_equipments表
  	List<Equipments> getAllEquipments();

  	//根据用户名和部门名获取信息
  	List<Equipments> getEquipmentsInfo(String user, String department);

  	//更改用户设备信息
  	void updateEquipment(String equipmentId, String brand, String cfg_time, @Param(value="department")String department, @Param(value="user")String user, @Param(value="cPU")String cPU,
  			String rAM, String rOM, String os, @Param(value="browser")String browser, @Param(value="office_software")String office_software, @Param(value="used_for")String used_for, @Param(value="iP")String iP,
  			String mAC, String region);

  	//删除用户设备信息
  	void deleteEquipment(String equipmentId);

  	//获取地区信息
  	List<Equipments> getRegions();

  	//各地区配置数
  	int getEquipmentCountsByRegion(String region);
}