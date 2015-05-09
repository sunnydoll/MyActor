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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class ActorEditFormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel expLabel;
	private JLabel tColorLabel;
	private JLabel pColorLabel;
	private JLabel heightLabel;
	private JLabel widthLabel;
	public JTextField nameField;
	public JComboBox expList;
	public JComboBox tColorList;
	public JComboBox pColorList;
	public JTextField heightField;
	public JTextField widthField;
	private JButton btnShow;	//Preview the actor
	
	public ActorObject aoFormPanel;
	private ActorEditFormListener formListener;
	private MyActor ma;
	public int i = -1;	//Denote the actor if user clicks edit button in ActorList;
						//-1 is default value which means user clicks add button.
	
	public ActorEditFormPanel(ActorObject aoPassed) {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		ma = new MyActor();
		
		String[] expStrings = { "Happy", "Neutral", "Sad" };
		String[] colorStrings = {"Red", "Orange", "Yellow", "Green", "Cyan", "Blue"};
		
		nameLabel = new JLabel("Actor Name:");
		nameField = new JTextField(10);
		expLabel = new JLabel("Expression:");
		expList = new JComboBox<>(expStrings);
		tColorLabel = new JLabel("Shirt Color:");
		tColorList = new JComboBox<>(colorStrings);
		pColorLabel = new JLabel("Pants Color:");
		pColorList = new JComboBox<>(colorStrings);
		heightLabel = new JLabel("Height(Pixels):");
		heightField = new JTextField(5);
		widthLabel = new JLabel("Width(Pixels):");
		widthField = new JTextField(5);
		btnShow = new JButton("Preview");	
		
		if(aoPassed.getName() == null) {
//			If aoPassed.getName() == null, it means user clicks add button,else user clicks edit button
			aoFormPanel = new ActorObject();
		}
		else {
//			Else, let FormPanel get the information of actor which is chosen by user
			i = ma.aoList.indexOf(aoPassed);
			aoFormPanel = aoPassed;
			nameField.setText(aoFormPanel.getName());
			expList.setSelectedItem(aoFormPanel.getExpression());
			tColorList.setSelectedItem(aoFormPanel.getTColor());
			pColorList.setSelectedItem(aoFormPanel.getPColor());
			heightField.setText(String.valueOf(aoFormPanel.getHeight()));
			widthField.setText(String.valueOf(aoFormPanel.getWidth()));
		}
		
		btnShow.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
//				When user clicks Preview Button, get the information chosen by user 
				String name = nameField.getText();
				String expression = expList.getSelectedItem().toString();
				String tColor = tColorList.getSelectedItem().toString();
				String pColor = pColorList.getSelectedItem().toString();
				int height = 0;
				int width = 0;
				try {
					height = Integer.parseInt(heightField.getText());
					width = Integer.parseInt(widthField.getText());
				} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please enter integer in both width and height textfield, Thanks! ");
					return;
				}
				aoFormPanel.setName(name);
				aoFormPanel.setExpression(expression);
				aoFormPanel.setTcolor(tColor);
				aoFormPanel.setPcolor(pColor);
				aoFormPanel.setHeight(height);
				aoFormPanel.setWidth(width);
				ActorEditFormEvent ev = new ActorEditFormEvent(this, aoFormPanel);
				
				if(formListener != null) {
					formListener.formEventOccured(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Actor List");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();		
		
//		First Row
		gc.weightx = 1;
		gc.weighty = 0.8;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gc);
		
//		Second Row
		gc.weightx = 1;
		gc.weighty = 0.8;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(expLabel, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(expList, gc);
		
//		Third Row
		gc.weightx = 1;
		gc.weighty = 0.8;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(tColorLabel, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(tColorList, gc);
		
//		Fourth Row
		gc.weightx = 1;
		gc.weighty = 0.8;
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(pColorLabel, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(pColorList, gc);
		
//		Fifth Row
		gc.weightx = 1;
		gc.weighty = 0.8;
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(heightLabel, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(heightField, gc);
		
//		Sixth Row
		gc.weightx = 1;
		gc.weighty = 0.8;
		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(widthLabel, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(widthField, gc);
		
//		Seventh Row
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridx = 1;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(btnShow, gc);
	}
	
	public void setFormListener(ActorEditFormListener listener) {
		this.formListener = listener;
	}
}