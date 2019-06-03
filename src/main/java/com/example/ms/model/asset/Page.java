package com.example.ms.model.asset;

public class Page
{
    private String number;

    private String size;

    private String totalPages;

    private String totalElements;

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    public String getTotalPages ()
    {
        return totalPages;
    }

    public void setTotalPages (String totalPages)
    {
        this.totalPages = totalPages;
    }

    public String getTotalElements ()
    {
        return totalElements;
    }

    public void setTotalElements (String totalElements)
    {
        this.totalElements = totalElements;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [number = "+number+", size = "+size+", totalPages = "+totalPages+", totalElements = "+totalElements+"]";
    }
}
