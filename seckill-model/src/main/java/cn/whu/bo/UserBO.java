package cn.whu.bo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author snow
 * @className UserBO
 * @date 2021/6/30
 **/
public class UserBO {
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @NotNull(message = "性别不能为空")
    private Integer sex;

    @NotBlank(message = "email不能为空")
    @Email
    private String email;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
