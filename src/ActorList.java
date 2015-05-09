/*
* Zhichao Cao
* zc77@drexel.edu
* CS530:DUI, Assignment 1
*/

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActorList extends JFrame {

	private ActorListDrawPanel drawPanel;
	private ActorListToolbar toolbar;
	private ActorListFormPanel formPanel;
	public ActorObject aoFormPanel;
	private MyActor ma;
	
	public ActorList() {
		super("Actor List");		
		
		setLayout(new BorderLayout());
		
		drawPanel = new ActorListDrawPanel();
		toolbar = new ActorListToolbar();
		formPanel = new ActorListFormPanel();
		ma = new MyActor();
		
		add(drawPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.SOUTH);
		add(formPanel, BorderLayout.WEST);		
		
		toolbar.setButtonListener(new ActorListButtonListener() {
			public void textEmitted(String text) {
//				Listen to the buttons of ToolbarPanel
				switch(text) {
					case "Add Actor":
						aoFormPanel = new ActorObject();
						new ActorEdit(aoFormPanel).setVisible(true);
		                ActorList.this.setVisible(false);
						break;
					case "Edit Actor":
						String actorNameEdit = "";
						try {
							actorNameEdit = formPanel.actorList.getSelectedValue().toString();
						}
						catch (Exception e) {						
							JOptionPane.showMessageDialog(null, "Please pick one actor in actorlist to edit, Thanks! ");
							return;
						}
						aoFormPanel = (ActorObject) formPanel.actorList.getSelectedValue();
						new ActorEdit(aoFormPanel).setVisible(true);
			            ActorList.this.setVisible(false);						
						break;
					case "Delete Actor":
						String actorNameDel = "";
						try {
							actorNameDel = formPanel.actorList.getSelectedValue().toString();
						}
						catch (Exception e) {						
							JOptionPane.showMessageDialog(null, "Please pick one actor in actorlist to delete, Thanks! ");
							return;
						}
						if(JOptionPane.showConfirmDialog(null, "Confirm to delete?", "Confirm",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//							Message box that lets user confirm to delete the actor 
							aoFormPanel = (ActorObject) formPanel.actorList.getSelectedValue();
							ma.aoList.remove(ma.aoList.indexOf(aoFormPanel));
							formPanel.actorModel.removeElement(aoFormPanel);
							formPanel.actorList.repaint();	//Refresh actor list
						}
						else {
							return;
						}
						break;
				}
			}			
		});		
		
		formPanel.setFormListener(new ActorListFormListener() {
			public void formEventOccured(ActorListFormEvent e) {
//				Get the actor object which is chosen by user, and refresh DrawPanel
				aoFormPanel = e.getAo();
				drawPanel.ao = aoFormPanel; 
				drawPanel.drawing();
			}
		});
		
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}