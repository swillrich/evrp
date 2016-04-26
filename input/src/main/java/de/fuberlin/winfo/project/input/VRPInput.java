package de.fuberlin.winfo.project.input;

import java.util.List;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.UseCase;

public interface VRPInput {
	public List<UseCase> getUseCases();
	public Locatables getLocatables();
	public Network getNetwork();
	public int getVerticesMaximum();
	public String getVisualizationServer();
	public int getDesiredProcedure();
}
