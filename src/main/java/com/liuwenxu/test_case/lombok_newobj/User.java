package com.liuwenxu.test_case.lombok_newobj;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <User>
 *
 * @author Vinsh Liu
 * @since 2021.03.24 周三
 */
@Data
@Builder
//@NoArgsConstructor
public class User {
    private String name;
    private String addr;
}
