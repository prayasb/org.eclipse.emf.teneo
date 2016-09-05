# Teneo legacy repository

This repository consists of the legacy code based off the [1.2.0 maintenance Teneo repository](https://git.eclipse.org/c/teneo/org.eclipse.emf.teneo.git/log/?h=1.2.0-maintenance). More information about the project can be found in the [Teneo Wiki](http://wiki.eclipse.org/Teneo).

The code in this repository exists to serve older legacy systems where library upgrade is not an option, however, it is highly recommended to update to the latest version and not to rely on this repo.

### Dependencies

The ant script that is used to build the features, plugins, and maven compatible libraries makes sure that the following dependencies are fulfilled. Since older versions that support the build are not easily available, they are included as a part of this repository in the `build/dependencies/`. More information about the library and versions can be found [here](build/dependencies/README.md).

#### Director
A headless eclipse director is downloaded to further install the [Buckminster](https://eclipse.org/buckminster/) plugin. Path to the archived update site in the repository: `build/dependencies/director.zip`.

#### Buckminster
The buckminster plugin is used to assemble the features and plugins, perform tests, and generate the required jars. Path to the archived update site in the repository: `build/dependencies/buckminster.zip`.

#### Third party libraries
A limited set of third party library features and plugins are required in order to build this project successfully. Since legacy code is not easily available and older update site no longer exists, the [org.eclispe.emf.teneo-dependencies](https://github.com/prayasb/org.eclipse.emf.teneo-dependencies) repository can be used to fulfill this requirement. The most recent update site built from the repository is included in `build/dependencies/thirdparty.zip`.

### Build

Ant scripts are setup to build, test, and compose all the necessary features, plugins, update sites, and maven compatible jars.

#### Requirements
Following tools and libraries have been used for the most recent stable build:
- Apache Ant(TM) version 1.9.4
- Java SE 1.6

#### Environment setup
- `JAVA_HOME` environment variable should be set to point to the Java SE 1.6 base directory.
- Since remote URLs are mostly obsolete, the dependencies are already included as archives, thus, the build refers to local repository path for preparing the build environment by default. Setting the `USE_REMOTE=true` environment variable, however, forces the script to use remote URLs that are setup in the [buckminster.properties](build/org.eclipse.emf.teneo.releng.buckminster/buckminster.properties) file.

#### Running the Ant build
The ant `build.xml` file is located in the [buckminster build project](build/org.eclipse.emf.teneo.releng.buckminster). Follow the steps below to build the project:
- From terminal, change to the buckminster build directory where the ant build script exists
- Run `ant` command (assuming it is in your `PATH`)
  - the default task will build and test everything
- A `build/result` directory is created after everything is successful. This directory will contain the p2 site, maven libraries, and test output
