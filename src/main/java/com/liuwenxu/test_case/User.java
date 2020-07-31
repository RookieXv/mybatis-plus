package com.liuwenxu.test_case;

import lombok.Builder;
import lombok.Data;

//@Data
//@Builder
public class User{
    private String name;
    private Integer age;

    //2.在domain类上创建一个private的构造函数，参数为Builder类型，里边是将Builder的属性赋值给domain的属性：
    private User(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
    }

    //1.首先创建一个静态内部类Builder，并且内部类Builder拥有domain的所有属性：
    public static class Builder{
        private String name;
        private Integer age;

        //3.在Builder内部类创建domain属性的赋值方法，返回值是Builder
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        //4.在Builder内部类创建一个builde方法，返回domain实例
        public User builder() {
            return new User(this);
        }
    }
}
