import java.io.*;
import java.util.*;
public class corelation
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(new File("/home/shubham/Documents/Data/corelation/input.csv"));
        List<List<Integer>>l2=new ArrayList();
       double mean1=0;
        double mean2=0; 
        sc.nextLine();
        while(sc.hasNext())
        {
            String s[]=(sc.nextLine()).split("\\,");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            mean1+=a;
            mean2+=b;
            List<Integer>l=new ArrayList();
            l.add(a);
            l.add(b);
            l2.add(l);
        }
        mean1=(double)(mean1/l2.size());
        mean2=(double)(mean2/l2.size());
        double sd1=0;
        double sd2=0;
        for(int i=0;i<l2.size();i++)
        {
            int a=(int)l2.get(i).get(0);
            int b=(int)l2.get(i).get(1);
            sd1+=(double)Math.pow((a-mean1),2);
            sd2+=(double)Math.pow((b-mean2),2);
        }
        sd1=(double)(sd1/l2.size());
        sd2=(double)(sd2/l2.size());
        sd1=(double)Math.sqrt(sd1);
        sd2=(double)Math.sqrt(sd2);
        int cf=0;
        for(int i=0;i<l2.size();i++)
        {
            int a=(int)l2.get(i).get(0);
            int b=(int)l2.get(i).get(1);
            cf+=((a-mean1)*(b-mean2)); 
        }
        if(cf>0)  
        {
           System.out.println("Postive perfect realtion");
        }
        else if(cf<0)
           System.out.println("Negative perfect realtion");
        else
           System.out.println("No corelation dependence");
        
        
    
    }

}
