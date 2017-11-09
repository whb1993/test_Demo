package study.unit.email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by wanghongbin on 2017/11/9 10:50.
 * 发送邮件
 */
public class emailDemo {
    public static void main(String[] args) throws Exception{
        HtmlEmail email = new HtmlEmail();
        // 这里是SMTP发送服务器的名字：，163的如下：
        email.setHostName("smtp.163.com");
        // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
        email.setAuthentication("aaa@163.com", "123456");
        // 字符编码集的设置
        email.setCharset("gbk");
        // 收件人的邮箱
        email.addTo("bbb@163.cn");
        // 发送人的邮箱
        email.setFrom("aaa@163.com", "163测试");
        // 邮件标题
        email.setSubject("helloWord");
        // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
        email.setMsg("helloWordContent<br>新的一行");
        // 发送
        email.send();
    }
}
