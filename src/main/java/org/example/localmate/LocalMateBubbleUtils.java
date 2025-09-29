package org.example.localmate;

import javax.swing.*;
import java.awt.*;

public class LocalMateBubbleUtils {

    public static void addMessage(JPanel chatPanel, String message, Color bgColor, int maxWidth) {
        JPanel bubble = new LocalMateRoundedPanel(bgColor);
        bubble.setLayout(new BorderLayout());
        bubble.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));

        JTextArea textArea = new JTextArea(message);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 16));

        textArea.setSize(new Dimension(maxWidth, Short.MAX_VALUE));
        textArea.setMaximumSize(new Dimension(maxWidth, Short.MAX_VALUE));

        bubble.add(textArea, BorderLayout.CENTER);

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));
        wrapper.setOpaque(false);
        wrapper.add(Box.createHorizontalGlue());
        wrapper.add(bubble);
        wrapper.add(Box.createHorizontalGlue());

        chatPanel.add(wrapper);
        chatPanel.add(Box.createVerticalStrut(8));
        chatPanel.revalidate();
        chatPanel.repaint();
    }

    public static int calculateMaxBubbleWidth(JFrame frame) {
        int availableWidth = frame.getContentPane().getWidth();
        int horizontalPadding = 80;
        int maxWidth = Math.min(600, availableWidth - horizontalPadding - 50);
        return Math.max(200, maxWidth);
    }

    public static void updateBubbleWidths(JPanel chatPanel, JFrame frame) {
        int maxBubbleWidth = calculateMaxBubbleWidth(frame);

        for (Component comp : chatPanel.getComponents()) {
            if (comp instanceof JPanel wrapper) {
                if (wrapper.getComponentCount() > 1) {
                    Component bubble = wrapper.getComponent(1);
                    if (bubble instanceof JPanel bubblePanel) {
                        for (Component c : bubblePanel.getComponents()) {
                            if (c instanceof JTextArea textArea) {
                                textArea.setSize(new Dimension(maxBubbleWidth, Short.MAX_VALUE));
                                textArea.setMaximumSize(new Dimension(maxBubbleWidth, Short.MAX_VALUE));
                                textArea.revalidate();
                            }
                        }
                        bubblePanel.revalidate();
                    }
                }
                wrapper.revalidate();
            }
        }

        chatPanel.revalidate();
        chatPanel.repaint();
    }
}
