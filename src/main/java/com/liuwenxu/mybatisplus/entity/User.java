package com.liuwenxu.mybatisplus.entity;

import com.liuwenxu.mybatisplus.annotation.Phone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {

      @NotBlank(message = "用户名不能为空")
      private String username;

      @Phone
      private String phone;

      @NotEmpty(message = "密码不为空")
      private String password;

      public String getUsername() {
            return username;
      }

      public void setUsername(String username) {
            this.username = username;
      }

      public String getPhone() {
            return phone;
      }

      public void setPhone(String phone) {
            this.phone = phone;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }
}
