import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;


public class Agenda {
	
	private List<TreeNode> root;
	private int tamanhoAgenda;
	
	public Agenda(){
		this.root = new ArrayList<TreeNode>();
		this.tamanhoAgenda = 0;
	}
	
	
	public void carregaNumerosDoArquivo(String arquivo) throws IOException{
		
		//Limpa dados anteriores
		this.tamanhoAgenda = 0;
		this.root = new ArrayList<TreeNode>();
		
		
		StringBuffer erroLog = new StringBuffer();
		BufferedReader in;
		String str;
		
		in = new BufferedReader( new FileReader(arquivo) );
		str = in.readLine();
		
		while( str != null )
		{
			if(str.length() > 0)
			{
				try{		
					
					Double.parseDouble(str);
					this.tamanhoAgenda += addNaArvore(root,str);
					
				}catch (NumberFormatException e){
					erroLog.append("Número '" + str + "' é inválido!\n");
				}
			}
			str = in.readLine();
		}

		in.close();
		
		if(erroLog.length() >0 ){
			JOptionPane.showMessageDialog(null, "Alguns números parecem ser inválidos, favor verificar arquivo de entrada.\n" + erroLog);
		}
	}
	
	public int getMemoriaUtilizada()
	{
		return this.tamanhoAgenda;
	}
	
	private int addNaArvore(List<TreeNode> node, String str)
	{
		int add = 0;
		int data = Integer.parseInt(str.substring(0, 1));
		TreeNode temp = new TreeNode(data);
		
		Collections.sort(node);
		int index = Collections.binarySearch(node, temp);
		
		if( index < 0 )
		{
			add = 1;
			node.add(temp);
			index = node.size()-1;
		}
		
		if(str.length() > 1)
		{
			return add + addNaArvore(node.get(index).children, str.substring(1));
		}else
		{
			return add;
		}
	}
	
}
