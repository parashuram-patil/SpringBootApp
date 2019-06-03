package com.example.ms.model.asset;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class SearchAssetsByNameResponseModel {
	
	private Embedded _embedded;

    private Links _links;

    private Page page;

    public Embedded get_embedded ()
    {
        return _embedded;
    }

	@JsonDeserialize(as = Embedded.class)
    public void set_embedded (Embedded _embedded)
    {
        this._embedded = _embedded;
    }

    public Links get_links ()
    {
        return _links;
    }

    @JsonDeserialize(as = Links.class)
    public void set_links (Links _links)
    {
        this._links = _links;
    }

    public Page getPage ()
    {
        return page;
    }

    @JsonDeserialize(as = Page.class)
    public void setPage (Page page)
    {
        this.page = page;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [_embedded = "+_embedded+", _links = "+_links+", page = "+page+"]";
    }
}