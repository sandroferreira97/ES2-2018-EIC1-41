package generic;

public class Variable {
	private String name;
	private String type;
	private int min;
	private int max;
	private int weight;
	
	public Variable(String name, String type, int min, int max, int weight){
		this.name=name;
		this.type=type;
		this.min = min;
		this.max = max;
		this.weight = weight;
	}
	
	
	public String getName() {
		return name;
	}
	
   
	public int getMin(){
		return min;
	}
   
	
	public int getMax(){
		return max;
	}
	
	public String getType(){
		return type;
	}  	
	
	public Object[] getVector(){
		Object[] x ={this.name,this.weight} ;
		return x;
	}

}
