package io.scalecube.acpoc;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.stream.Stream;

/**
 * asd
 */
public class ScratchServer {

  public static void main(String[] args) throws Exception {
    final DatagramChannel datagramChannel = DatagramChannel.open();
    datagramChannel.socket().bind(new InetSocketAddress(8143));


    final ByteBuffer buffer = ByteBuffer.allocate(1024);
    while (true) {
      buffer.clear();
      buffer.flip();

      final InetSocketAddress address = (InetSocketAddress) datagramChannel.receive(buffer);

      final byte[] bytes = new byte[buffer.remaining()];
      buffer.get(bytes, 0, bytes.length);

      System.out.println(address + " " + address.getHostName() + " " + address.getPort());
      System.out.println(prettyHexView(bytes));
    }
  }

  private static String prettyHexView(byte[] ba) {
    StringBuilder sb = new StringBuilder();
    for (int j = 1; j < ba.length + 1 && j < 129; j++) {
      if (j % 16 == 1) {
        sb.append("\n");
        sb.append(String.format("0%d\t|\t", j / 16));
      }
      sb.append(String.format("%02X", ba[j - 1]));
      sb.append(" ");
    }
    sb.append("\n");
    return sb.toString();
  }
}
