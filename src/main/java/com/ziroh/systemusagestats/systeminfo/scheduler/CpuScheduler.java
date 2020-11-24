package com.ziroh.systemusagestats.systeminfo.scheduler;

import com.ziroh.systemusagestats.database.dbmanager.SystemInfoManager;
import com.ziroh.systemusagestats.model.SystemUsageStats;
import com.ziroh.systemusagestats.systeminfo.SystemInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class CpuScheduler {

    @Autowired
    private SystemInformation systemInformation;

    @Autowired
    private SystemInfoManager systemInfoManager;

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        SystemUsageStats systemUsageStats = new SystemUsageStats();
        systemUsageStats.setMemoryUsageInApp(systemInformation.getMemoryUsageInApp());
        systemUsageStats.setCpuUsageInApp(systemInformation.getCPUUsageInApp());
        systemInfoManager.insertSystemInfo(systemUsageStats);
    }
}
