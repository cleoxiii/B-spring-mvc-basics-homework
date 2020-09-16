package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;

    @NotNull(message = "用户名不为空")
    @Pattern(regexp = "^\\w{3,10}$", message = "用户名不合法")
    private String username;

    @NotNull(message = "密码是不为空")
    @Length(min = 5, max = 12, message = "密码不合法")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;
}
