package com.ziroh.systemusagestats.database.dbmanager;

import com.ziroh.systemusagestats.model.SystemUsageStats;

import java.util.List;

public interface DataBaseOperations {

    public void insertSystemInfo(SystemUsageStats systemUsageStats);

    public void deleteSystemInfo(Integer id);

    public void deleteALL();

    public void deleteByTime(long from, long to);

    public Iterable<SystemUsageStats> getALLSystemInfo();

    public List<SystemUsageStats> getSystemInfoByTime(long from, long to);


}
