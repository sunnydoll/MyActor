/*
* Zhichao Cao
* zc77@drexel.edu
* CS530:DUI, Assignment 1
*/

import java.util.EventObject;


public class ActorListFormEvent extends EventObject {
	//Store the actor object information
	private String name;
	private String expression;
	private String tcolor;
	private String pcolor;
	private int height;
	private int width;
	private ActorObject ao;

	public ActorListFormEvent(Object source) {
		super(source);		
	}
	
	public ActorListFormEvent(Object source, ActorObject ao) {
		super(source);		
		
		this.ao = ao;
	}

	public ActorListFormEvent(Object source, String name, String expression, String tcolor, String pcolor, int height, int width) {
		super(source);		
		
		this.name = name;
		this.expression = expression;
		this.tcolor = tcolor;
		this.pcolor = pcolor;
		this.height = height;
		this.width = width;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getTcolor() {
		return tcolor;
	}

	public void setTcolor(String tcolor) {
		this.tcolor = tcolor;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public ActorObject getAo() {
		return ao;
	}

	public void setAo(ActorObject ao) {
		this.ao = ao;
	}	

}
