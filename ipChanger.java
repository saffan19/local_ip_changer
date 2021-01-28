import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Random;

public class ipChanger
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int choice,c=1,i=0,count;
        String last_byte,new_ip,cur_ip;
        String adapter_name="Wi-fi";
		String subnet_mask="255.255.255.0";
		String default_gateway="192.168.0.1";
		String dns_1="8.8.8.8";
        String dns_2="8.8.4.4";
        String command;
        while(c==1)
        {
            System.out.println("Enter your choice:\n1)View IP address\n2)Change IP address\n3)Change to random IP address\n4)Exit");
            choice=sc.nextInt();
            
            switch(choice)
            {
                case 1:
                    try
                    {
                        InetAddress IP = InetAddress.getLocalHost();
                        
                        IP = InetAddress.getLocalHost();
                        System.out.println("IP address: "+IP.getHostAddress());
                    }

                    catch(UnknownHostException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Enter the last byte of the IP address(Assuming subnet mask 255.255.255.0)");
                    last_byte=sc.next();
                    new_ip=null;
                    try
                    {
                        InetAddress IP = InetAddress.getLocalHost();
                        cur_ip=IP.getHostAddress();
                        String a[]=cur_ip.split("\\.");
                        new_ip=a[0]+"."+a[1]+"."+a[2]+"."+last_byte;
                        command="netsh int ip set address "+adapter_name+" static "+new_ip+" "+subnet_mask+" "+default_gateway;
                        Runtime runtimeObj=Runtime.getRuntime();
                        Process p=runtimeObj.exec(command);
                        Thread.sleep(5000);
                        System.out.println("IP address changed successfully!\n--------------------------------");
                        

                        
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    catch(UnknownHostException e)
                    {
                        e.printStackTrace();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                Random rand = new Random();                
                int randomNum = rand.nextInt(255) + 1;
                try
                {
                    InetAddress IP = InetAddress.getLocalHost();
                    cur_ip=IP.getHostAddress();
                    String a[]=cur_ip.split("\\.");
                    new_ip=a[0]+"."+a[1]+"."+a[2]+"."+String.valueOf(randomNum);
                    command="netsh int ip set address "+adapter_name+" static "+new_ip+" "+subnet_mask+" "+default_gateway;
                    Runtime runtimeObj=Runtime.getRuntime();
                    Process p=runtimeObj.exec(command);
                    Thread.sleep(5000);
                    System.out.println("IP address changed successfully to random address!\n--------------------------------------------------"); 
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

                catch(UnknownHostException e)
                {
                    e.printStackTrace();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
                case 4:
                    c=0;
                    
            }
        }

    }
}