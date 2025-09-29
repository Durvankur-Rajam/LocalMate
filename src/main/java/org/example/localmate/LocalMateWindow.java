package org.example.localmate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class LocalMateWindow {

    public static void main(String[] args) {
        try {
            startOllamaServer();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Failed to start Ollama. Make sure it's installed and added to your PATH.",
                    "Ollama Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("LocalMate");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setMinimumSize(new Dimension(800, 600));
            frame.setResizable(true);

            // Colors
            Color backgroundColor = new Color(30, 30, 30);
            Color inputBgColor = new Color(70, 70, 70);
            Color userColor = new Color(52, 122, 87);
            Color botColor = new Color(60, 60, 60);
            Color textColor = Color.WHITE;

            JPanel chatPanel = new JPanel();
            chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
            chatPanel.setBackground(backgroundColor);
            chatPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

            JPanel paddedPanel = new JPanel(new BorderLayout());
            paddedPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
            paddedPanel.setBackground(backgroundColor);
            paddedPanel.add(chatPanel, BorderLayout.CENTER);

            JScrollPane scrollPane = new JScrollPane(paddedPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);

            JTextField inputField = new JTextField();
            inputField.setBackground(inputBgColor);
            inputField.setForeground(textColor);
            inputField.setCaretColor(textColor);
            inputField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            inputField.setFont(new Font("Courier New", Font.PLAIN, 16));

            JButton sendButton = new JButton("Send");
            sendButton.setBackground(new Color(70, 130, 180));
            sendButton.setForeground(textColor);

            JPanel inputPanel = new JPanel(new BorderLayout());
            inputPanel.setBackground(backgroundColor);
            inputPanel.add(inputField, BorderLayout.CENTER);
            inputPanel.add(sendButton, BorderLayout.EAST);

            frame.getContentPane().setBackground(backgroundColor);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    LocalMateBubbleUtils.updateBubbleWidths(chatPanel, frame);
                }
            });

            sendButton.addActionListener(e -> {
                String prompt = inputField.getText().trim();
                if (!prompt.isEmpty()) {
                    inputField.setText("");
                    int maxBubbleWidth = LocalMateBubbleUtils.calculateMaxBubbleWidth(frame);
                    LocalMateBubbleUtils.addMessage(chatPanel, "You: " + prompt, userColor, maxBubbleWidth);

                    JLabel typingLabel = LocalMateTypingLabel.addTypingIndicator(chatPanel);

                    new Thread(() -> {
                        String response = OllamaAPI.sendPrompt(prompt);
                        SwingUtilities.invokeLater(() -> {
                            chatPanel.remove(typingLabel);
                            LocalMateBubbleUtils.addMessage(chatPanel, "Bot: " + response, botColor, maxBubbleWidth);
                            chatPanel.revalidate();
                            chatPanel.repaint();
                        });
                    }).start();
                }
            });

            inputField.addActionListener(e -> sendButton.doClick());

            frame.setVisible(true);
        });
    }

    private static void startOllamaServer() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("ollama", "run", "llama3");
        pb.inheritIO();
        pb.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
    }
}
