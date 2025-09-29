package org.example.localmate;

import javax.swing.*;

public class LocalMateApp {
    public static void main(String[] args) {
        try {
            LocalMateServer.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Failed to start LocalMate backend (Ollama).",
                    "Startup Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingUtilities.invokeLater(LocalMateWindow::new);
    }
}
