package com.example.ms.model.asset;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Links {
	private ParentLink parent;

	private VariableLink variables;

	private DownloadLink download;

	private MetaDataLink metadata;

	private ChildrenLink children;

	private AspectLink aspects;

	private Self self;

	private LocationLink location;

	public ParentLink getParent() {
		return parent;
	}

	@JsonDeserialize(as = ParentLink.class)
	public void setParent(ParentLink parent) {
		this.parent = parent;
	}

	public VariableLink getVariables() {
		return variables;
	}

	@JsonDeserialize(as = VariableLink.class)
	public void setVariables(VariableLink variables) {
		this.variables = variables;
	}

	public DownloadLink getDownloadLink() {
		return download;
	}

	@JsonDeserialize(as = DownloadLink.class)
	public void setDownloadLink(DownloadLink download) {
		this.download = download;
	}

	public MetaDataLink getMetadata() {
		return metadata;
	}

	@JsonDeserialize(as = MetaDataLink.class)
	public void setMetadata(MetaDataLink metadata) {
		this.metadata = metadata;
	}

	public ChildrenLink getChildrenLink() {
		return children;
	}

	@JsonDeserialize(as = ChildrenLink.class)
	public void setChildrenLink(ChildrenLink children) {
		this.children = children;
	}

	public AspectLink getAspects() {
		return aspects;
	}

	@JsonDeserialize(as = AspectLink.class)
	public void setAspects(AspectLink aspects) {
		this.aspects = aspects;
	}

	public Self getSelf() {
		return self;
	}

	@JsonDeserialize(as = Self.class)
	public void setSelf(Self self) {
		this.self = self;
	}

	public LocationLink getLocation() {
		return location;
	}

	@JsonDeserialize(as = LocationLink.class)
	public void setLocation(LocationLink location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ClassPojo [parent = " + parent + ", variables = " + variables + ", download = " + download
				+ ", metadata = " + metadata + ", children = " + children + ", aspects = " + aspects + ", self = "
				+ self + ", location = " + location + "]";
	}
}
