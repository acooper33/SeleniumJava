package actions.selenium.utils;

import java.net.InetAddress;

public class GetIPAddress {

    public static def run(def params) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String ipAddress = inetAddress.getHostAddress();
        def agentId
        switch (ipAddress) {
            case "13.0.2.30":
                agentId = "rwhq-agent-13"
            	break;
            case "13.0.2.191":
                agentId = "rwhq-agent-12"
                break;
            case "13.0.2.254":
                agentId = "rwhq-agent-11"
                break;
            case "13.0.2.222":
                agentId = "rwhq-agent-10"
                break;
            case "13.0.2.29":
                agentId = "rwhq-agent-9"
                break;
            case "13.0.2.75":
                agentId = "rwhq-agent-8"
                break;
            case "13.0.2.72":
                agentId = "rwhq-agent-7"
                break;
            case "13.0.2.197":
                agentId = "rwhq-agent-6"
                break;
            case "13.0.2.133":
                agentId = "rwhq-agent-5"
                break;
            case "13.0.2.164":
                agentId = "rwhq-agent-4"
                break;
            case "13.0.2.50":
                agentId = "rwhq-agent-3"
                break;
            case "13.0.2.210":
                agentId = "rwhq-agent-2"
                break;
            case "13.0.2.8":
                agentId = "rwhq-agent-1"
                break;
            default:
                agentId = "not able to determine"
        }
        return "This machine is ${agentId}, the IP address is: ${ipAddress}"
        //System.out.println("The IP address of the machine is: " + ipAddress);
    }
}

