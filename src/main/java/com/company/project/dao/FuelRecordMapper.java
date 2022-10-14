package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.FuelRecord;
import com.company.project.model.FuelRecordDO;

import java.util.List;

public interface FuelRecordMapper extends Mapper<FuelRecord> {

    public List<FuelRecordDO> findByCreateTime(long createTimeStart, long createTimeEnd);

    public List<FuelRecordDO> findByCondition(long createTimeStart, long createTimeEnd, String workOrder, String sequenceCode);

    public List<FuelRecordDO> findByWorkOrder(String workOrder);
}