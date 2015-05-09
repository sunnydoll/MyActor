/*
* Zhichao Cao
* zc77@drexel.edu
* CS530:DUI, Assignment 1
*/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class ActorListToolbar extends JPanel implements ActionListener {
	
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDel;
	
	private ActorListFormPanel formPanel;
	
	private ActorListButtonListener buttonListener;	//Listen to the buttons in ToolbarPanel of ActionList 
	
	public ActorListToolbar() {
		btnAdd = new JButton("Add Actor");
		btnEdit = new JButton("Edit Actor");
		btnDel = new JButton("Delete Actor");
		
		btnAdd.addActionListener(this);
		btnEdit.addActionListener(this);
		btnDel.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		add(btnAdd);
		add(btnEdit);
		add(btnDel);
		
		Border innerBorder = BorderFactory.createTitledBorder("");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
	
	public void setButtonListener(ActorListButtonListener listener) {
		this.buttonListener = listener;
	}

//	Button click in ToolbarPanel
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if(buttonListener != null) {buttonListener.textEmitted(clicked.getText());
		}
	}
}
