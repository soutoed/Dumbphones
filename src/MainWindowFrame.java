import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainWindowFrame extends JFrame {
	private JButton selecionaArquivo, calcular;
	private JLabel info;
	private JTextField memoriaNecessaria;
	
	
	public MainWindowFrame(){
		
		//Adicionando um handler para pedir uma confimação antes de fechar o arquivo;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitHandler();
			}
		});	
		
		setTitle("Dumbphones");
		setSize(300,300);
		
		//Centralizando a janela ao monitor
		setLocationRelativeTo(null);
		
		
		selecionaArquivo = new JButton("Selecionar Arquivo");
		selecionaArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSelecionarArquivo();
			}
		});
		getContentPane().add(selecionaArquivo, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	
	private void handleSelecionarArquivo(){
		
	}
	
	private void exitHandler(){

		int selection = JOptionPane.showConfirmDialog(this,"Tem certeza que quer sair?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if( selection == JOptionPane.YES_OPTION)
			System.exit( 0 );
	}
	
	public static void main(String args[]) 
	{
		MainWindowFrame mainFrame = new MainWindowFrame();
	}
}