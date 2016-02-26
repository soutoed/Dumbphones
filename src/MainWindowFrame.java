import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainWindowFrame extends JFrame {
	
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
//		setSize(300,300);
		
		JLabel infoLabel = new JLabel("Para Estimar a memória necessária, simplesmente selecione o arquivo utilizando o botão abaixo.");
		getContentPane().add(infoLabel, BorderLayout.NORTH);
		
		JButton selecionaArquivo = new JButton("Selecionar Arquivo");
		selecionaArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSelecionarArquivo();
			}
		});
		getContentPane().add(selecionaArquivo, BorderLayout.CENTER);
		
		
		JLabel memoriaLbl = new JLabel("Memoria necessária: ");
		memoriaNecessaria = new JTextField("?");
		memoriaNecessaria.setColumns(5);
		memoriaNecessaria.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel resultado = new JPanel();
		resultado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		resultado.add(memoriaLbl);
		resultado.add(memoriaNecessaria);
		getContentPane().add(resultado, BorderLayout.SOUTH);

		pack();
		//Centralizando a janela ao monitor
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void handleSelecionarArquivo(){

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		
		if( result != JFileChooser.CANCEL_OPTION )
		{
			File f = fileChooser.getSelectedFile();
			String filename = f.getAbsolutePath();
			try {
				memoriaNecessaria.setText(Integer.toString(CalculaMemoria.doArquivo(filename)));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Problemas ao fazer o parser do arquivo!\nVerifique se o arquivo contém apenas números!");
			}
		}else{
			memoriaNecessaria.setText("?");
		}
	}
	
	private void exitHandler(){

		int selection = JOptionPane.showConfirmDialog(this,"Tem certeza que quer sair?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if( selection == JOptionPane.YES_OPTION)
			System.exit( 0 );
	}
	
	@SuppressWarnings("unused")
	public static void main(String args[]) 
	{
		MainWindowFrame mainFrame = new MainWindowFrame();
	}
}