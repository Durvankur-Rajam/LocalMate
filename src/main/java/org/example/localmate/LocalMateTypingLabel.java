package org.example.localmate;

import javax.swing.*;
import java.awt.*;

public class LocalMateTypingLabel {

    public static JLabel addTypingIndicator(JPanel chatPanel) {
        JLabel typingLabel = new JLabel("Bot is typing...");
        typingLabel.setForeground(Color.LIGHT_GRAY);
        typingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        typingLabel.setFont(new Font("Courier New", Font.ITALIC, 16));
        chatPanel.add(typingLabel);
        chatPanel.revalidate();
        chatPanel.repaint();
        return typingLabel;
    }
}
