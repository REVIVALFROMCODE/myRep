class BasicTask implements Runnable {
  public void run() {
    try {
      ServerSocket ss = new ServerSocket(SystemConfig.SOCKET_SERVER_PORT);
      while (!Thread.interrupted())
        new Thread(new InboundHandler(ss.accept())).start();
      // 创建新线程来handle
      //  or, single-threaded, or a thread pool
    } catch (IOException ex) { /* ... */
    }
  }

  static class InboundHandler implements Runnable {
    final Socket socket;
    InboundHandler(Socket s) {
      socket = s;
    }
    public void run() {
      try {
        byte[] input = new byte[SystemConfig.INPUT_SIZE];
        socket.getInputStream().read(input);
        byte[] output = process(input);
        socket.getOutputStream().write(output);
      } catch (IOException ex) { /* ... */
      }
    }
    private byte[] process(byte[] input) {
      byte[] output = null;
      /* ... */
      return output;
    }
  }
}
