import java.time.ZonedDateTime;

public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();//默认时区
        System.out.println(zonedDateTime);
        //2021-03-20T14:09:02.786+08:00[Asia/Shanghai]
    }
}
