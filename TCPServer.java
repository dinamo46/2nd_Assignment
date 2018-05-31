
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.net.*;


class TCPServer 
{

private String hostname;
private String ip;
private String port;
private String TTL;
private String time;


public String getHostname()
{ 
return hostname;
}

public String getServerIP()
{ 
return ip;
}

public String getServerPort()
{ 
return port;
}

public String getServerTTL()
{ 
return TTL;
}

public String getServerTime()
{ 
return time;
}

public static void main(String argv[]) throws Exception 
{

String clientSentence;
String hostname;
String capitalizedSentence;
String sendBack;
InetAddress ip;
String hostIP;
String hostIPv6;
String port;

	System.out.println("Waiting for connection... ");

ServerSocket welcomeSocket = new ServerSocket(47974); port = "47974";

while (true) 
{


Socket connectionSocket = welcomeSocket.accept();

BufferedReader inFromClient = 
 new BufferedReader (new InputStreamReader 
(connectionSocket.getInputStream()));

DataOutputStream outToClient = new 
DataOutputStream(connectionSocket.getOutputStream());


ip = InetAddress.getLocalHost();

hostname = ip.getHostName();
hostIP = ip.getHostAddress();


clientSentence = inFromClient.readLine();
System.out.println("Client's question : " + clientSentence);


if (clientSentence.equalsIgnoreCase("show hostname"))
	{
	sendBack = hostname;
	}

else if (clientSentence.equalsIgnoreCase("show ipv4"))
	{
	sendBack = hostIP;
	}

else if (clientSentence.equalsIgnoreCase("show ipv6"))
	{
	sendBack = hostIPv6;
	}

else if (clientSentence.equalsIgnoreCase("show port"))
	{
	sendBack = port;
	}

else if (clientSentence.equalsIgnoreCase("show TTL"))
	{
	sendBack = "null";
	}
	
else if (clientSentence.equalsIgnoreCase("show time"))
	{
	outToClient.writeBytes("" + new Date());
	sendBack = "";
	}

else
	{
	sendBack = "Invalid Question!";
	}

capitalizedSentence = sendBack + "\n";
outToClient.writeBytes(capitalizedSentence);
}

}
}

