import java.util.*;
import java.io.*;
import java.util.regex.*;
public class Minmax
{
   public static void main(String args[]) throws Exception
   {
      List<Integer> l=new ArrayList();
      Scanner sc=new Scanner(new File("/home/shubham/Documents/Data/Normalization/min_data.csv"));
      
      while(sc.hasNext())
      {  
         String s=sc.next();
         if(Pattern.matches("[^A-Za-z]*",s))
         l.add(Integer.parseInt(s));
      }
      float min=(float)Collections.min(l);
      float max=(float)Collections.max(l);
      float newmin=0;
      float newmax=1;
      float f=(newmax-newmin);
      List l2=new ArrayList();
      for(int i=0;i<l.size();i++)
      {
           float m=(((int)l.get(i)-min)/(max-min))*f+newmin;
           l2.add(m);
      
      }
    System.out.println(l);
    System.out.println("Min max Normalization"+l2);
     int sum1=l.stream().filter(i->i>5).mapToInt(i->i).sum();
     int mean=sum1/l.size();
     float sum2=0;
     for(int i=0;i<l.size();i++)
     {
         sum2+=(float)Math.pow((int)l.get(i)-mean,2);
     
     }
     sum2=sum2/l.size();
     float sd=(float)Math.sqrt(sum2);
     List l3=new ArrayList();
     for(int i=0;i<l.size();i++)
     {
          float gd=(float)((int)l.get(i)-mean)/sd;
          l3.add(gd);
          
     }
     System.out.println("Zero Normalization:"+l3);
   
   }
 

}
