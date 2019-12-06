package br.com.ufc.view;

import java.awt.EventQueue;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.ufc.controller.AgendaController;
import br.com.ufc.model.Contato;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Application extends JFrame {

	private JPanel contentPane;
	private AgendaController AgendaCON;
	int qtButton = 0;
	private JTextField contato;
	private JTextField telefone;
	private JTextField email;
	private JTextField delContato;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setSize(240, 400);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Application() {
		AgendaCON = new AgendaController();
		fillAgenda();
		setTitle("Agenda Telefonica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(240, 400));
		setBounds(100, 100, 240, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(5, 10, 228, 320);
        scroll.setPreferredSize(new Dimension(228, 320));

        JPanel contacts = new JPanel();
        contacts.setLayout(new GridLayout(0, 1, 10, 10));
		
//        for(int i = 0; i < 15; i++) {
//        	contacts.add(gerarButton());
//        }
        
        viewContacts(contacts);
        
		JPanel navigator = new JPanel();
		navigator.setBounds(5, 335, 228, 35);
		navigator.setLayout(new GridLayout(0, 3, 10, 10));
		navigator.setPreferredSize(new Dimension(228, 35));
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 10, 228, 320);
		layeredPane.setPreferredSize(new Dimension(228, 320));
		layeredPane.setLayout(null);
		
		scroll.setVisible(true);
		
		scroll.setViewportView(contacts);
		contentPane.add(scroll);
		contentPane.add(layeredPane);
		contentPane.add(navigator);
		
		JPanel register = new JPanel();
		register.setBounds(1, 1, 224, 316);
		layeredPane.add(register);
		
		JLabel lblNome = new JLabel("Contato");
		
		contato = new JTextField();
		contato.setColumns(10);
		contato.setVisible(false);
		
		JLabel lblTeleone = new JLabel("Telefone");
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setVisible(false);
		
		JLabel lblEmail = new JLabel("E-mail");
		
		email = new JTextField();
		email.setColumns(10);
		email.setVisible(false);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setVisible(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(contato.getText().equals("") || telefone.getText().equals("") || email.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Dados invalidos!!!");
				}else {
					if(JOptionPane.showConfirmDialog(null, "Confirmar novo contato!", "Confirmar contato", JOptionPane.OK_CANCEL_OPTION) == 0) {
						AgendaCON.addContato(contato.getText(), telefone.getText(), email.getText());
						clear();
						viewContacts(contacts);
					}
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setVisible(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		GroupLayout gl_register = new GroupLayout(register);
		gl_register.setHorizontalGroup(
			gl_register.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_register.createSequentialGroup()
					.addGap(87)
					.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(83))
				.addGroup(gl_register.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_register.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(email, Alignment.LEADING)
						.addComponent(telefone, Alignment.LEADING)
						.addComponent(contato, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_register.createSequentialGroup()
					.addGap(91)
					.addComponent(lblEmail)
					.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(gl_register.createSequentialGroup()
					.addGap(83)
					.addComponent(lblTeleone, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(83))
				.addGroup(Alignment.TRAILING, gl_register.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLimpar)
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addContainerGap())
		);
		gl_register.setVerticalGroup(
			gl_register.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_register.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(contato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(lblTeleone)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(telefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_register.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnLimpar))
					.addGap(21))
		);
		register.setLayout(gl_register);
		
		JPanel delete = new JPanel();
		delete.setBounds(1, 1, 224, 316);
		layeredPane.add(delete);
		
		JLabel lblApagarContato = new JLabel("Apagar - Contato");
		
		delContato = new JTextField();
		delContato.setColumns(10);
		delContato.setVisible(false);
		
		JButton btnDelContato = new JButton("Apagar");
		btnDelContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(delContato.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Contato invalido");
				}else {
					if(AgendaCON.rmContato(delContato.getText())) {
						JOptionPane.showMessageDialog(null, "Contato apagado!");
						clear();
						viewContacts(contacts);
					}else {
						JOptionPane.showMessageDialog(null, "Nao foi possivel efetuar a operacao!!!");
						clear();
					}
				}
			}
		});
		GroupLayout gl_delete = new GroupLayout(delete);
		gl_delete.setHorizontalGroup(
			gl_delete.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_delete.createSequentialGroup()
					.addGap(65)
					.addComponent(btnDelContato)
					.addContainerGap(76, Short.MAX_VALUE))
				.addGroup(gl_delete.createSequentialGroup()
					.addGap(28)
					.addComponent(delContato)
					.addGap(30))
				.addGroup(gl_delete.createSequentialGroup()
					.addGap(50)
					.addComponent(lblApagarContato)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_delete.setVerticalGroup(
			gl_delete.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_delete.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addComponent(lblApagarContato)
					.addGap(18)
					.addComponent(delContato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDelContato)
					.addGap(111))
		);
		delete.setLayout(gl_delete);
		
		JButton btnContacts = new JButton("LIST");
		btnContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				clear();
				scroll.setVisible(true);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		navigator.add(btnContacts);
		
		JButton btnRegister = new JButton("INS");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				clear();
				scroll.setVisible(false);
				contato.setVisible(true);
				telefone.setVisible(true);
				email.setVisible(true);
				btnLimpar.setVisible(true);
				btnSalvar.setVisible(true);
				layeredPane.add(register);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		navigator.add(btnRegister);
		
//		JButton btnSearch = new JButton("c");
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//			}
//		});
//		navigator.add(btnSearch);
		
		JButton btnDelete = new JButton("DEL");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				clear();
				scroll.setVisible(false);
				delContato.setVisible(true);
				layeredPane.add(delete);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		navigator.add(btnDelete);		
	}
	
    public JButton gerarButton() {

        qtButton++;
        JButton NewButton = new JButton(String.valueOf(qtButton));
        return NewButton;
    }
    
    public void clear() {
    	contato.setText("");
    	telefone.setText("");
    	email.setText("");
    	delContato.setText("");
    }
	
	public void viewContacts(JPanel jpanel) {
		jpanel.removeAll();
		LinkedList<Contato> contatos = AgendaCON.getAgenda();
		for(int i = 0; i < contatos.size(); i++) {
			JButton contato = new JButton(contatos.get(i).getNome() + " - " + contatos.get(i).getTelefones().get(0).getNumero());
			jpanel.add(contato);
		}
	}
	
	private void fillAgenda() {
		String contato = "Contato";
		String telefone = "0000000";
		for(int i = 0; i < 10; i++) {
			AgendaCON.addContato(contato + "" + i, telefone + "" + i, contato + "@" + telefone);
		}
	}
}