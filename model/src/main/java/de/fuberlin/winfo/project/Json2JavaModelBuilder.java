package de.fuberlin.winfo.project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JCodeModel;

public class Json2JavaModelBuilder {

	public static void main(String[] args) {
		for (File file : Paths.get("model", "json").toFile().listFiles()) {
			try {
				new Json2JavaModelBuilder(file.toURL(), file.getName(),
						"de.fuberlin.winfo.project.model.input.webservice");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Json2JavaModelBuilder(URL source, String className, String packageName) throws IOException {
		JCodeModel codeModel = new JCodeModel();

		GenerationConfig config = new DefaultGenerationConfig() {
			@Override
			public boolean isGenerateBuilders() {
				return true;
			}

			@Override
			public SourceType getSourceType() {
				return SourceType.JSON;
			}

			@Override
			public boolean isUsePrimitives() {
				return true;
			}

			@Override
			public boolean isUseLongIntegers() {
				return true;
			}

			@Override
			public boolean isIncludeToString() {
				return true;
			}
		};

		System.out.println(config.getSourceType());

		SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(), new SchemaStore()),
				new SchemaGenerator());
		mapper.generate(codeModel, className, packageName, source);

		File dest = new File("src/main/java/");
		System.out.println("Generate JSON Class files for " + source.toString() + " with Packagename " + packageName
				+ " and Classname " + className);
		dest.mkdirs();
		codeModel.build(dest);
	}
}
