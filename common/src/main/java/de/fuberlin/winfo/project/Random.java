package de.fuberlin.winfo.project;

public class Random extends java.util.Random {
	private static Random INStANCE = new Random();

	private Random() {
		super(0);
	}

	public static Random get() {
		return INStANCE;
	}

}
