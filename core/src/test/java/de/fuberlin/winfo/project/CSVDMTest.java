package de.fuberlin.winfo.project;

import de.fuberlin.winfo.project.input.CSV2ObjMapper;

public class CSVDMTest {
	public static void main(String[] args) throws Exception {
		CSV2ObjMapper mapper = CSV2ObjMapper.inflateByCSV(TestData.inputData);
		StaticLocatables locatabales = mapper.getLocatables();
		System.out.println(">>Basis");
		locatabales.print();
		System.out.println(
				">>Reinitializing by UseCase: " + mapper.getUseCaseList().get(0).getTranshipmentPoints().size());
		locatabales.reinitializeByUseCase(mapper.getUseCaseList().get(0));
		locatabales.print();
		System.out.println(
				">>Reinitializing by UseCase: " + mapper.getUseCaseList().get(1).getTranshipmentPoints().size());
		locatabales.reinitializeByUseCase(mapper.getUseCaseList().get(1));
		locatabales.print();
		System.out.println(">>REDUCE TO 50");
		locatabales.limitBy(50);
		locatabales.print();
		System.out.println(">>REDUCE TO 10");
		locatabales.limitBy(10);
		locatabales.print();
	}
}
