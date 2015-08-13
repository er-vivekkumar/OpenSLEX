package org.processmining.openslex.metamodel;

public interface SLEXMMStorage {

	public static final int TYPE_METAMODEL = 4;
	public static final String COMMON_CLASS_NAME = "COMMON";
	public static final String METAMODEL_FILE_EXTENSION = ".slexmm";

	public static final String PATH = "data";
	
	public abstract String getFilename();

	public abstract String getPath();

	public abstract int getType();

	public abstract void setAutoCommit(boolean autoCommit);

	public abstract void commit();

	public abstract void disconnect();

	public abstract void setAutoCommitOnCreation(boolean flag);

	public abstract boolean isAutoCommitOnCreationEnabled();

}