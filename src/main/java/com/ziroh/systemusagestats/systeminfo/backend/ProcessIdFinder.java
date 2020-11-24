package com.ziroh.systemusagestats.systeminfo.backend;

import org.springframework.boot.system.ApplicationPid;

public class ProcessIdFinder {

    public static int getProcessID() {

        return Integer.parseInt(new ApplicationPid().toString());

    }
}
