package com.ziroh.systemusagestats.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "systemstats")
public class SystemUsageStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private long totalCPUs;

    private double cpuUsage;

    private long memoryUsage;

    private long totalMemory;

    private double batteryUsage;

    private long memoryUsageInApp;

    private double cpuUsageInApp;

    private long time;

    public long getTotalCPUs() {
        return totalCPUs;
    }

    public void setTotalCPUs(long totalCPUs) {
        this.totalCPUs = totalCPUs;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public long getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(long memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public double getBatteryUsage() {
        return batteryUsage;
    }

    public void setBatteryUsage(double batteryUsage) {
        this.batteryUsage = batteryUsage;
    }

    public long getMemoryUsageInApp() {
        return memoryUsageInApp;
    }

    public void setMemoryUsageInApp(long memoryUsageInApp) {
        this.memoryUsageInApp = memoryUsageInApp;
    }

    public double getCpuUsageInApp() {
        return cpuUsageInApp;
    }

    public void setCpuUsageInApp(double cpuUsageInApp) {
        this.cpuUsageInApp = cpuUsageInApp;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
