package com.pojo;

public class Demo {
	private People peo;

	/**
	 * @return the peo
	 */
	public People getPeo() {
		return peo;
	}

	/**
	 * @param peo the peo to set
	 */
	public void setPeo(People peo) {
		this.peo = peo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Demo [peo=" + peo + "]";
	}
	

}
