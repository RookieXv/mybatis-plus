package com.liuwenxu.test_case.lombok_newobj;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <User>
 *
 * @author Vinsh Liu
 * @since 2021.03.24 周三
 */
@Data
@Accessors(chain = true)
public class User2 {
    private String name;
    private String addr;
}
