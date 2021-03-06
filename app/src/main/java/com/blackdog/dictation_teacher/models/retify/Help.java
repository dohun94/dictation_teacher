package com.blackdog.dictation_teacher.models.retify;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Help implements Serializable
{

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("nCorrectMethod")
    @Expose
    private int nCorrectMethod;

    public String getText ()
    {
        return text;
    }

    public void setText (String content)
    {
        this.text = content;
    }

    public int getNCorrectMethod ()
    {
        return nCorrectMethod;
    }

    public void setNCorrectMethod (int nCorrectMethod)
    {
        this.nCorrectMethod = nCorrectMethod;
    }

}
