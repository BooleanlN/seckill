package cn.whu.bo;

import javax.validation.constraints.NotBlank;

/**
 * @author snow
 * @className LoginBO
 * @date 2021/6/28
 **/
public class LoginBO {
    @NotBlank(message = "邮件不能为空")
    private String email;

    @NotBlank(message = "昵称不能为空")
    private String nickname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
