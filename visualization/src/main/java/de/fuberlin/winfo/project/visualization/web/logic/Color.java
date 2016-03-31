package de.fuberlin.winfo.project.visualization.web.logic;

public enum Color {
//	RED(255, 0, 0), 
//	GREEN(0, 255, 0), 
//	YELLOW(255, 255, 0), 
//	BLUE(0, 0, 255), 
//	BLACK(0,0, 0),
//	GREY(100, 100, 100),
//	DARKHAIK(189, 183, 107), 
//	DARKORANGE(255,140,0),
//	SKYBLUE(73, 255, 253),
//	WHITE(255, 255, 255), 
//	CHARTRAUSE(127,255,0),
//	PURPLE(141, 39, 214);
	
	Green(0, 255, 0),
	Gold(255, 215, 0),
	DarkSlateGray(47, 79, 79),
	MidnightBlue(25, 25, 112),
	RosyBrown(188, 143, 143),
	CornflowerBlue(100, 149, 237),
	DarkGreen(0, 100, 0),
	DimGrey(105, 105, 105),
	SaddleBrown(139, 69, 19),
	MediumSlateBlue(123, 104, 238),
	Chocolate(210, 105, 30),
	DodgerBlue(30, 144, 255),
	Firebrick(178, 34, 34),
	SteelBlue(70, 130, 180),
	DeepPink(255, 20, 147),
	SlateGrey(112, 128, 144),
	Cyan(0, 255, 255),
	Maroon(176, 48, 96),
	DarkSeaGreen(143, 188, 143),
	Magenta(255, 0, 255),
	MediumPurple(147, 112, 219),
	DarkViolet(148, 0, 211);
	
	
	private int a, b, c;

	private Color(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public static String getColor(int index) {
		int i = index % Color.values().length;
		Color color = Color.values()[i];
		return byString(color.a, color.b, color.c);
	}

	public static String byString(int a, int b, int c) {
		int rgb = new java.awt.Color(a, b, c).getRGB();
		return "#" + Integer.toHexString(rgb).substring(2);
	}

}
