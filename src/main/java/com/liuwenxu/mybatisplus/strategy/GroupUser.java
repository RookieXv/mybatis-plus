package com.liuwenxu.mybatisplus.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <GroupUser>
 *
 * @author Vinsh Liu
 * @since 2021.03.25 周四
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class GroupUser implements Serializable {
    private static final long serialVersionUID = -3124243822960299108L;

    private String username;

    private String email;
}
