import java.io.*;
import java.util.*;
public class GetKeyPaidCombination {
    public static void main(String[]args)throws Exception{
        Scanner s=new Scanner(System.in);
        String str=s.next();
        ArrayList<String>result=getkpc(str);
        System.out.println(result);
    }
    static String[]codes={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String>getkpc(String str){
        if(str.length()==0)
        {
            ArrayList<String>baseresult=new ArrayList<>();
            baseresult.add(" ");
            return baseresult;
        }
        //if we press 678 then out will be 24 words i.e {ptv,ptw,ptx,puv,puw,pux,qtv,qtw,qtx,quv,quw,qux,...}
        char ch=str.charAt(0);//6
        String restofchar=str.substring(1);//78
        ArrayList<String>recursionresult=getkpc(restofchar); //this means we are haveing faith that we should get the ans for 78 i.e
        //6 word {tu,tw,tx,uv,uw,ux}
        ArrayList<String>myresult=new ArrayList<>();
        String codeforch=codes[ch-'0'];// concept of ASCCI VALUE here we want to get codes which is present at 6 i.e pqrs here 6 is also string
        //so to get postion '6'-'0' i.e 54-48
        for(int i=0;i<codeforch.length();i++){ //line by line first p will added to recursionresult then q,r,s
            char chcode=codeforch.charAt(i);
            for(String rstr:recursionresult){ //ye loop recursionresult pr chala hai {tu,tw,tx,uv,uw,ux} pr
                myresult.add(chcode+rstr);
            }
        }
        return myresult;
    }
}
