package cn.whu.bo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author snow
 * @className UpdateUserInfoBO
 * @date 2021/6/27
 **/
public class UpdateUserInfoBO {
    @NotBlank(message="用户ID不能为空")
    private String userId;

    @NotBlank(message="用户昵称不能为空")
    @Length(max = 24, message = "用户昵称不能超过24位")
    private String nickname;

    @NotNull(message = "请选择一个性别")
    @Min(value = 0, message = "性别选择不正确")
    @Max(value = 1, message = "性别选择不正确")
    private Integer sex;

    @Email
    @NotBlank(message="用户邮件地址不能为空")
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
