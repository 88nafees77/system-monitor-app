package com.ziroh.systemusagestats.systeminfo;

public interface SystemServices {

    public long getTotalCPU();

    public double getCPUUsage();

    public long getMemoryUsage();

    public long getTotalMemory();

    public double getBatteryUsage();

    public long getMemoryUsageInApp();

    public double getCPUUsageInApp() throws InterruptedException;

}
