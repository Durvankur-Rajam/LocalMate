package org.example.localmate;

import java.io.IOException;

public class LocalMateServer {
    public static void start() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("ollama", "run", "llama3");
        pb.inheritIO();
        pb.start();
        try {
            Thread.sleep(3000); // Give time to start
        } catch (InterruptedException ignored) {}
    }
}
