package de.fuberlin.winfo.project.algorithm.restriction;

public class RestrictionException extends Exception {

	private Class<? extends Restriction> clazz;

	public RestrictionException(Class<? extends Restriction> clazz, String string) {
		super(string);
		this.clazz = clazz;
	}

	public Class<? extends Restriction> getClazz() {
		return clazz;
	};

}
