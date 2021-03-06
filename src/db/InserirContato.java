package db;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rosicléia Frasson
 */
public class InserirContato extends JFrame {
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JLabel lbEmail;
	private JLabel lbLogradouro; 
	private JTextField txNome;
	private JTextField txTelefone;
	private JTextField txEmail;
	private JTextField txLogradouro; 

	public InserirContato(DefaultTableModel md) {
		super("Contatos");
		criaJanela();
		modelo = md;
	}

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbNome = new JLabel("         Nome.:   ");
		lbTelefone = new JLabel("         Telefone.:   ");
		lbEmail = new JLabel("         Email.:   ");
		lbLogradouro = new JLabel ("Logradouro.:");
		txNome = new JTextField(10);
		txTelefone = new JTextField();
		txEmail = new JTextField();
		txLogradouro = new JTextField() ; 

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(6, 2, 2, 4));
		painelFundo.add(lbNome);
		painelFundo.add(txNome);
		painelFundo.add(lbTelefone);
		painelFundo.add(txTelefone);
		painelFundo.add(lbEmail);
		painelFundo.add(txEmail);
		painelFundo.add(lbLogradouro) ; 
		painelFundo.add(txLogradouro) ; 
		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);
		btSalvar.addActionListener(new BtSalvarListener());
		btLimpar.addActionListener(new BtLimparListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Contato c = new Contato();
			c.setNome(txNome.getText());
			c.setTelefone(txTelefone.getText());
			c.setEmail(txEmail.getText());
			c.setLogradouro(txLogradouro.getText());

			ContatoDao dao = new ContatoDao();
			dao.inserir(c);
			ListarContato.pesquisar(modelo);

			setVisible(false);
		}
	}



	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			txTelefone.setText("");
			txEmail.setText("");
			txLogradouro.setText("");
		}
	}
}