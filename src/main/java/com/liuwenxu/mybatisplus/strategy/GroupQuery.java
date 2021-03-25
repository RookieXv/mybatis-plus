package com.liuwenxu.mybatisplus.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <GroupQuery>
 *
 * @author Vinsh Liu
 * @since 2021.03.25 周四
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupQuery implements Serializable {
    private static final long serialVersionUID = -2865404826367545020L;

    /**
     * TODO：这里添加各种需要查询的条件
     */
    private String condition;
}
