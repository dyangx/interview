import com.example.springBean.People;
import com.sun.istack.internal.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class Test {

    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");

//        @Service
        String s;

        ApplicationContext factory = new ClassPathXmlApplicationContext("bean/bean.xml");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        People person = factory.getBean("person",People.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
