package com.liuwenxu.mybatisplus.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <GroupSelectFactory> 人群选择工厂类
 *
 * @author Vinsh Liu
 * @since 2021.03.25 周四
 */
@Service
public class GroupSelectFactory {

    @Autowired
    private List<IGroupSelect> groupSelectList;

    /**
     * 根据人群类型选择具体的实现类
     *
     * @param type 人群类型
     * @return 具体的实现类
     */
    public IGroupSelect getGroupSelect(GroupType type) {
        Optional<IGroupSelect> groupSelect = groupSelectList.stream().filter(t -> t.type() == type).findAny();
        return groupSelect.orElseThrow(() -> new IllegalArgumentException("暂不支持该人群方式"));
    }
}
