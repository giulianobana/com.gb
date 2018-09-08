package open.com.model.type;

import java.util.ArrayList;

public class Criteria {

	private ArrayList<Search> filter;
	private String sorting;

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
	
}
