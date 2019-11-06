package io.scalecube.acpoc;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;


public class ScratchClient {

  public static void main(String[] args) throws Exception {
    final DatagramChannel datagramChannel = DatagramChannel.open();
    datagramChannel.connect(new InetSocketAddress("om2-savchuk", 8143));


    final ByteBuffer buffer = ByteBuffer.allocate(48);
    final Scanner scanner = new Scanner(System.in);

    while (true) {
      try {
        buffer.clear();
        buffer.putInt(scanner.nextInt());
        buffer.flip();
        try {
          datagramChannel.send(buffer, new InetSocketAddress("om2-savchuk", 8143));
//        datagramChannel.write(buffer);
        } catch (IllegalArgumentException e) {
          datagramChannel.disconnect()
              .connect(new InetSocketAddress("om2-savchuk", 8143));
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
