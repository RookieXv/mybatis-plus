package com.liuwenxu.test_case.lombok_newobj;

/**
 * <TestDemo> 测试Builder和Accessors注解创建对象的区别
 *
 * User(name=user, addr=null)
 * User2(name=user2, addr=null)
 *
 * @author Vinsh Liu
 * @since 2021.03.24 周三
 */
public class TestDemo {
    public static void main(String[] args) {
        User user = User.builder().name("user").build();
        System.out.println(user.toString());

        User2 user2 = new User2().setName("user2");
        System.out.println(user2);
    }
}
