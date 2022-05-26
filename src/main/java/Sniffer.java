import org.pcap4j.core.*;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.Packet;
import org.pcap4j.util.NifSelector;

import java.io.EOFException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

public class Sniffer {

    public static void main(String[] args) throws UnknownHostException, PcapNativeException, NotOpenException, EOFException, TimeoutException {


        // trying out some shitty code, probably not the best way to do this but it works it works
        // IT DOESN'T LMAO GO BACK TO GOOGLE
        InetAddress addr = InetAddress.getByName("192.168.10.100");
        PcapNetworkInterface nif = Pcaps.getDevByAddress(addr);

        PcapNetworkInterface device = null;
        System.out.println("Sniffing on " + device.getName() + "...");

        int snapLen = 65536;
        PcapNetworkInterface.PromiscuousMode mode = PcapNetworkInterface.PromiscuousMode.PROMISCUOUS;
        int timeout = 10;
        PcapHandle handle = nif.openLive(snapLen, mode, timeout);
        Packet packet = handle.getNextPacketEx();
        handle.close();

        System.out.println("Packet: " + packet);

        IpV4Packet ipV4Packet = packet.get(IpV4Packet.class);
        Inet4Address srcAddr = ipV4Packet.getHeader().getSrcAddr();
        System.out.println(srcAddr);

    }
}
