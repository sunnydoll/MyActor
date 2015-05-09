/*
* Zhichao Cao
* zc77@drexel.edu
* CS530:DUI, Assignment 1
*/

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MyActor 
{
	public static ArrayList aoList = new ArrayList();	//Collect the Actor Object
	public static void main(String[] args) {		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ActorList();
			}			
		});		
		
	}
}
