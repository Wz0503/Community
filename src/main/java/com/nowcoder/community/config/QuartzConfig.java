package com.nowcoder.community.config;

import com.nowcoder.community.quartz.AlphaJob;
import com.nowcoder.community.quartz.PostScoreRefreshJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @author wz
 * @date 2020/4/29 11:06
 */
// 配置 -> 数据库 -> 调用
@Configuration
public class QuartzConfig {

    // FactoryBean可简化Bean的实例化过程
    // 1、通过FactoryBean封装Bean的实例化过程
    // 2、将FactoryBean装配到Spring容器里
    // 3、将FactoryBean注入给其他的Bean
    // 4、该Bean得到的是FactoryBean所管理的对象实例

    // 配置JobDetail
    @Bean
    public JobDetailFactoryBean alphaJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(AlphaJob.class);
        factoryBean.setName("alphaJob");
        factoryBean.setGroup("alphaJobGroup");
        // 任务长久保持
        factoryBean.setDurability(true);
        // 任务是否可回复
        factoryBean.setRequestsRecovery(true);
        return factoryBean;
    }

    // 配置Trigger(SimpleTriggerFactoryBean, CronTriggerFactoryBean)
    @Bean
    public SimpleTriggerFactoryBean alphaTrigger(JobDetail alphaJobDetail){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(alphaJobDetail);

        factoryBean.setName("alphaTrigger");
        factoryBean.setGroup("alphaTriggerGroup");
        factoryBean.setRepeatInterval(3000);
        factoryBean.setJobDataMap(new JobDataMap());

        return factoryBean;
    }

    // 刷新帖子分数任务
    @Bean
    public JobDetailFactoryBean postScoreRefreshJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(PostScoreRefreshJob.class);
        factoryBean.setName("postScoreRefreshJob");
        factoryBean.setGroup("communityJobGroup");
        // 任务长久保持
        factoryBean.setDurability(true);
        // 任务是否可回复
        factoryBean.setRequestsRecovery(true);
        return factoryBean;
    }

    // 配置Trigger(SimpleTriggerFactoryBean, CronTriggerFactoryBean)
    @Bean
    public SimpleTriggerFactoryBean postScoreRefreshTrigger(JobDetail postScoreRefreshJobDetail){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(postScoreRefreshJobDetail);

        factoryBean.setName("postScoreRefreshTrigger");
        factoryBean.setGroup("communityTriggerGroup");
        factoryBean.setRepeatInterval(1000*60*3);
        factoryBean.setJobDataMap(new JobDataMap());

        return factoryBean;
    }
}
