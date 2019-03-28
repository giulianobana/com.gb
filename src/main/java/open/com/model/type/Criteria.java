package open.com.model.type;

import java.util.ArrayList;

public class Criteria {

	private ArrayList<Search> filter;
	private String sorting;
	private boolean unSecured;
	private int top;
	
	
	
	public int getTop() {
		return top;
	}


	public void setTop(int top) {
		this.top = top;
	}


	public boolean isUnSecured() {
		return unSecured;
	}


	public ArrayList<Search> getFilter() {
		return filter;
	}

	public void setFilter(ArrayList<Search> filter) {
		this.filter = filter;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}



	public void setUnSecured(boolean unSecured) {
		this.unSecured = unSecured;
	}


	
}
