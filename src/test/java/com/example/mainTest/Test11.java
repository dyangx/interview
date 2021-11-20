package com.example.mainTest;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 功能描述:
 *
 * @Author: yang jie
 * @Date: 2021/9/1 10:21
 */
public class Test11 {

    public static void main(String[] args) throws UnknownHostException {

        System.out.println(InetAddress.getLocalHost().getHostAddress().toString());
        System.out.println(getAddress().getHostAddress());
    }


    private static InetAddress getAddress() {
        try {
            for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                if (addresses.hasMoreElements()) {
                    return addresses.nextElement();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }
}
