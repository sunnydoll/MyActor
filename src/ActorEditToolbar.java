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
import javax.swing.JPanel;
import javax.swing.border.Border;


public class ActorEditToolbar extends JPanel implements ActionListener {
	
	private JButton btnOK;
	private JButton btnCancel;	
	
	private ActorEditFormListener formListener;
	private ActorEditButtonListener buttonListener;	//Listen to the buttons in ToolbarPanel of ActionEdit 
	
	public ActorEditToolbar() {
		btnOK = new JButton("Save");
		btnCancel = new JButton("Cancel");
		
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		add(btnOK);
		add(btnCancel);
		
		Border innerBorder = BorderFactory.createTitledBorder("");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}
	
	public void setStringListener(ActorEditButtonListener listener) {
		this.buttonListener = listener;
	}

//	Button click in ToolbarPanel
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();		
		if(buttonListener != null) {
			buttonListener.textEmitted(clicked.getText());
		}
	}
	
	public void setFormListener(ActorEditFormListener listener) {
		this.formListener = listener;
	}
}

