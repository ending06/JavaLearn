package com.java.thread.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/2<p>
// -------------------------------------------------------
public class Piped {
    public static void main(String[] args) throws Exception {

        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);

        Thread printThread = new Thread(new Print(in), "");
        printThread.start();

        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                System.out.printf("out write\n");
                out.write(receive);
            }
        } finally {
            out.close();

        }

    }

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 17/9/2<p>
    // -------------------------------------------------------
    private static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            try {
                int receive = 0;
                while ((receive = in.read()) != -1) {
                    System.out.print((char)receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
