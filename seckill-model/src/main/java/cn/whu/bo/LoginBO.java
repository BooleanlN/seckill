package cn.whu.bo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author snow
 * @className LoginBO
 * @date 2021/6/28
 **/
public class LoginBO implements Serializable {
    @NotBlank(message = "邮件不能为空")
    private String email;

    @NotBlank(message = "昵称不能为空")
    private String nikename;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }
}
