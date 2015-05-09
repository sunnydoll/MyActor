/*
* Zhichao Cao
* zc77@drexel.edu
* CS530:DUI, Assignment 1
*/

public class ActorObject {
//	Actor Object
	private String name;	//Actor name
	private String expression;	//Actor expression
	private String tcolor;	//Actor shirt color
	private String pcolor;	//Actor pants color
	private int height;	//Actor height
	private int width;	//Actor weight
	
	public ActorObject() {
		this.name = null;
		this.expression = null;
		this.tcolor = null;
		this.pcolor = null;
		this.height = 0;
		this.width = 0;
	}
	
	public ActorObject(String name, String expression, String tcolor, String pcolor, int height, int width) {

		this.name = name;
		this.expression = expression;
		this.tcolor = tcolor;
		this.pcolor = pcolor;
		this.height = height;
		this.width = width;
	}
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getExpression() {
		return expression;
	}
	
	public String getTColor() {
		return tcolor;
	}
	
	public String getPColor() {
		return pcolor;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public void setTcolor(String tcolor) {
		this.tcolor = tcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
