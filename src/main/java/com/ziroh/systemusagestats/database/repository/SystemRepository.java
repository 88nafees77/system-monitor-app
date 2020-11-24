package com.ziroh.systemusagestats.database.repository;

import com.ziroh.systemusagestats.model.SystemUsageStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SystemRepository extends JpaRepository<SystemUsageStats, Integer> {

    @Query("select t from systemstats t where t.time between ?1 and ?2")
    List<SystemUsageStats> getSystemInfoBetweenTime(long from, long to);

    @Transactional
    @Modifying
    @Query("delete from systemstats where time between ?1 and ?2")
    void deleteByTime(long from, long to);
}
