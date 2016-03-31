package de.fuberlin.winfo.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.NetworkPackage;

public class XMIIO {

	public static Network deserialize(InputStream inputStream) throws IOException {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("network", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		Map packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(NetworkPackage.eNS_URI, NetworkPackage.eINSTANCE);
		XMIResourceImpl xmiResourceImpl = (XMIResourceImpl) new ResourceSetImpl()
				.createResource(URI.createFileURI("data.network"));
		xmiResourceImpl.load(inputStream, Collections.EMPTY_MAP);
		return (Network) xmiResourceImpl.getContents().get(0);
	}

	public static void serialize(Network network, OutputStream outputStream) throws IOException {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("network", new XMIResourceFactoryImpl());
		Resource resource = new ResourceSetImpl().createResource(URI.createFileURI("data.network"));
		resource.getContents().add(network);
		resource.save(outputStream, Collections.EMPTY_MAP);
	}
}
