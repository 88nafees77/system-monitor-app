package com.ziroh.systemusagestats.systeminfo;

import com.sun.management.OperatingSystemMXBean;
import com.ziroh.systemusagestats.systeminfo.backend.ProcessIdFinder;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.lang.management.ManagementFactory;
import java.util.List;

@Component
public class SystemInformation implements SystemServices {

    private SystemInfo systemInfo = null;
    private HardwareAbstractionLayer hardwareAbstractionLayer = null;
    private long previousTime;

    public SystemInformation() {
        systemInfo = new SystemInfo();
        hardwareAbstractionLayer = systemInfo.getHardware();
    }

    @Override
    public long getTotalCPU() {
        CentralProcessor cpu = hardwareAbstractionLayer.getProcessor();
        return cpu.getLogicalProcessorCount();
    }

    @Override
    public double getCPUUsage() {
        CentralProcessor cpu = hardwareAbstractionLayer.getProcessor();
        long[] prevTicks = new long[CentralProcessor.TickType.values().length];
        double cpuLoad = cpu.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        return cpuLoad;
    }


    @Override
    public long getMemoryUsage() {
        GlobalMemory memory = hardwareAbstractionLayer.getMemory();
        return (memory.getTotal() - memory.getAvailable()) / 1024;
    }

    @Override
    public long getTotalMemory() {
        GlobalMemory memory = hardwareAbstractionLayer.getMemory();
        return memory.getTotal() / 1024;
    }

    @Override
    public double getBatteryUsage() {
        List<PowerSource> powerSource = hardwareAbstractionLayer.getPowerSources();
        return powerSource.get(0).getPowerUsageRate();
    }

    @Override
    public long getMemoryUsageInApp() {
        int pid = ProcessIdFinder.getProcessID();
        OSProcess process;
        OperatingSystem os = systemInfo.getOperatingSystem();
        process = os.getProcess(pid);
        return process.getResidentSetSize() / 1024;
    }

    @Override
    public double getCPUUsageInApp() {
        OperatingSystemMXBean operatingSystemMXBean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return operatingSystemMXBean.getProcessCpuLoad();
    }
}


