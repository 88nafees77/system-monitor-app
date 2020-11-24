package com.ziroh.systemusagestats.database.dbmanager;

import com.ziroh.systemusagestats.database.repository.SystemRepository;
import com.ziroh.systemusagestats.model.SystemUsageStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemInfoManager implements DataBaseOperations {

    @Autowired
    private SystemRepository systemRepository;


    @Override
    public void insertSystemInfo(SystemUsageStats systemUsageStats) {
        try {
            systemRepository.save(systemUsageStats);
        } catch (NullPointerException nullPointerException) {
            nullPointerException.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    @Override
    public void deleteSystemInfo(Integer id) {
        try {
            systemRepository.deleteById(id);
        } catch (NullPointerException nullPointerException) {
            nullPointerException.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    @Override
    public void deleteALL() {
        try {
            systemRepository.deleteAll();
        } catch (NullPointerException nullPointerException) {
            nullPointerException.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        }

    }

    @Override
    public void deleteByTime(long from, long to) {


    }

    @Override
    public Iterable<SystemUsageStats> getALLSystemInfo() {
        Iterable<SystemUsageStats> systemUsageStats = null;
        try {
            systemUsageStats = systemRepository.findAll();
        } catch (NullPointerException nullPointerException) {
            nullPointerException.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        }
        return systemUsageStats;
    }

    @Override
    public List<SystemUsageStats> getSystemInfoByTime(long from, long to) {

        List<SystemUsageStats> systemUsageStats = null;
        try {
            systemUsageStats = systemRepository.getSystemInfoBetweenTime(from, to);
        } catch (NullPointerException nullPointerException) {
            nullPointerException.getMessage();
        } catch (Exception exception) {
            exception.getMessage();
        }
        return systemUsageStats;

    }
}
