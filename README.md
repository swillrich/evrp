# vrp
This repository contains an implementation (a Route Planning System (RPS)) to solve the Vehicle Routing Problem.

The project is built by Maven (tested and executable with Maven version 3.3.3 (mvn --version)) and consists of several Maven sub modules shown as sub folders in the root directory (except the repo folder).

#### The sub folder in more detail as follows

##### repo
The repo folder is a maven in-project repository which contains primarily all 3rd-party dependencies being inaccessible by the public maven repositories.

##### input
This maven sub module handles the incoming data and can be used in order to pass the data to the RPS. For this purpose, the interface `de.fuberlin.winfo.project.input.VRPInput` must be implemented. Then, the implementation (the object) can be passed as parameter to `de.fuberlin.winfo.project.RoutePlanningSystem`. Note that, in order to avoid malfunction, implement all methods specified by the interface.

##### common
The common sub module contains functionality which are commonly used. This sub module shares this functionality with, e.g., the core or the visualization sub modules.

##### core
The core project can be understood as the main sub module because this sub module orchestrates all the other sub modules and let them play together in order to run as a RPS. 

The `de.fuberlin.winfo.project.RoutePlanningSystem` class is part of it and labels the main controller. The `de.fuberlin.winfo.project.output` package contains classes to deliver the network and the solution objects to the visualization server if a visualization server was specified by the `de.fuberlin.winfo.project.input.VRPInput` implementation. Otherwise the visualization server address resolves in being null and no visualization server is used. 

Furthermore, the package `de.fuberlin.winfo.project.algorithm` contains all algorithm implementations. Each implementation inherits from the abstract super class `de.fuberlin.winfo.project.algorithm.Algorithm`. Once a implementation is given, the class must be announced by the `de.fuberlin.winfo.project.algorithm.Algorithms` collection class by adding an instance in the initialization constructor. Only then, the algorithm implementation can be used in `de.fuberlin.winfo.project.input.VRPInput` without resulting in malfunction or IndexOutOfBoundsExceptions. The abstract algorithm super class cares about adding the given solution to the network.

##### model
The sub module model contains the domain model. The domain model is specified by Eclipse Modeling Framework (EMF) and is serialized by .ecore. With the EMF Eclipse Extension, the domain model can be customized in any way desired. Only two steps are required: redesign the ecore model and open the .genmodel file and rebuild the classes (the java classes will be derived automatically by the ecore model and placed within the model project). Afterwards, the previous java domain model implementation is getting overwritten. Normally (tested with Eclipse), the changes take effect immediately and can be used in other sub modules, i.e., the core sub module.

In addition, the graphical model is provided by the .aird file which is also located in the model folder. To enjoy this feature, the installation of another Eclipse plugin is required (http://www.eclipse.org/ecoretools/doc/).

##### visualization

The visualization sub module contains a visualization server. The server can be started by invoking the main method in `de.fuberlin.winfo.project.visualization.web.start.GuiStart` whereupon the server including an interactive user interface starts. If not changed by other, the port is 8080. The port can also be reconfigured in this `GuiStart` class while instantiating the `VisualizationServer` class. The server can be serviced by multiple networks and solutions. The RPS can called repeatedly while the visualization server needs to be invoked once. For each RPS call, the solution can be forwarded to the visualization server which takes care to provide all data received by the RPS. This is realized by a transient cache. In other words: If the server goes down, the data are lost. As long as the server is running, the data are getting collected.
