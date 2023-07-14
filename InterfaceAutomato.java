package algoritmoGenerico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InterfaceAutomato implements ActionListener {

    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    public InterfaceAutomato() {
        // Criação dos componentes
        inputTextArea = new JTextArea(10, 40);
        outputTextArea = new JTextArea(10, 40);
        JButton button1 = new JButton("Limpar");
        JButton button2 = new JButton("Analisar");
        button1.addActionListener(this);
        button2.addActionListener(this);
        
        // Criação dos painéis
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputTextArea, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(outputTextArea, BorderLayout.CENTER);

        JFrame frame = new JFrame("M2 Automatos Finitos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().add(outputPanel, BorderLayout.SOUTH);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    	// ação que vai realizar quando clicar no botão LIMPAR
        if (e.getActionCommand().equals("Limpar")) {
        	inputTextArea.setText("");
        	outputTextArea.setText("");
        // ação que vai realizar quando clicar no botão ANALISAR
        } else if (e.getActionCommand().equals("Analisar")) {
        	final int ERRO = 10;
        	int[] estadosFinais = {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0};
        	int[][] tabelaTransicaoAF = {
        		// 		  a, b, c, d, e
        		/* e0 */ {1,ERRO,6,4,ERRO,ERRO},
        		/* e1 */ {ERRO,2,ERRO,ERRO,ERRO,ERRO},
        		/* e2 */ {3,ERRO,ERRO,ERRO,ERRO,ERRO},
        		/* e3 */ {ERRO,0,ERRO,ERRO,ERRO,ERRO},
        		/* e4 */ {ERRO,ERRO,ERRO,ERRO,5,ERRO},
        		/* e5 */ {ERRO,ERRO,ERRO,7,ERRO,ERRO},
        		/* e6 */ {ERRO,ERRO,9,7,ERRO,ERRO},
        		/* e7 */ {ERRO,ERRO,ERRO,ERRO,8,ERRO},
        		/* e8 */ {ERRO,ERRO,ERRO,4,ERRO,ERRO},
        		/* e9 */ {ERRO,ERRO,6,4,ERRO,ERRO},
        		{ ERRO, ERRO, ERRO, ERRO, ERRO, ERRO }
        	};
        	
        	String entrada = inputTextArea.getText(); //pega o texto do textBox
        	AlgoritmoGenerico ag = new AlgoritmoGenerico(estadosFinais, tabelaTransicaoAF); //instancia a classe do algoritmo genérico
        	String saida = ag.reconhecer(entrada); //manda executar de acordo com a entrada
            outputTextArea.setText(saida); // saída já formatada
        }
    }

}
