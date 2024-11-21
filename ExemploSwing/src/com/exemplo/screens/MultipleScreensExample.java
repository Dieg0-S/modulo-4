package com.exemplo.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultipleScreensExample {
    public static void main(String[] args) {
        // Iniciar com a primeira tela
        SwingUtilities.invokeLater(() -> new Screen1());
    }
}

// Tela 1: Botões da esquerda para a direita
class Screen1 {
    public Screen1() {
        JFrame frame = new JFrame("Clique em Próximo para outra tela!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel.add(new JButton("Um"));
        panel.add(new JButton("Dois"));
        panel.add(new JButton("Três"));
        panel.add(new JButton("Quatro"));
   
	    JButton nextButton = new JButton("Próxima");
	    nextButton.addActionListener(e -> {
	        frame.dispose();
	        new Screen2();
	    });
	    panel.add(nextButton);
	
	    frame.add(panel);
	    frame.setVisible(true);
    }
}
    

// Tela 2: Botões em áreas da tela
class Screen2 {
    public Screen2() {
        JFrame frame = new JFrame("Tela 2: Áreas da Tela");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        frame.setLayout(new BorderLayout());
        frame.add(new JButton("Botão 1"), BorderLayout.NORTH);
        frame.add(new JButton("Sul"), BorderLayout.SOUTH);
        frame.add(new JButton("Botão 5"), BorderLayout.EAST);
        frame.add(new JButton("Botão 3"), BorderLayout.WEST);
        frame.add(new JButton("Botão 2"), BorderLayout.CENTER);

        JButton nextButton = new JButton("Próxima");
        nextButton.addActionListener(e -> {
            frame.dispose();
            new Screen3();
        });
        frame.add(nextButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

// Tela 3: Botões em tabela
class Screen3 {
    public Screen3() {
        JFrame frame = new JFrame("Tela 3: Tabela");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for (int i = 1; i <= 5; i++) {
            panel.add(new JButton("Botão " + i));
        }

        JButton nextButton = new JButton("Próxima");
        nextButton.addActionListener(e -> {
            frame.dispose();
            new Screen4();
        });
        panel.add(nextButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}

// Tela 4: Botões verticais ao centro
class Screen4 {
    public Screen4() {
        JFrame frame = new JFrame("Tela 4: Verticais ao Centro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;

        for (int i = 1; i <= 5; i++) {
            panel.add(new JButton("Botão " + i), gbc);
        }

        JButton finishButton = new JButton("Finalizar");
        finishButton.addActionListener(e -> frame.dispose());
        panel.add(finishButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }
}
