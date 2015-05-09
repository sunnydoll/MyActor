/*
* Zhichao Cao
* zc77@drexel.edu
* CS530:DUI, Assignment 1
*/

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;


public class ActorListFormPanel extends JPanel {
	
	public JList actorList;
	private JButton btnShow;	//Preview the actor
	private ActorListFormListener formListener;
	public DefaultListModel actorModel;
	private MyActor ma;
	
	public ActorListFormPanel() {
		actorList = new JList<>();
		btnShow = new JButton("Show Actor");
		ma = new MyActor();

		actorModel = new DefaultListModel();
		if(ma.aoList.size() == 0) {
			actorList.setModel(actorModel);
		}
		else {	//If it has actors added by user, it has to add them in action list
			for(int i = 0; i < ma.aoList.size(); i++) {
				actorModel.addElement(ma.aoList.get(i));
			}
			actorList.setModel(actorModel);
		}
		actorList.setPreferredSize(new Dimension(200, 300));
		actorList.setBorder(BorderFactory.createEtchedBorder());
		actorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		Border innerBorder = BorderFactory.createTitledBorder("Actor List");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();		
		
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(actorList, gc);
		gc.weightx = 0;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(btnShow, gc);
		
		btnShow.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				ActorObject ao = (ActorObject) actorList.getSelectedValue();
				ActorListFormEvent ev = new ActorListFormEvent(this, ao);
				//Get the actor object chosen by user, pass it to the formevent class, 
				//then ActionList frame can get it.
				if(formListener != null) {
					formListener.formEventOccured(ev);
				}
			}
		});
		
	}	

	public void setFormListener(ActorListFormListener listener) {
		this.formListener = listener;
	}
	
}
