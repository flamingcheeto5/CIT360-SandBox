package cit360.sandbox;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class App
	{
            
    public void count(){
    Query q = session
    .createQuery("select count(*), max(eb.Eid) , min(eb.Eid) , sum(eb.Eid) , avg(eb.Eid) from Employee eb");

    List l = q.list();

    // Object result[]= (Object[])l.get(0);
    // for(Object i:result){
    // System.out.println(result[(int)i]);
    // }

    Object result[] = (Object[]) l.get(0);

    Long res1 = (Long) result[0];
    long count = res1.longValue();

    Integer res2 = (Integer) result[1];
    long max = res2.longValue();

    Integer res3 = (Integer) result[2];
    long min = res3.longValue();

    Long res4 = (Long) result[3];
    long sum = res4.longValue();

    Double res5 = (Double) result[4];
    double avg = res4.doubleValue();
    
    System.out.println("Number of records" + count);
    System.out.println("Maximum of  records" + max);
    System.out.println("Minimum of  records" + min);
    System.out.println("Sum of  records" + sum);
    System.out.println(" Average of  records" + avg);
}
    private static class session {

        private static Query createQuery(String select_count_maxebEid__minebEid__sumebEid) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public session() {

        }
    }  
}

