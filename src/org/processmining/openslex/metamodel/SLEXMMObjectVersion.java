/*
 * 
 */
package org.processmining.openslex.metamodel;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class SLEXMMObjectVersion.
 *
 * @author <a href="mailto:e.gonzalez@tue.nl">Eduardo Gonzalez Lopez de Murillas</a>
 * @see <a href="https://www.win.tue.nl/~egonzale/projects/openslex/" target="_blank">OpenSLEX</a>
 */
public class SLEXMMObjectVersion extends AbstractDBElementWithAtts<SLEXMMAttribute, SLEXMMAttributeValue> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7322852284760266403L;

	/** The object id. */
	private int objectId = -1;
	
	/** The start timestamp. */
	private long startTimestamp = -1;
	
	/** The end timestamp. */
	private long endTimestamp = -1;
	
	/**
	 * Instantiates a new SLEXMM object version.
	 *
	 * @param storage the storage
	 */
	protected SLEXMMObjectVersion(SLEXMMStorageMetaModel storage) {
		super(storage);
	}
	
	/**
	 * Gets the storage.
	 *
	 * @return the storage
	 */
	public SLEXMMStorageMetaModel getStorage() {
		return (SLEXMMStorageMetaModel) super.storage;
	}
	
	/**
	 * Gets the object id.
	 *
	 * @return the object id
	 */
	public int getObjectId() {
		return this.objectId;
	}
		
	/**
	 * Gets the start timestamp.
	 *
	 * @return the start timestamp
	 */
	public long getStartTimestamp() {
		return this.startTimestamp;
	}
	
	/**
	 * Gets the end timestamp.
	 *
	 * @return the end timestamp
	 */
	public long getEndTimestamp() {
		return this.endTimestamp;
	}
	
	/**
	 * Sets the object id.
	 *
	 * @param id the new object id
	 */
	protected void setObjectId(int id) {
		this.objectId = id;
		setDirty(true);
	}
	
	/**
	 * Sets the start timestamp.
	 *
	 * @param timestamp the new start timestamp
	 */
	protected void setStartTimestamp(long timestamp) {
		this.startTimestamp = timestamp;
		setDirty(true);
	}
	
	/**
	 * Sets the end timestamp.
	 *
	 * @param timestamp the new end timestamp
	 */
	protected void setEndTimestamp(long timestamp) {
		this.endTimestamp = timestamp;
		setDirty(true);
	}
		
	/**
	 * Adds the.
	 *
	 * @param ev the ev
	 * @param label the label
	 * @return true, if successful
	 */
	public boolean add(SLEXMMEvent ev, String label) {
		return getStorage().addEventToObjectVersion(this,ev,label);
	}
	
	/**
	 * Adds the.
	 *
	 * @param eventId the event id
	 * @param label the label
	 * @return true, if successful
	 */
	public boolean add(int eventId, String label) {
		return getStorage().addEventToObjectVersion(this.getId(),eventId,label);
	}
	
	/* (non-Javadoc)
	 * @see org.processmining.openslex.metamodel.SLEXMMAbstractDatabaseObject#insert(org.processmining.openslex.metamodel.SLEXMMAbstractDatabaseObject)
	 */
	@Override
	boolean insert(AbstractDBElement e) {
		return getStorage().insert((SLEXMMObjectVersion)e);
	}

	/* (non-Javadoc)
	 * @see org.processmining.openslex.metamodel.SLEXMMAbstractDatabaseObject#update(org.processmining.openslex.metamodel.SLEXMMAbstractDatabaseObject)
	 */
	@Override
	boolean update(AbstractDBElement e) {
		return getStorage().update((SLEXMMObjectVersion)e);
	}

	@Override
	protected HashMap<SLEXMMAttribute, SLEXMMAttributeValue> queryAttributeValues() {
		return getStorage().getAttributeValuesForObjectVersion(this);
	}
	
}
