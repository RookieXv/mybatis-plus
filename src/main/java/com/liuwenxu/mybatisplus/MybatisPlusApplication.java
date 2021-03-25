package com.liuwenxu.mybatisplus;

import com.liuwenxu.mybatisplus.strategy.GroupQuery;
import com.liuwenxu.mybatisplus.strategy.GroupSelectFactory;
import com.liuwenxu.mybatisplus.strategy.GroupType;
import com.liuwenxu.mybatisplus.strategy.GroupUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("com.liuwenxu.mybatisplus.**.mapper")
@EnableTransactionManagement
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

    @Autowired
    private GroupSelectFactory groupSelectFactory;

    /**
     * 模拟定时发送营销邮件
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void sendEmailTask() {
        List<SendEmailTask> taskList = new ArrayList<>();
        for (GroupType groupType : GroupType.values()) {
            GroupQuery groupQuery = new GroupQuery("虚头巴脑的 " + groupType.name() + " 查询条件");
            taskList.add(SendEmailTask.of(groupType, groupQuery));
        }

        taskList.forEach(task -> {
            List<GroupUser> groupUsers = groupSelectFactory.getGroupSelect(task.getType()).queryUser(task.getQuery());
            log.info("groupUsers = {}", groupUsers);
        });

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    static class SendEmailTask implements Serializable {
        private static final long serialVersionUID = -3461263089669779193L;
        private GroupType type;
        private GroupQuery query;
    }
}
