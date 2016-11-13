package support.util;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wxp on 2016-04-07.
 */
public class RandomUtils {

  public static  Integer getRandomByRange(int min,int  max)
  {

      Random random=new Random();
      return random.nextInt(max+1-min)+min;
  }

    public static List getRandomQueue(int min, int length)
    {
        List <Integer>queue=new ArrayList<>();
        for(int i=0;i<length;i++){
            queue.add(i+min);
        }
        int temp=0;
        for(int i=0;i<length-1;i++){
            int t=getRandomByRange(i+1,length-1);
            temp=queue.get(t);
            queue.set(t,queue.get(i).intValue());
            queue.set(i,temp);

        }
        return queue;
    }

    public static void main(String []args)
    {
       List queue=getRandomQueue(1,100);
        String q= new Gson().toJson(queue);

    }


}
