/*
* Zhichao Cao
* zc77@drexel.edu
* CS530:DUI, Assignment 1
*/

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ActorEdit extends JFrame {

	private ActorEditDrawPanel drawPanel;
	private ActorEditToolbar toolbar;
	private ActorEditFormPanel formPanel;
	private ActorObject aoFormPanel;
	private MyActor ma;
	
	public ActorEdit(ActorObject aoPassed) {
		super("Edit Actor");
		
		setLayout(new BorderLayout());
		
		drawPanel = new ActorEditDrawPanel();
		toolbar = new ActorEditToolbar();
		formPanel = new ActorEditFormPanel(aoPassed);
		
		add(drawPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.SOUTH);
		add(formPanel, BorderLayout.WEST);
		
		toolbar.setStringListener(new ActorEditButtonListener() {
			public void textEmitted(String text) {
//				Listen to the buttons of the ToolbarPanel
				switch(text) {
					case "Cancel":
						aoFormPanel = new ActorObject();
						new ActorList().setVisible(true);
		                ActorEdit.this.setVisible(false);
		                break;				
					case "Save":
						int height = 0;
						int width = 0;
						try {
							height = Integer.parseInt(formPanel.heightField.getText());
							width = Integer.parseInt(formPanel.widthField.getText());
						} 
						catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Please enter integer in both width and height textfield, Thanks! ");
							return;
						}
						if(formPanel.nameField.getText() == null || formPanel.nameField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please enter name for the actor you created, Thanks! ");
							return;
						}
						aoFormPanel = new ActorObject(formPanel.nameField.getText(), formPanel.expList.getSelectedItem().toString(), formPanel.tColorList.getSelectedItem().toString(), formPanel.pColorList.getSelectedItem().toString(), height, width);
						ma = new MyActor();
						if(formPanel.i == -1) {
//							if i == -1, it means user clicks add button, then just add new actor object to list
							ma.aoList.add(aoFormPanel);
						}
						else {
//							else, user clicks edit button, then modify the actor object chosen by user in the list
							ma.aoList.set(formPanel.i, aoFormPanel);
						}
						new ActorList().setVisible(true);
		                ActorEdit.this.setVisible(false);
		                break;
				}
			}
			
		});
		
		formPanel.setFormListener(new ActorEditFormListener() {
			public void formEventOccured(ActorEditFormEvent e) {
//				Get the actor information which is chosen by user, and refresh DrawPanel
				aoFormPanel = e.getAo();
				drawPanel.ao = aoFormPanel; 
				drawPanel.drawing();
			}
		});
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}