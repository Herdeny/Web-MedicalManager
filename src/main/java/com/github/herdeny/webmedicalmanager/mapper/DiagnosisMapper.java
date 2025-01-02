package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.Diagnosis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DiagnosisMapper {

    //添加诊断
    void insertDiagnosis(Diagnosis diagnosis);

    //修改诊断
    void updateDiagnosis(Diagnosis diagnosis);

    //通过序号查询诊断
    @Select("select * from diagnosis where code = #{code}")
    Diagnosis selectDiagnosisByCode(int code);

    //通过医生序号查询诊断
    @Select("select * from diagnosis where doctor_code = #{doctorCode}")
    Diagnosis selectDiagnosisByDoctorCode(int doctorCode);

    //通过病人序号查询诊断
    @Select("select * from diagnosis where user_code = #{userCode}")
    Diagnosis selectDiagnosisByUserCode(int userCode);

    //通过序号删除诊断
    void deleteDiagnosisByCode(int code);

}
