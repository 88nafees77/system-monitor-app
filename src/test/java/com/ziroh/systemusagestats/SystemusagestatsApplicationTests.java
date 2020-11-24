package com.ziroh.systemusagestats;

import com.ziroh.systemusagestats.database.dbmanager.SystemInfoManager;
import com.ziroh.systemusagestats.database.repository.SystemRepository;
import com.ziroh.systemusagestats.model.SystemUsageStats;
import com.ziroh.systemusagestats.systeminfo.SystemInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SystemusagestatsApplicationTests {

    @Autowired
    private SystemInformation systemInformation;

    @Autowired
    private SystemInfoManager systemInfoManager;

    @Autowired
    private SystemRepository systemRepository;

    @Test
    void insertTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            SystemUsageStats systemUsageStats = new SystemUsageStats();
            systemUsageStats.setTotalCPUs(systemInformation.getTotalCPU());
            systemUsageStats.setMemoryUsage(systemInformation.getMemoryUsage());
            systemUsageStats.setTotalMemory(systemInformation.getTotalMemory());
            systemUsageStats.setCpuUsage(systemInformation.getCPUUsage());
            systemUsageStats.setBatteryUsage(systemInformation.getBatteryUsage());
            systemUsageStats.setTime(Instant.now().getEpochSecond());
            systemInfoManager.insertSystemInfo(systemUsageStats);
            Thread.sleep(1000);
        }

    }


    @Test
    void fetch() {
        Iterable<SystemUsageStats> systemUsageStats = systemInfoManager.getALLSystemInfo();
        for (SystemUsageStats systemUsageStats1 : systemUsageStats) {
            System.out.println(systemUsageStats1.getTime() + " " +
                    systemUsageStats1.getTotalCPUs() + " " + systemUsageStats1.getMemoryUsageInApp() + " " + systemUsageStats1.getCpuUsageInApp());
            ;
        }
    }

    @Test
    void deleteTest() {
        systemRepository.deleteByTime(1605764842, 1605764849);
    }

    @Test
    void process() throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            System.out.println(systemInformation.getCPUUsage());
            Thread.sleep(3000);
        }
    }

    @Test
    void executorServiceTest() throws InterruptedException {


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("hi Test");
        };
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);


    }

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 5; i++) {
            Runnable task = () -> {
                System.out.println("hi Test");
            };
            ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
        }

    }
}
