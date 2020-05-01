package com.nowcoder.community.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author wz
 * @date 2020/4/29 11:03
 */
public class AlphaJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println(Thread.currentThread().getName() + ": execute a quartz job.");
    }
}
