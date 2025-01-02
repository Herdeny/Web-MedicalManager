package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.Class;
import com.github.herdeny.webmedicalmanager.pojo.Medicine;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicineMapper {
    //根据药品序号查询药品
    @Select("select * from medicine where code = #{code}")
    Medicine selectMedicineByCode(int code);

    //根据药品名查询药品
    @Select("select * from medicine where name LIKE CONCAT('%', #{name}, '%')")
    List<Medicine> selectMedicineByName(String name);

    //根据药品类型查询药品
    @Select("select * from medicine where type = #{type}")
    List<Medicine> selectMedicineByType(Class type);

    //根据药品生产厂家查询药品
    @Select("select * from medicine where producer LIKE CONCAT('%', #{producer}, '%')")
    List<Medicine> selectMedicineByProducer(String producer);

    //查询全部药品
    @Select("select * from medicine")
    List<Medicine> selectAllMedicine();

    //添加药品
    @Insert("insert into medicine(name,type,specifications,producer,batch,stock) values (#{name},#{type},#{specifications},#{producer},#{batch},#{stock})")
    void insertMedicine(Medicine medicine);

    //更新药品
    void updateMedicine(Medicine medicine);

    //删除药品
    @Delete("delete from medicine where code = #{code}")
    void deleteMedicineByCode(int code);


}
