import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 小兵哥哥 on 2016/8/14 0014.
 */
public class MainC {

    public static void main(String args[]){


   /*     for(int i=0;i<1000;i++){
            int num = 1 + (int) (Math.random() * (3));
            System.out.println(num);
        }*/

       /* for(int i=0;i<1000;i++){
            int num = 1 + (int) (Math.random() * (2000/ Constants.SMALL_REDBAG_BASE_LINE)+1);
            System.out.println(num);
        }*/
        Calendar calendar=new GregorianCalendar();
        calendar.setTime(new Date());
        int hour= calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
    }
}
