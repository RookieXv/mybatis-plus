package com.liuwenxu.mybatisplus.strategy.Impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.liuwenxu.mybatisplus.strategy.GroupQuery;
import com.liuwenxu.mybatisplus.strategy.GroupType;
import com.liuwenxu.mybatisplus.strategy.GroupUser;
import com.liuwenxu.mybatisplus.strategy.IGroupSelect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <TeacherGroupSelect> 教师人群
 *
 * @author Vinsh Liu
 * @since 2021.03.25 周四
 */
@Slf4j
@Service
public class TeacherGroupSelect implements IGroupSelect {
    @Override
    public GroupType type() {
        return GroupType.TEACHER;
    }

    @Override
    public void checkQueryCondition(GroupQuery groupQuery) throws IllegalArgumentException {
        log.info("groupQuery = {}", groupQuery);
    }

    @Override
    public List<GroupUser> doQuery(GroupQuery groupQuery) {
        List<GroupUser> result = new ArrayList<>();
        // TODO:
        //  1. 复杂的 TEACHER 查询逻辑
        //  2. 根据条件筛选满足条件的用户数据
        for (int i = 1; i <= 15; i++) {
            result.add(GroupUser.of("TEACHER用户" + i, i + "@t.com"));
        }
        return result;
    }
}
