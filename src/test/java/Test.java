import com.example.springBean.People;
import org.apache.poi.hpsf.Decimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Random;

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

    @org.junit.Test
    public void test2(){
        BigDecimal decimal = new BigDecimal("7");
        decimal.toString();
        System.out.println(decimal);

        ApplicationContext applicationContext = null;
//        applicationContext.getBean()

    }

    @org.junit.Test
    public void test3(){
        int[] arr = {1,4,3,5,7,8};

        for(int i=0;i<arr.length;i++){
            int a = arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == 10){
                    System.out.println(i);
                    System.out.println(j);
                    break;
                }
            }
        }
    }

    @org.junit.Test
    public void test4(){
        String s = "abcabcbb";
        int max = 0;
        int a = 0;
        int b = 1;
        while (a< s.length() && b<s.length()){
//            if(a.size() == 1)
        }
    }
}
