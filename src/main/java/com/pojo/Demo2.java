package com.pojo;

import java.util.List;

public class Demo2 {
	private List<People> peo;

	/**
	 * @return the peo
	 */
	public List<People> getPeo() {
		return peo;
	}

	/**
	 * @param peo the peo to set
	 */
	public void setPeo(List<People> peo) {
		this.peo = peo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Demo2 [peo=" + peo + "]";
	}


}
